package com.jiyun.thread;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by LENOVO on 2017/4/6.
 */

public class ThreadUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void runOnMainThread(Runnable task) {
        sHandler.post(task);
    }
}
