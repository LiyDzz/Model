package com.jiyun.adapter;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.lenovo.day02okhttppicter.R;
import com.jiyun.cache.DisLruCacheUtil;
import com.jiyun.cache.DiskLruCacheUtils;
import com.jiyun.cache.MemorycacheUtils;

import java.util.List;

/**
 * Created by LENOVO on 2017/4/6.
 */

public class MyAdapter extends BaseAdapter {
    private List<String> list;

    public MyAdapter(List<String> urls) {
        this.list = urls;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item, null);
            holder.imgs = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgs.setImageResource(R.mipmap.ic_launcher);

        String url = list.get(position);

/*
*   图片内存缓存
*    读取缓存
* */
        Bitmap memory = MemorycacheUtils.getMemoryCache(url);
        if (memory != null) {
            holder.imgs.setImageBitmap(memory);
            Log.e("PicAdapter", "图片来自内存");
        } else {
            Bitmap cache = DisLruCacheUtil.getCache(parent.getContext(), url);
            if (cache != null) {
                holder.imgs.setImageBitmap(cache);
                Log.e("PicAdapter", "图片来自硬盘");
            } else {
                OkHttputils.showImageview(parent.getContext(), url, holder.imgs);
                Log.e("PicAdapter", "图片来自网络");
            }
        }
        return convertView;
    }

    static class ViewHolder {
        private ImageView imgs;
    }
}
