package com.student.oclass.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.justloginregistertest.R;
import com.example.justloginregistertest.VideoActivity;
import com.example.justloginregistertest.exam.ExamActivity;

public class ContentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        findViewById(R.id.btn_ex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ContentActivity.this, ExamActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ContentActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
