package com.ym.test.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ym.test.R;
import com.ym.test.mojo.User;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<User> mData;

    public MyAdapter(){

    }
    public MyAdapter(LinkedList<User> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.txt_content = (TextView) convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img_icon.setImageResource(mData.get(position).getImgId());
        holder.txt_content.setText(mData.get(position).getContent());
        return convertView;
    }
    private class ViewHolder{
        ImageView img_icon;
        TextView txt_content;
    }
    public void add(User data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    public void remove(User data) {
        if(mData != null) {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }
    public void update(int position,User data) {
        if(mData != null) {
            User user=mData.get(position);
            user.setImgId(data.getImgId());
            user.setContent(data.getContent());
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if(mData != null) {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }
    public void removeAll() {
        if(mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }
}
