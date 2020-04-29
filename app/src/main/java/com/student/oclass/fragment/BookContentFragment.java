package com.student.oclass.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.justloginregistertest.R;
import com.example.justloginregistertest.exam.ExamActivity;
import com.student.oclass.activity.ContentActivity;
import com.student.oclass.adapter.SyncTechAdapter;
import com.student.oclass.model.BookEntity;
import com.student.oclass.utils.AppConstant;

public class BookContentFragment extends BaseFragment {

    private GridView gridView;

    private SyncTechAdapter adapter;

    private int position = 0;

    private List<BookEntity> listBook = new ArrayList<BookEntity>();

    public static BookContentFragment newInstance(int position) {
        BookContentFragment fragment = new BookContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_sync_tech, container, false);
        gridView = (GridView) contentView.findViewById(R.id.gridview);
        parseArgument();
        initLocalData();
        adapter = new SyncTechAdapter(getActivity(), listBook, true);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ContentActivity.class);
                startActivity(intent);
            }
        });
        return contentView;
    }

    void initLocalData() {
        BookEntity book = new BookEntity();
        book.name="知识点一";
        listBook.add(book);
        BookEntity book1 = new BookEntity();
        book1.name="知识点二";
        listBook.add(book1);
        BookEntity book2 = new BookEntity();
        book2.name="知识点二";
        listBook.add(book2);
    }

    void initOnlineData() {
        for (int i = 0; i < 6; i++) {
            BookEntity book = new BookEntity();
            book.setType(AppConstant.FAMOUS_BOOK);
            listBook.add(book);
        }
    }

    private void parseArgument() {
        Bundle bundle = getArguments();
        position = bundle.getInt("position");

    }
}
