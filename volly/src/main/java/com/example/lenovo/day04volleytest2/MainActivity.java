package com.example.lenovo.day04volleytest2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button vollyString, volleyImg;
    private ImageView imageView, imageloder;
    private NetworkImageView network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vollyString = (Button) findViewById(R.id.volleyString);
        volleyImg = (Button) findViewById(R.id.volleyimg);
        imageView = (ImageView) findViewById(R.id.img);
        imageloder = (ImageView) findViewById(R.id.imgloder);
        network = (NetworkImageView) findViewById(R.id.imgNetwork);
        vollyString.setOnClickListener(this);
        volleyImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.volleyString:
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://192.168.1.132:8080/netWork.json";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //请求成功后，走到这个方法中
                        Log.e("AAA", "请求结果：" + s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //请求失败后，走到这个方法中
                        Log.e("AAA", "请求失败：" + volleyError.getMessage().toString());
                    }
                });

                queue.add(stringRequest);
                break;
            case R.id.volleyimg:
                RequestQueue requests = Volley.newRequestQueue(MainActivity.this);
                String urlimg = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
                ImageRequest imageRequest = new ImageRequest(urlimg, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("AAA", "请求失败：" + volleyError.getMessage().toString());
                    }
                });
                requests.add(imageRequest);
                break;
        }
    }

    public void imageLoder(View view) {
        String url = "http://192.168.1.132:8080/ty.jpg";
        RequestQueue queue = Volley.newRequestQueue(this);
        ImageLoader.ImageCache imgcaChe = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return MemorycacheUtils.getMemoryCache(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                MemorycacheUtils.setMemoryCache(s, bitmap);
            }
        };
        ImageLoader loader = new ImageLoader(queue, imgcaChe);
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageloder, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        loader.get(url, imageListener);
    }

    public void imageNetWork(View v) {
        final String url = "http://192.168.1.132:8080/tt.jpg";
        RequestQueue requestquene = Volley.newRequestQueue(this);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return MemorycacheUtils.getMemoryCache(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                MemorycacheUtils.setMemoryCache(s, bitmap);
            }
        };
        ImageLoader imagLoder = new ImageLoader(requestquene, imageCache);
        network.setDefaultImageResId(R.mipmap.ic_launcher);
        network.setErrorImageResId(R.mipmap.ic_launcher);
        network.setImageUrl(url, imagLoder);
    }
}
