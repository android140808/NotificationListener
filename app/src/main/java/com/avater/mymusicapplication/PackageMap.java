package com.avater.mymusicapplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9.
 */

public class PackageMap {

    //    public static final byte TYPE_SMS = (byte) 0x01;                                             // 短信
    public static final byte TYPE_SOCIAL = (byte) 0x02;                                             // 社交
    public static final byte TYPE_EMAIL = (byte) 0x03;                                              // 邮件
    public static final byte TYPE_CALENDAR = (byte) 0x04;                                           // 农历
    public static final byte TYPE_WECHAT = (byte) 0x07;                                             // 微信
    public static final byte TYPE_VIBER = (byte) 0x08;                                              // Viber
    public static final byte TYPE_SNAPCHAT = (byte) 0x09;                                           // Snapchat
    public static final byte TYPE_WHATSAPP = (byte) 0x0A;                                           // WhatsApp
    public static final byte TYPE_QQ = (byte) 0x0B;                                                 // QQ
    public static final byte TYPE_FACEBOOK = (byte) 0x0C;                                           // Facebook
    public static final byte TYPE_HANGOUTS = (byte) 0x0D;                                           // Hangouts
    public static final byte TYPE_GMAIL = (byte) 0x0E;                                              // Gmail
    public static final byte TYPE_MESSENGER = (byte) 0x0F;                                          // Facebook Messenger
    public static final byte TYPE_INSTAGRAM = (byte) 0x10;                                          // Instagram
    public static final byte TYPE_TWITTER = (byte) 0x11;                                            // Twitter
    public static final byte TYPE_LINKEDIN = (byte) 0x12;                                           // Linkedin
    public static final byte TYPE_UBER = (byte) 0x13;                                               // Uber
    public static final byte TYPE_LINE = (byte) 0x14;                                               // Line
    public static final byte TYPE_SKYPE = (byte) 0x15;                                              // Skype

    public static final byte TYPE_BOOKING = (byte) 0x17;                                            // Booking
    public static final byte TYPE_AIRBNB = (byte) 0x18;                                             // Airbnb
    public static final byte TYPE_FLIPBOARD = (byte) 0x19;                                          // Flipboard
    public static final byte TYPE_TELEGRAM = (byte) 0x1A;                                           // Telegram
    public static final byte TYPE_PANDORA = (byte) 0x1B;                                            // Pandora
    public static final byte TYPE_SPOTIFY = (byte) 0x1C;                                            // Spotify
    public static final byte TYPE_DROPBOX = (byte) 0x1D;                                            // Dropbox
    public static final byte TYPE_SHAZAM = (byte) 0x1E;                                             // Shazam
    public static final byte TYPE_LIFT = (byte) 0x1F;                                               // Lift
    public static final byte TYPE_WAZE = (byte) 0x20;                                               // Waze
    public static final byte TYPE_SLACK = (byte) 0x21;                                              // Slack
    public static final byte TYPE_DELIVEROO = (byte) 0x22;                                          // Deliveroo
    public static final byte TYPE_PINTEREST = (byte) 0x23;                                          // Pinterest
    public static final byte TYPE_NETFLIX = (byte) 0x24;                                            // Netflix
    public static final byte TYPE_YOUTUBE = (byte) 0x25;                                            // Youtube
    public static final byte TYPE_GOOGLEMAP = (byte) 0x26;                                          // GoogleMap
    public static final byte TYPE_LYFT = (byte) 0x27;                                               // Lyft
    public static final byte TYPE_VENMO = (byte) 0x28;                                              // Venmo
    public static final byte TYPE_PAYPAL = (byte) 0x29;                                             // PayPal

    public static final byte TYPE_AIRFRANCE = (byte) 0x2A;                                          // AirFrance
    public static final byte TYPE_BFMTV = (byte) 0x2B;                                              // Bfmtv
    public static final byte TYPE_BUSINESSINSIDER = (byte) 0x2C;                                    // BusinessInsider
    public static final byte TYPE_CNN = (byte) 0x2D;                                                // CNN
    public static final byte TYPE_IGeneration = (byte) 0x2E;                                        // IGeneration
    public static final byte TYPE_LEMONDE = (byte) 0x2F;                                            // Lemonde
    public static final byte TYPE_SPARK = (byte) 0x30;                                              // Spark
    public static final byte TYPE_OTHER = (byte) 0x31;                                              // Other
    public static final byte TYPE_ESPN = (byte) 0x32;                                               // espn
    //        public static final byte TYPE_VENMO = (byte) 0x33;                                        // venmo
    public static final byte TYPE_CASH = (byte) 0x34;                                               // cash
    public static final byte TYPE_TINDER = (byte) 0x35;                                             // tinder
    public static final byte TYPE_BUMBLE = (byte) 0x36;                                             // bumble
    public static final byte TYPE_BANK_OF_AMERICA_MOBILE = (byte) 0x37;                             // bank of america mobile
    public static final byte TYPE_WELLS_FAR_GO_MOBILE = (byte) 0x38;                                // wells far go mobile
    public static final byte TYPE_OUTLOOK = (byte) 0x39;                                            // outlook

    //蓝牙协议1.2.6
    public static final byte TYPE_LE_FIGARO = (byte) 0x3A;                                            // LeFigaro
    public static final byte TYPE_MORANDINI_BLOG = (byte) 0x3B;                                            // MorandiniBlog
    public static final byte TYPE_INDIEGOGO = (byte) 0x3C;                                            // Indiegogo
    public static final byte TYPE_KICKSTARTER = (byte) 0x3D;                                            // Kickstarter
    public static final byte TYPE_STRIPE_DASHBOARD = (byte) 0x3E;                                            // StripeDashboard
    public static final byte TYPE_KLM = (byte) 0x3F;                                            // KLM
    public static final byte TYPE_EASY_JET = (byte) 0x40;                                            // EasyJet
    public static final byte TYPE_SWISS = (byte) 0x41;                                            // SWISS
    public static final byte TYPE_LUFTHANSA = (byte) 0x42;                                            // Lufthansa
    public static final byte TYPE_AMERICAN_AIRLINES = (byte) 0x43;                                            // AmericanAirlines
    public static final byte TYPE_FLY_DELTA = (byte) 0x44;                                            // FlyDelta
    public static final byte TYPE_JET_SMARTER = (byte) 0x45;                                            // JetSmarter
    public static final byte TYPE_DIDI = (byte) 0x46;                                            // DiDi
    public static final byte TYPE_UBER_EATS = (byte) 0x47;                                            // UberEats
    public static final byte TYPE_OPEN_TABLE = (byte) 0x48;                                            // OpenTable
    public static final byte TYPE_MENTION = (byte) 0x49;                                            // Mention
    public static final byte TYPE_SWISS_QUOTE = (byte) 0x4A;                                            // SwissQuote
    public static final byte TYPE_DIAGRAL_CONNECT = (byte) 0x4B;                                            // DiagralConnect
    public static final byte TYPE_NEST = (byte) 0x4C;                                            // Nest
    public static final byte TYPE_NETATMO_SECURITY = (byte) 0x4D;                                            // NetatmoSecurity
    public static final byte TYPE_UBS_FINANCIAL = (byte) 0x4E;                                            // UBSFinancial
    public static final byte TYPE_N26_MOBILE_BANK = (byte) 0x4F;                                            // N26MobileBank
    //2017/12/15  新增推送 excel
    public static final byte TYPE_KAKAO_TALK = (byte) 0x50;                                            // Kakao talk
//    public static final byte TYPE_QZONE = (byte) 0x51;                                            // QZone
//    public static final byte TYPE_THREEMA = (byte) 0x52;                                            // Threema
//    public static final byte TYPE_TUMBLR = (byte) 0x53;                                            // Tumblr
//    public static final byte TYPE_VIADEO = (byte) 0x54;                                            // Viadeo
//    public static final byte TYPE_VK = (byte) 0x55;                                            // VK
//    public static final byte TYPE_YIK_YAK = (byte) 0x56;                                            // YikYak
//    public static final byte TYPE_LEXPRESS = (byte) 0x57;                                            // L'express
////    public static final byte TYPE_LE_FIGARO = (byte) 0x49;                                            // Le Figaro   //1.2.6协议有
//    public static final byte TYPE_MEDIAPART = (byte) 0x58;                                            // Mediapart
//    public static final byte TYPE_NEWS_REPUBLIC = (byte) 0x59;                                            // News Republic
//    public static final byte TYPE_THE_NEW_YORK_TIMES = (byte) 0x5A;                                            // The New York Times
//    public static final byte TYPE_THE_WALL_STREET_JOURNAL = (byte) 0x5B;                                            // The Wall Street Journal
//    public static final byte TYPE_DAILYMOTION = (byte) 0x5C;                                            // Dailymotion
//    public static final byte TYPE_EBAY = (byte) 0x5D;                                            // Ebay
//    public static final byte TYPE_LEBONCOIN = (byte) 0x5E;                                            // Leboncoin
//    public static final byte TYPE_RÉSULTATS_FOOT_EN_DIRECT = (byte) 0x5F;                                            // Résultats Foot en Direct
//    public static final byte TYPE_VENTE_PRIVÉE = (byte) 0x60;                                            // vente-privée
////    public static final byte TYPE_WAZE = (byte) 0x59;                                            // Waze   与上面的重复
//    public static final byte TYPE_WISH  = (byte) 0x61;                                            // Wish
//    public static final byte TYPE_AGENDA_BUSINESS = (byte) 0x62;                                            // Agenda business
//    public static final byte TYPE_EURO_SPORT = (byte) 0x63;                                            // Eurosport
//    public static final byte TYPE_HSBC_MOBILE_BANKING = (byte) 0x64;                                            // HSBC Mobile Banking
//    public static final byte TYPE_LINXO = (byte) 0x65;                                            // Linxo
//    public static final byte TYPE_ORANGE_BANK = (byte) 0x66;                                            // Orange bank
//    public static final byte TYPE_SWISS_FOREX = (byte) 0x67;                                            // Swiss Forex
//    public static final byte TYPE_UBS_MOBILE_BANKING = (byte) 0x68;                                            // UBS Mobile Banking

    public static final String TYPE_NOTE_WECHAT = "TYPE_NOTE_WECHAT";
    public static final String TYPE_NOTE_EMAIL_QQ = "TYPE_NOTE_EMAIL_QQ";
    public static final String TYPE_NOTE_EMAIL_GMAIL = "TYPE_NOTE_EMAIL_GMAIL";
    public static final String TYPE_NOTE_EMAIL_GOOGLE_INBOX = "TYPE_NOTE_EMAIL_GOOGLE_INBOX";
    public static final String TYPE_NOTE_EMAIL_OUTLOOK = "TYPE_NOTE_EMAIL_OUTLOOK";
    public static final String TYPE_NOTE_EMAIL_OUTLOOK_EX = "TYPE_NOTE_EMAIL_OUTLOOK_EX";

    public static final String TYPE_NOTE_SOCIAL_QQ = "TYPE_NOTE_SOCIAL_QQ";
    public static final String TYPE_NOTE_SOCIAL_WHATS_APP = "TYPE_NOTE_SOCIAL_WHATS_APP";
    public static final String TYPE_NOTE_SOCIAL_FACEBOOK = "TYPE_NOTE_SOCIAL_FACEBOOK";
    public static final String TYPE_NOTE_SOCIAL_FACEBOOK_MESSENGER = "TYPE_NOTE_SOCIAL_FACEBOOK_MESSENGER";
    public static final String TYPE_NOTE_SOCIAL_SKYPE = "TYPE_NOTE_SOCIAL_SKYPE";
    public static final String TYPE_NOTE_SOCIAL_TWITTER = "TYPE_NOTE_SOCIAL_TWITTER";
    public static final String TYPE_NOTE_SOCIAL_LINE = "TYPE_NOTE_SOCIAL_LINE";
    public static final String TYPE_NOTE_CALENDAR = "TYPE_NOTE_CALENDAR";
    public static final String TYPE_NOTE_SOCIAL_VIBER = "TYPE_NOTE_SOCIAL_VIBER";
    public static final String TYPE_NOTE_SOCIAL_LINKEDIN = "TYPE_NOTE_SOCIAL_LINKEDIN";
    public static final String TYPE_NOTE_GOOGLE_MAP = "TYPE_NOTE_GOOGLE_MAP";
    public static final String TYPE_NOTE_KAKAO_TALK = "TYPE_NOTE_KAKAO_TALK";
    public static final String TYPE_NOTE_TYPE_TELEGRAM = "TYPE_NOTE_TYPE_TELEGRAM";
//    public static final String TYPE_NOTE_SMS = "TYPE_NOTE_SMS";

    private static Map<String, NotificationRecord> packageMap = new HashMap<>();

    public static Map<String, NotificationRecord> getMap() {
        if (packageMap == null) {
            packageMap = new HashMap<>();
        }
        if (packageMap.size() == 0) {
            initData();
        }
        return packageMap;
    }

    public static NotificationRecord getNotificationRecord(String packageName, boolean isAddNotificationRecord) {
        if (packageMap == null) {
            packageMap = new HashMap<>();
        }
        if (packageMap.size() == 0) {
            initData();
        }
        NotificationRecord notificationRecord = packageMap.get(packageName);
        if (notificationRecord == null && isAddNotificationRecord) {
            notificationRecord = new NotificationRecord(PackageMap.TYPE_OTHER);
            packageMap.put(packageName, notificationRecord);
        }
        return notificationRecord;
    }

    private static void initData() {
        packageMap.put("com.android.email", new NotificationRecord(TYPE_EMAIL));                                            // android邮箱
        packageMap.put("com.google.android.gm", new NotificationRecord(TYPE_EMAIL));                                        // 谷歌邮箱
        packageMap.put("com.google.android.apps.inbox", new NotificationRecord(TYPE_EMAIL, TYPE_NOTE_EMAIL_GOOGLE_INBOX));  // 谷歌inbox
        packageMap.put("com.outlook.Z7", new NotificationRecord(TYPE_EMAIL));                                               // outlook邮箱
        packageMap.put("com.tencent.androidqqmail", new NotificationRecord(TYPE_EMAIL, TYPE_NOTE_EMAIL_QQ));                // QQ邮箱
        packageMap.put("cn.cj.pe", new NotificationRecord(TYPE_EMAIL));                                                     // 139邮箱
        packageMap.put("com.kingsoft.email", new NotificationRecord(TYPE_EMAIL));                                           // wps邮箱
        packageMap.put("com.netease.mobimail", new NotificationRecord(TYPE_EMAIL));                                         // 网易邮箱
        packageMap.put("com.sina.mail", new NotificationRecord(TYPE_EMAIL));                                                // 新浪邮箱
        packageMap.put("com.yahoo.mobile.client.android.mail", new NotificationRecord(TYPE_EMAIL));                         // 雅虎邮箱
        packageMap.put("com.vivo.email", new NotificationRecord(TYPE_EMAIL));                                               // Vivo手机邮箱
        packageMap.put("com.samsung.android.email.provider", new NotificationRecord(TYPE_EMAIL));                           // 三星note5邮箱
        packageMap.put("com.fsck.k9", new NotificationRecord(TYPE_EMAIL));                                                      // com.fsck.k9
        packageMap.put("org.kman.AquaMail", new NotificationRecord(TYPE_EMAIL));                                                 // Aquamail 免费
        packageMap.put("org.kman.AquaMail.UnlockerMarket", new NotificationRecord(TYPE_EMAIL));                              // Aquamail 付费

        packageMap.put("com.google.android.calendar", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));           // 谷歌日历
        packageMap.put("com.android.calendar", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));                  // android日历
        packageMap.put("com.htc.calendar", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));                      // htc日历
        packageMap.put("com.bbk.calendar", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));                      // bbk日历
        packageMap.put("cn.nubia.calendar.preset", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));              // 努比亚日历
        packageMap.put("com.samsung.android.calendar", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));          // sansung S7日历
        packageMap.put("netgenius.bizcal", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));          // Business Calendar Pro日历 免费
        packageMap.put("mikado.bizcalpro", new NotificationRecord(TYPE_CALENDAR, TYPE_NOTE_CALENDAR));          // Business Calendar Pro日历 付费

        packageMap.put("com.tencent.mm", new NotificationRecord(TYPE_WECHAT, TYPE_NOTE_WECHAT));                            // 微信         OK
        packageMap.put("com.viber.voip", new NotificationRecord(TYPE_VIBER, TYPE_NOTE_SOCIAL_VIBER));                       // Viber        不能推送内容 xxx给您发送了一条消息
        packageMap.put("com.snapchat.android", new NotificationRecord(TYPE_SNAPCHAT));                                      // Snapchat     不能推送内容
        packageMap.put("com.whatsapp", new NotificationRecord(TYPE_WHATSAPP, TYPE_NOTE_SOCIAL_WHATS_APP));                  // Whatsapp     OK
        packageMap.put("com.tencent.mobileqq", new NotificationRecord(TYPE_QQ, TYPE_NOTE_SOCIAL_QQ));                       // 手机QQ        OK
        packageMap.put("com.tencent.qqlite", new NotificationRecord(TYPE_QQ, TYPE_NOTE_SOCIAL_QQ));                         // QQ轻聊版      OK
        packageMap.put("com.tencent.mobileqqi", new NotificationRecord(TYPE_QQ, TYPE_NOTE_SOCIAL_QQ));                      // QQ国际版      OK
        packageMap.put("com.facebook.katana", new NotificationRecord(TYPE_FACEBOOK, TYPE_NOTE_SOCIAL_FACEBOOK));            // Facebook     OK
        packageMap.put("com.facebook.orca", new NotificationRecord(TYPE_MESSENGER, TYPE_NOTE_SOCIAL_FACEBOOK_MESSENGER));   // Facebook Messenger(如果不能推送,请确定"浮动聊天头像"功能有没有关闭) OK
        packageMap.put("com.google.android.talk", new NotificationRecord(TYPE_HANGOUTS));                                   // Hangouts     没测试
        packageMap.put("com.google.android.gm", new NotificationRecord(TYPE_GMAIL, TYPE_NOTE_EMAIL_GMAIL));                 // gmail        OK
        packageMap.put("com.outlook.Z7", new NotificationRecord(TYPE_OUTLOOK, TYPE_NOTE_EMAIL_OUTLOOK));                        // outlook邮箱(旧的)
        packageMap.put("com.microsoft.office.outlook", new NotificationRecord(TYPE_OUTLOOK, TYPE_NOTE_EMAIL_OUTLOOK_EX));   // outlook邮箱  OK
        packageMap.put("com.instagram.android", new NotificationRecord(TYPE_INSTAGRAM));                                        // Instagram    OK
        packageMap.put("com.twitter.android", new NotificationRecord(TYPE_TWITTER, TYPE_NOTE_SOCIAL_TWITTER));              // Twitter      OK
        packageMap.put("com.linkedin.android", new NotificationRecord(TYPE_LINKEDIN, TYPE_NOTE_SOCIAL_LINKEDIN));           // Linkedin     OK
        packageMap.put("com.ubercab", new NotificationRecord(TYPE_UBER));                                                         // Uber         没测试
        packageMap.put("jp.naver.line.android", new NotificationRecord(TYPE_LINE, TYPE_NOTE_SOCIAL_LINE));                  // LINE         OK
        packageMap.put("com.skype.android.verizon", new NotificationRecord(TYPE_SKYPE, TYPE_NOTE_SOCIAL_SKYPE));            // Skype        OK
        packageMap.put("com.skype.polaris", new NotificationRecord(TYPE_SKYPE, TYPE_NOTE_SOCIAL_SKYPE));                    // Skype        OK
        packageMap.put("com.skype.rover", new NotificationRecord(TYPE_SKYPE, TYPE_NOTE_SOCIAL_SKYPE));                      // Skype        OK
        packageMap.put("com.skype.raider", new NotificationRecord(TYPE_SKYPE, TYPE_NOTE_SOCIAL_SKYPE));                     // Skype        OK

        packageMap.put("com.booking", new NotificationRecord(TYPE_BOOKING));                                                // Booking
        packageMap.put("com.airbnb.android", new NotificationRecord(TYPE_AIRBNB));                                          // Airbnb
        packageMap.put("flipboard.cn", new NotificationRecord(TYPE_FLIPBOARD));                                             // Flipboard
        packageMap.put("com.flipboard", new NotificationRecord(TYPE_FLIPBOARD));                                            // Flipboard
        packageMap.put("com.andguru.telegram.messenger", new NotificationRecord(TYPE_TELEGRAM, TYPE_NOTE_TYPE_TELEGRAM));                            // Telegram
        packageMap.put("org.zs.telegram.messenger", new NotificationRecord(TYPE_TELEGRAM, TYPE_NOTE_TYPE_TELEGRAM));                                 // Telegram
        packageMap.put("org.telegram.messenger", new NotificationRecord(TYPE_TELEGRAM, TYPE_NOTE_TYPE_TELEGRAM));                                 // Telegram
        packageMap.put("com.pandora.android", new NotificationRecord(TYPE_PANDORA));                                        // Pandora
        packageMap.put("com.spotify.music", new NotificationRecord(TYPE_SPOTIFY));                                          // Spotify
        packageMap.put("com.dropbox.android", new NotificationRecord(TYPE_DROPBOX));                                        // Dropbox
        packageMap.put("com.shazam.android", new NotificationRecord(TYPE_SHAZAM));                                          // Shazam
        packageMap.put("me.lyft.android", new NotificationRecord(TYPE_LIFT));                                               // Lift
        packageMap.put("com.waze", new NotificationRecord(TYPE_WAZE));                                                      // Waze
        packageMap.put("com.Slack", new NotificationRecord(TYPE_SLACK));                                                    // Slack
        packageMap.put("com.deliveroo.orderapp", new NotificationRecord(TYPE_DELIVEROO));                                   // Deliveroo
        packageMap.put("com.pinterest", new NotificationRecord(TYPE_PINTEREST));                                            // Pinterest
        packageMap.put("com.netflix.mediaclient", new NotificationRecord(TYPE_NETFLIX));                                    // Netflix
        packageMap.put("com.google.android.youtube", new NotificationRecord(TYPE_YOUTUBE));                                 // Youtube
        packageMap.put("com.google.android.apps.maps", new NotificationRecord(TYPE_GOOGLEMAP, TYPE_NOTE_GOOGLE_MAP));       // GoogleMap
        packageMap.put("com.paypal.android.p2pmobile", new NotificationRecord(TYPE_PAYPAL));                                // PayPal
        packageMap.put("com.airfrance.android.dinamoprd", new NotificationRecord(TYPE_AIRFRANCE));                          // AirFrance
        packageMap.put("com.nextradiotv.bfmtvandroid", new NotificationRecord(TYPE_BFMTV));                                 // Bfmtv
        packageMap.put("com.lemonde.androidapp", new NotificationRecord(TYPE_LEMONDE));                                     // Lemonde
        packageMap.put("com.cnn.mobile.android.phone", new NotificationRecord(TYPE_CNN));                                   // CNN
        packageMap.put("com.freerange360.mpp.businessinsider", new NotificationRecord(TYPE_BUSINESSINSIDER));               // BusinessInsider

        //1.2.6协议新增
        packageMap.put("fr.playsoft.lefigarov3", new NotificationRecord(TYPE_LE_FIGARO));                                   // LeFigaro
        packageMap.put("com.jeanmarcmorandini", new NotificationRecord(TYPE_MORANDINI_BLOG));                               // MorandiniBlog
        packageMap.put("com.indiegogo.android", new NotificationRecord(TYPE_INDIEGOGO));               // Indiegogo
        packageMap.put("com.kickstarter.kickstarter", new NotificationRecord(TYPE_KICKSTARTER));               // Kickstarter
        packageMap.put("com.jeanmarcmorandini", new NotificationRecord(TYPE_STRIPE_DASHBOARD));               // StripeDashboard  //不确定
        packageMap.put("com.afklm.mobile.android.gomobile.klm", new NotificationRecord(TYPE_KLM));               // KLM
        packageMap.put("com.mttnow.droid.easyjet", new NotificationRecord(TYPE_EASY_JET));               // EasyJet
        packageMap.put("com.yoc.swiss.swiss", new NotificationRecord(TYPE_SWISS));               // SWISS
        packageMap.put("com.lufthansa.android.lufthansa", new NotificationRecord(TYPE_LUFTHANSA));               // Lufthansa  不确定
        packageMap.put("com.aa.android", new NotificationRecord(TYPE_AMERICAN_AIRLINES));               // AmericanAirlines
        packageMap.put("com.delta.mobile.android", new NotificationRecord(TYPE_FLY_DELTA));               // FlyDelta
        packageMap.put("com.jetsmarter.SmartJets", new NotificationRecord(TYPE_JET_SMARTER));               // JetSmarter
        packageMap.put("com.sdu.didi.psnger", new NotificationRecord(TYPE_DIDI));               // DiDi
        packageMap.put("com.ubercab.eats", new NotificationRecord(TYPE_UBER_EATS));               // UberEats
        packageMap.put("com.opentable", new NotificationRecord(TYPE_OPEN_TABLE));               // OpenTable
        packageMap.put("net.mention.android", new NotificationRecord(TYPE_MENTION));               // Mention
        packageMap.put("com.swissquote.android", new NotificationRecord(TYPE_SWISS_QUOTE));               // SwissQuote
        packageMap.put("com.diagral.diagralconnect", new NotificationRecord(TYPE_DIAGRAL_CONNECT));               // DiagralConnect
        packageMap.put("com.nest.android", new NotificationRecord(TYPE_NEST));               // Nest
        packageMap.put("com.netatmo.camera", new NotificationRecord(TYPE_NETATMO_SECURITY));               // NetatmoSecurity
        packageMap.put("jeanmarcmorandini", new NotificationRecord(TYPE_UBS_FINANCIAL));               // UBSFinancial   不确定
        packageMap.put("de.number26.android", new NotificationRecord(TYPE_N26_MOBILE_BANK));               // N26MobileBank

        //12-15新增 TODO 未完 excel 0x? 未确定
        packageMap.put("com.kakao.talk", new NotificationRecord(TYPE_KAKAO_TALK, TYPE_NOTE_KAKAO_TALK));               //  Kakao talk   ok
//        packageMap.put("com.android.mms", new NotificationRecord(TYPE_SMS,TYPE_NOTE_SMS));               //  彩信   ok
//        packageMap.put("com.tencent.mobileqqi", new NotificationRecord(TYPE_QZONE));               //  QZone
//        packageMap.put("ch.threema.app", new NotificationRecord(TYPE_THREEMA));               // Threema  free
//        packageMap.put("ch.threema.app.work", new NotificationRecord(TYPE_THREEMA));               //  Threema
//        packageMap.put("com.tumblr", new NotificationRecord(TYPE_TUMBLR));               //  Tumblr
//        packageMap.put("com.magetys.viadeodashclock", new NotificationRecord(TYPE_VIADEO));               //  Viadeo
//        packageMap.put("com.vkontakte.android", new NotificationRecord(TYPE_VK));               //  VK
//        packageMap.put("com.tellm.android.app", new NotificationRecord(TYPE_YIK_YAK));               //  YikYak
//        packageMap.put("com.roularta.lexpress", new NotificationRecord(TYPE_LEXPRESS));               //  L'express
//        packageMap.put("com.mediapart.app", new NotificationRecord(TYPE_MEDIAPART));               //  Mediapart
//        packageMap.put("com.mobilesrepublic.appy", new NotificationRecord(TYPE_NEWS_REPUBLIC));               //  News Republic
//        packageMap.put("com.nytimes.android", new NotificationRecord(TYPE_THE_NEW_YORK_TIMES));               //  The New York Times
//        packageMap.put("wsj.reader_sp", new NotificationRecord(TYPE_THE_WALL_STREET_JOURNAL));               //  The Wall Street Journal
//        packageMap.put("com.dailymotion.dailymotion", new NotificationRecord(TYPE_DAILYMOTION));               //  Dailymotion
//        packageMap.put("com.ebay.mobile", new NotificationRecord(TYPE_EBAY));               //  Ebay
//        packageMap.put("fr.leboncoin", new NotificationRecord(TYPE_LEBONCOIN));               //  Leboncoin
//        packageMap.put("com.activaweb.matchendirect", new NotificationRecord(TYPE_RÉSULTATS_FOOT_EN_DIRECT));               //  Résultats Foot en Direct
//        packageMap.put("com.venteprivee", new NotificationRecord(TYPE_VENTE_PRIVÉE));               //  vente-privée
//        packageMap.put("com.waze", new NotificationRecord(TYPE_WAZE));               //  Waze
//        packageMap.put("com.contextlogic.wish", new NotificationRecord(TYPE_WISH));               //  Wish
//        packageMap.put("com.appgenix.bizcal", new NotificationRecord(TYPE_AGENDA_BUSINESS));               //  Agenda business
//        packageMap.put("com.eurosport", new NotificationRecord(TYPE_EURO_SPORT));               //  Eurosport
//        packageMap.put("com.ubs.swidKXJ.android", new NotificationRecord(TYPE_HSBC_MOBILE_BANKING));               //  HSBC Mobile Banking
//        packageMap.put("com.linxo.androlinxo", new NotificationRecord(TYPE_LINXO));               //    Linxo
//        packageMap.put("com.orangebank.android", new NotificationRecord(TYPE_ORANGE_BANK));               // Orange bank
//        packageMap.put("com.dukascopy.informer", new NotificationRecord(TYPE_SWISS_FOREX));               //  Swiss Forex
//        packageMap.put("com.ubs.swidKXJ.android", new NotificationRecord(TYPE_UBS_MOBILE_BANKING));               // UBS Mobile Banking
    }
}
