package com.jaydenxiao.expandabletextviewexample;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import jaydenxiao.com.expandabletextview.ExpandableTextView;

/**
 * des:适配器
 * Created by xsf
 * on 2016.08.24
 */
public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private final SparseBooleanArray mCollapsedStatus;
    private final String[] sampleStrings;

    public ListAdapter(Context context) {
        mContext  = context;
        mCollapsedStatus = new SparseBooleanArray();
        sampleStrings = mContext.getResources().getStringArray(R.array.exampleStrings);
    }

    @Override
    public int getCount() {
        return sampleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.expandableTextView = (ExpandableTextView) convertView.findViewById(R.id.etv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.expandableTextView.setText(sampleStrings[position], position);
        return convertView;
    }


    private static class ViewHolder{
        ExpandableTextView expandableTextView;
    }
}