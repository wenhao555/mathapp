package com.example.justloginregistertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.VideoView;

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        setContentView(R.layout.activity_video);
        VideoView webView=findViewById(R.id.video_view);
        webView.setVideoPath("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4");
//        webView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);
        //webView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video2);
//        webView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video3);
        webView.start();
    }
}

