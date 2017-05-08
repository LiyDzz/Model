package com.example.lenovo.day04volleytest2;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * Created by LENOVO on 2017/4/7.
 */

public class MemorycacheUtils {
    private static LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>((int) (Runtime.getRuntime().maxMemory() / 8)) {
        @Override
        protected int sizeOf(String key, Bitmap value) {
            int i = value.getHeight() * value.getRowBytes();
            return i;
        }
    };

    public static void setMemoryCache(String url, Bitmap bitmap) {
        lruCache.put(url, bitmap);
        Log.e("tag", "设置内存缓存");
    }

    public static Bitmap getMemoryCache(String url) {
        Log.e("tag", "获取内存缓存");
        Bitmap bitmap = lruCache.get(url);
        return bitmap;
    }
}
