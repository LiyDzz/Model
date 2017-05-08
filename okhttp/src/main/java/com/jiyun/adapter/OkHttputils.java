package com.jiyun.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.jiyun.cache.DisLruCacheUtil;
import com.jiyun.cache.MemorycacheUtils;
import com.jiyun.thread.ThreadUtils;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LENOVO on 2017/4/6.
 */
public class OkHttputils {

    public static void showImageview(final Context context, final String url, final ImageView imgs) {
        imgs.setTag(url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Callback call = new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream in = response.body().byteStream();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 3;
                final Bitmap bitmap = BitmapFactory.decodeStream(in, null, options);
                DisLruCacheUtil.setCache(context, url, bitmap); //从网络上获取bitmap对象，同时写入到磁盘缓存中。
                MemorycacheUtils.setMemoryCache(url, bitmap); //图片内存缓存
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        String tag = (String) imgs.getTag();
                        if (tag != null && tag.equals(url)) {
                            imgs.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        };
        client.newCall(request).enqueue(call);
    }
}
