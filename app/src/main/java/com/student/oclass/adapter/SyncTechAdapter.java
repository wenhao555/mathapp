package com.student.oclass.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.justloginregistertest.R;
import com.student.oclass.model.BookEntity;
import com.student.oclass.utils.AppConstant;

public class SyncTechAdapter extends BaseAdapter {

    private List<BookEntity> listBook = null;

    private Context context;

    private boolean isFamousBook = false;

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listBook.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listBook.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        if (contentView == null) {
            holder = new ViewHolder();
            contentView = LayoutInflater.from(context).inflate(R.layout.sync_tech_item, null);
            holder.iv_book = (ImageView) contentView.findViewById(R.id.iv_book);
            holder.layout_bg = (RelativeLayout) contentView.findViewById(R.id.layout_book);
            holder.tv_name = (TextView) contentView.findViewById(R.id.tv_name);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }
        BookEntity book = listBook.get(position);
        holder.layout_bg.setBackgroundResource(R.drawable.exam_book_bg);
        holder.tv_name.setText(book.name);
        return contentView;
    }

    public SyncTechAdapter(Context context, List<BookEntity> listBook, boolean isFamousBook) {
        this.context = context;
        this.listBook = listBook;
        this.isFamousBook = isFamousBook;
    }

    class ViewHolder {
        ImageView iv_book;

        TextView tv_name;

        RelativeLayout layout_bg;
    }
}
