package com.bawi.jinhu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawi.jinhu.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/22  9:25
 */

public class RvAdapter_02 extends RecyclerView.Adapter<RvAdapter_02.ViewHolder> {
    private ArrayList<HashMap<String, String>> mArrayList;
    private Context mContext;

    public RvAdapter_02(ArrayList<HashMap<String, String>> arrayList, Context context) {
        mArrayList = arrayList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_02, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String, String> stringStringHashMap = mArrayList.get(position);
        holder.mTextView_01.setText(stringStringHashMap.get("duoyun"));
        holder.mTextView_02.setText(stringStringHashMap.get("wendu"));
        holder.mTextView_03.setText(stringStringHashMap.get("riqi"));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView_01;
        TextView mTextView_02;
        TextView mTextView_03;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_item_02);
            mTextView_01 = (TextView) itemView.findViewById(R.id.tv_item_02_duoyun);
            mTextView_02 = (TextView) itemView.findViewById(R.id.tv_item_02_wendu);
            mTextView_03 = (TextView) itemView.findViewById(R.id.tv_item_02_riqi);
        }
    }
}
