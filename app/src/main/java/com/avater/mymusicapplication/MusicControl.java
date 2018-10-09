package com.avater.mymusicapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avatar on 2018/9/28.
 */

public enum MusicControl {
    INSTANCE;
    private static final String TAG = "MusicControl";
    private static final String GOOGLE_MUSIC = "com.google.android.music";                       //Google 音乐
    private static final String SPOTIFY_MUSIC = "com.spotify.music";                     //Spotify 音乐
    private static final String DEEZER_MUSIS = "deezer.android.app";                     //Deezer 音乐
    private static final String KUGOU_MUSIC = "com.kugou.android";                       //KuGou 音乐
    private static final String QQ_MUSIC = "com.tencent.qqmusic";                        //QQ 音乐
    private final int TYPE_MUSIC = 3;                                                    // music
    private Context mContext;
    private AudioManager mAudioManager;
    private byte[] bigBytes = null;                 // 大字节数组，用于接收超过20字节的数据
    private int pos = 0;                            // 存储位置
    private int bigBytesLen = 0;                    // 大字节数组的长度
    private boolean isBigBytesStartFlag = false;    // 大字节数组开始标志，以防中间数据出现以0x6F开始 以0x8F结尾的数据
    private boolean isMusicPlay = false;            //当前音乐是否在播放
    private List<MusicObject> musicList;
    private long lastTimeStame;                     //最近一次更新的时间戳
    private String lastMusicName;                   //最后一次更新的音乐的名称

    public void init(Context context) {
        mContext = context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        initMusicControl();
    }

    public boolean isContain(String packAgeName) {
        boolean result = false;
        for (int i = 0; i < musicList.size(); i++) {
            String packageName = musicList.get(i).getPackAgeName();
            if (packageName.contains(packAgeName)) {
                result = true;
                Logger.e(TAG, "包含 i == " + i);
                break;
            }
        }
        return result;
    }

    public synchronized void handleMusicData(MusicMessage musicMessage) {
        String packAgeName = musicMessage.getPackageName();
        long timeStame = System.currentTimeMillis();
        if (timeStame - lastTimeStame < 600) {//更新不能太频繁。几乎所有在通知栏捕获的音乐都会有N次的广播更新。
            Logger.e(TAG, "音乐更新已经频繁了，开始过滤的操作");
            String musicName = "";
            lastTimeStame = timeStame;
            switch (packAgeName) {
                case GOOGLE_MUSIC:
                    musicName = musicMessage.getName();
                    break;
                case SPOTIFY_MUSIC:

                    break;
                case DEEZER_MUSIS:

                    break;
                case QQ_MUSIC:
                    musicName = musicMessage.getContent();
                    break;
                case KUGOU_MUSIC:
                    musicName = musicMessage.getContent();
                    break;
            }
            Logger.e(TAG, "lastMusicName = " + lastMusicName + ", musicName = " + musicName);
            if (musicName.equals(lastMusicName)) {
                Logger.e(TAG, "音乐的状态相同，不进行操作");
                return;
            }
            lastMusicName = musicName;
        }
        boolean isPlayingMusic = checkMusicState();
        switch (packAgeName) {
            case GOOGLE_MUSIC:
                String google_music_name = musicMessage.getName();
                Logger.d(TAG, " google_music_name = " + google_music_name + (isPlayingMusic ? "正在播放" : "暂停播放"));
                setMusicStateToDevice(google_music_name, isPlayingMusic);
                break;
            case SPOTIFY_MUSIC:

                break;
            case DEEZER_MUSIS:

                break;
            case QQ_MUSIC:
                String qq_music_name = musicMessage.getContent();
                Logger.d(TAG, " qq_music_name = " + qq_music_name + (isPlayingMusic ? "，正在播放" : "，暂停播放"));
                setMusicStateToDevice(qq_music_name, isPlayingMusic);
                break;
            case KUGOU_MUSIC:
                String k_music_name = musicMessage.getContent();
                Logger.d(TAG, " k_music_name = " + k_music_name + (isPlayingMusic ? "正在播放" : "暂停播放"));
                setMusicStateToDevice(k_music_name, isPlayingMusic);
                break;
        }
        lastTimeStame = timeStame;
    }

    public void receiveBytesArray(byte[] bytes) {
        if (bytes != null && bytes.length > 2 && bytes[1] == (byte) 0xD2 && bytes[bytes.length - 2] == (byte) 0x00) {
            isBigBytesStartFlag = false;
        }
        if (bytes[0] == (byte) 0x6F && bytes[bytes.length - 1] == (byte) 0x8F && !isBigBytesStartFlag && IsSingleCommandByByDataLen(bytes)) {
            parseBytesArray(bytes);
        }
    }

    private void setMusicStateToDevice(String musicName, boolean isPlaying) {

    }

    private boolean IsSingleCommandByByDataLen(byte[] bytes) {
        int bytesLen = (int) (bytes[3] & 0xFF) + (int) ((bytes[4] & 0xFF) << 8);    // 命令解析出来的长度
        int realLen = bytes.length - 6;                                             // 真正接收到的长度
        if (bytesLen != realLen)
            Logger.i(TAG, "该命令虽然以0x6F开始,0x8F结束,但不是单条命令!!!");
        return bytesLen == realLen ? true : false;
    }

    private void initMusicControl() {
        musicList = new ArrayList<>();
        musicList.add(new MusicObject(GOOGLE_MUSIC, TYPE_MUSIC, (byte) 0xD0));
        musicList.add(new MusicObject(SPOTIFY_MUSIC, TYPE_MUSIC, (byte) 0xD0));
        musicList.add(new MusicObject(KUGOU_MUSIC, TYPE_MUSIC, (byte) 0xD0));
        musicList.add(new MusicObject(DEEZER_MUSIS, TYPE_MUSIC, (byte) 0xD0));
        musicList.add(new MusicObject(QQ_MUSIC, TYPE_MUSIC, (byte) 0xD0));
    }

    private void parseBytesArray(byte[] bytes) {
        byte commandCode = bytes[1];
        byte action = bytes[2];
        byte content = bytes[bytes.length - 2];
        int ret = -1;
        switch (commandCode) {
            case (byte) 0xD0:
                if (content == (byte) 0x00) {
                    // TODO: 2018/9/28  检查音乐的状态
                } else if (action == (byte) 0x71) {
                    setMusicState(content);
                }
                break;
        }
    }

    private void setMusicState(byte content) {
        switch (content) {
            case (byte) 0x00:
                // TODO: 2018/9/28 播放音乐
                break;
            case (byte) 0x01:
                // TODO: 2018/9/28 暂停音乐
                break;
            case (byte) 0x02:
                // TODO: 2018/9/28 上一首音乐
                break;
            case (byte) 0x03:
                // TODO: 2018/9/28 下一首音乐
                break;

        }
    }

    /**
     * QQ 音乐 播放的状态不能正确的识别
     *
     * @return
     */
    private boolean checkMusicState() {
//        int i = mAudioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
//        Logger.d(TAG, "返回的音乐的状态为 i = " + i);
//        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        isMusicPlay = mAudioManager.isMusicActive();
        return isMusicPlay;
    }

    private MyOnAudioListener myOnAudioListener = new MyOnAudioListener();

    private class MyOnAudioListener implements AudioManager.OnAudioFocusChangeListener {

        @Override
        public void onAudioFocusChange(int focusChange) {

        }
    }

    private BroadcastReceiver mMusicBR = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

}
