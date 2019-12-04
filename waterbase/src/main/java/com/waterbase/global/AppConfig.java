package com.waterbase.global;

/**
 * app配置类
 * 作者：Laughing on 2018/10/13 14:06
 * 邮箱：719240226@qq.com
 * 名称：AbAppConfig.java
 * 描述：初始设置类.
 *
 * @author LiuQi
 */
public class AppConfig {


    /**
     * UI设计的基准宽度.
     */

    public static int UI_WIDTH = 1242;

    /**
     * UI设计的基准高度.
     */
    public static int UI_HEIGHT = 2208;

    /**
     * UI设计的密度.
     */
    public static int UI_DENSITY = 1;

    /**
     * 默认 SharePreferences文件名.
     */
    public static String SHARED_PATH = "app_share";

    /**
     * 默认下载文件地址.
     */
    public static String DOWNLOAD_ROOT_DIR = "download";

    /**
     * 默认下载图片文件地址.
     */
    public static String DOWNLOAD_IMAGE_DIR = "images";

    /**
     * 默认下载文件地址.
     */
    public static String DOWNLOAD_FILE_DIR = "files";

    /**
     * APP缓存目录.
     */
    public static String CACHE_DIR = "cache";

    /**
     * DB目录.
     */
    public static String DB_DIR = "ycw_db";

    /**
     * 默认磁盘缓存超时时间设置，毫秒.
     */
    public static long DISK_CACHE_EXPIRES_TIME = 60 * 1000 * 1000;

    /**
     * 内存缓存大小  单位10M.
     */
    public static int MAX_CACHE_SIZE_INBYTES = 10 * 1024 * 1024;

    /**
     * 磁盘缓存大小  单位10M.
     */
    public static int MAX_DISK_USAGE_INBYTES = 10 * 1024 * 1024;

    /**
     * 主页面初始化程序需要用到的核心权限
     */
    public static boolean PhoneInfo = false;//手机信息权限
    public static boolean LOCATION = false;//定位权限
    public static boolean Write = false;//写SD卡权限
    public static boolean Read = false;//读SD卡权限
    public static boolean CAMERA = false;//拍照权限
    public static boolean PHONE_STATE = false;//手机系统信息
    //头像上传时的 key
    public static String headName = "ycw_head_pic_photo.jpg";

    public static final String isFirstInGuide = "is_guide_showed";//是否第一次进入 A_Guide页面

    public static final String PREF_USER_TOKEN = "token";// 保存用户账户信息
    public static final String PREF_PARKING_LOT_ID = "PREF_PARKING_LOT_ID";// 保存用户对应停车场Id
    public static final String PREF_USER_NAME = "PREF_USER_NAME";// 保存用户名
    public static final String PREF_USER_AUTHORITY = "PREF_USER_AUTHORITY";// 保存用户权限

    //从登陆页面传递到Home页面的数据
    public static final String EXTRA_PARKING_LOT_DETAIL = "PARKING_LOT_DETAIL";
    //帐号管理
    public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
    //搜索
    public static final String Extra_ParkingLotId = "ParkingLotId";

    public static boolean isShowUpdateDialog = true;//是否展示版本更新 对话框

    /**
     * 获取通知栏权限
     */
    public static String NOTIFICATION_MANAGER_PERMISSION = "NOTIFICATION_MANAGER_PERMISSION";

    //车场费率设置
    public static final String tollTypes1 = "按次收费";
    public static final String tollTypes2 = "按时收费";
    public static final String tollTypes3 = "按昼夜时段收费";
    public static final String tollTypes4 = "费率测试";

    public static final String parkingId = "parkingId";//构造方法创建的Parking对象的id属性，与Map中的key共用。
    public static final String mRegionName = "mRegionName";
    public static final String mCarTypes = "mCarTypes";
    public static final String mTollTypes = "mTollTypes";//
    public static final String mChargePriceSelect = "mChargePriceSelect";//费率类型:用来区别进行展示

    public static final String DYNAMIC_PRICE_ONE = "DYNAMIC_PRICE_ONE";
    public static final String DYNAMIC_PRICE_TWO = "DYNAMIC_PRICE_TWO";
    public static final String DYNAMIC_PRICE_THREE = "DYNAMIC_PRICE_THREE";


    //停车场id首次进入app之后保存停车场，只要app没有销毁，则默认展示该ID对应的停车场信息。
    public static String parkingLotId = "PARKING_ID";//缓存停车场ID
    public static String ParkingLotNumber = "ParkingLotNumber";//缓存停车场编号
    public static String parkingLotName = "parkingLotName";//缓存停车场名称
    public static String parkingLotPublic = "parkingLotPublic";//缓存停车场数量
    
    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    public static final String WeiXin_APP_ID = "wx2739e0fa77a83fa5";
    //微信app key
    public static final String WeiXin_APP_KEY = "e840852685ab0c0fdd1d4a65fb823fdc";
    //应用签名：根据项目的应用包名和编译使用的keystore，可由签名工具生成一个32位的md5串，在调试的手机上安装签名工具后，
    // 运行可生成应用签名串，如图8.9所示，绿色串即应用签名。签名工具下载地址
    // https://open.weixin.qq.com/zh_CN/htmledition/res/dev/download/sdk/Gen_Signature_Android.apk
    public static final String WeiXin_APP_SIGNATURE = "99dbbc766b1bbbe0c7df3ccada39c311";
    public static int payType = 0x001;//支付类型
    public static final int FIX_ORDER_PAY = 0x10001;//售后申请 支付
    public static final int MONTH_CARD_PAY = 0x10002;//暂未使用，使用时重命名
    public static final int WALLET_RECHARGE = 0x10003;//暂未使用，使用时重命名
}
