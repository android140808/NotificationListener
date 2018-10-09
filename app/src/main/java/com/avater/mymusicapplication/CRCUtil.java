package com.avater.mymusicapplication;

/**
 * 作者：hsh
 * 日期：2017/8/23
 * 说明：
 */

public class CRCUtil {

    /**
     * 字符串转CRC
     *
     * @param content 内容
     * @return CRC值
     */
    public static int stringToCRC16(String content) {
        int crc = -1;
        try {
//            byte[] bytes = content.getBytes("unicode");
//            byte[] realBytes = new byte[bytes.length - 2];
//            System.arraycopy(bytes, 2, realBytes, 0, realBytes.length);
            byte[] bytes = content.getBytes("UnicodeLittleUnmarked");
            byte[] realBytes = new byte[bytes.length];
            System.arraycopy(bytes, 0, realBytes, 0, realBytes.length);
            bytes = crc16(realBytes);
            crc = (int) bytesToLong(bytes, 0, bytes.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crc;
    }


    public static int byteToCRC16(byte[] realBytes) {
        int crc = -1;
        byte[] bytes = crc16(realBytes);
        crc = (int) bytesToLong(bytes, 0, bytes.length - 1);
        return crc;
    }

    /**
     * 字节数组转长整型
     *
     * @param bytes 字节数组
     * @param start 开始
     * @param end   结束(包含)
     * @return 长整型
     */
    private static long bytesToLong(byte[] bytes, int start, int end) {
        if (start > end) {
            return -1;
        }
        long sum = 0;
        for (int i = start, bit = 0; i < end + 1; i++, bit += 8) {
            long temp = (long) (bytes[i] & 0xff) << bit;
            sum += temp;
        }
        return sum;
    }

    // 计算crc16的值
    private static byte[] crc16(byte[] bytes) {
        byte[] crcBytes = new byte[2];
        int len = bytes.length;
        int crc = 0xFFFF;
        for (int i = 0; i < len; i++) {
            crc = ((short) ((crc >> 8) & 0xFF) | (crc << 8)) & 0xFFFF;
            crc ^= (short) (bytes[i] & 0xFF);
            crc ^= ((short) (crc & 0xFF) >> 4) & 0xFFFF;
            crc ^= ((crc << 8) << 4) & 0xFFFF;
            crc ^= ((crc & 0xff) << 4) << 1 & 0xFFFF;
        }
        crcBytes[0] = (byte) (crc & 0xFF);
        crcBytes[1] = (byte) ((crc >> 8) & 0xFF);
        return crcBytes;
    }
}
