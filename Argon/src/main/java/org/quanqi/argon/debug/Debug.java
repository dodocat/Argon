package org.quanqi.argon.debug;

import android.util.Log;

/**
 * By jingquanqi on 10/15/13.
 */
public class Debug {
    public static final String TAG = "Argon King";

    /**
     * debug level log
     * @param msg message to be logged
     */
    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

}
