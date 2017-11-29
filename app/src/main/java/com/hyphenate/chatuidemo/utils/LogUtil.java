package com.hyphenate.chatuidemo.utils;

import com.orhanobut.logger.Logger;

/**
 * Log统一管理类
 *
 * @author zhaolifeng
 */
public class LogUtil {

    private LogUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    public static boolean isShowToast = true;// 是否需要输出toast
    private static final String TAG = "QTX";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Logger.e(msg);
    /*	try {
            FileUtil.saveToFile(FileUtil.LOG_PATH,StringUtils.getCurrentTime()+"---"+TAG+"----"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }

    public static void d(String msg) {
        if (isDebug)
            Logger.e(msg);
		/*try {
			FileUtil.saveToFile(FileUtil.LOG_PATH,StringUtils.getCurrentTime()+"---"+TAG+"----"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }

    public static void e(String msg) {
        if (isDebug) {
            Logger.e(msg);
        }
	/*	try {
			FileUtil.saveToFile(FileUtil.LOG_PATH,StringUtils.getCurrentTime()+"---"+TAG+"----"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }

    public static void v(String msg) {
        if (isDebug)
            Logger.e(msg);
	/*	try {
			FileUtil.saveToFile(FileUtil.LOG_PATH,StringUtils.getCurrentTime()+"---"+TAG+"----"+msg);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Logger.e(msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Logger.e(msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Logger.e(msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Logger.e(msg);
    }
    public static void json(String msg) {
        if (isDebug)
            Logger.json(msg);
    }
}