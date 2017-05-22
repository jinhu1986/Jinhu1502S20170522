package com.bawi.jinhu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawi.jinhu.R;

import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/5/22  9:12
 */

public class RvAdapter_01 extends RecyclerView.Adapter<RvAdapter_01.ViewHolder> {
    private List<String> mList;
    private Context mContext;
    //点击
    private OnItemClickListener mOnItemClickListener;

    //点击
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    //点击监听接口
    public interface OnItemClickListener {
        void onItemClick(String name, int position);
    }

    public RvAdapter_01(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_01, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String s = mList.get(position);
        holder.mTextView.setText(s);
        //单击判断
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(s, position); // 2
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item_01);
        }
    }
}
