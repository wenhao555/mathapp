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
import com.student.oclass.activity.BookContentActivity;
import com.student.oclass.adapter.SyncTechAdapter;
import com.student.oclass.model.BookEntity;

public class SyncTechFragment extends BaseFragment {

    private GridView gridView;

    private SyncTechAdapter adapter;

    private List<BookEntity> listBook = new ArrayList<BookEntity>();

    private int position = 0;

    public static SyncTechFragment newInstance(int position) {
        SyncTechFragment fragment = new SyncTechFragment();
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
        adapter = new SyncTechAdapter(getActivity(), listBook, false);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), BookContentActivity.class);
                intent.putExtra("resId", "1");
                startActivity(intent);
            }
        });
        return contentView;
    }

    void initLocalData() {
        BookEntity book = new BookEntity();
        book.name="一单元";
        listBook.add(book);
        BookEntity book1 = new BookEntity();
        book1.name="二单元";
        listBook.add(book1);
        BookEntity book2 = new BookEntity();
        book2.name="三单元";
        listBook.add(book2);
    }



    private void parseArgument() {
        Bundle bundle = getArguments();
        position = bundle.getInt("position");

    }
}
