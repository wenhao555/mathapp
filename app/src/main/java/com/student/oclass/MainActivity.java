package com.student.oclass;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.justloginregistertest.R;
import com.example.justloginregistertest.loginActivity;
import com.student.oclass.activity.BaseActivity;
import com.student.oclass.activity.SyncTechActivity;
import com.student.oclass.data.SaveData;
import com.student.oclass.utils.AppConstant;
import com.student.oclass.view.SlideImageLayout;
import com.zdp.aseo.content.AseoZdpAseo;


public class MainActivity extends BaseActivity implements OnClickListener {

    // 滑动图片的集合
    private ArrayList<View> imagePageViews = null;

    private ViewPager viewPager = null;

    // 当前ViewPager索引
    private int pageIndex = 0;

    // 包含圆点图片的View
    private ViewGroup imageCircleView = null;

    private ImageView[] imageCircleViews = null;

    private SlideImageLayout slideLayout = null;

    private TextView linOutLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitHeadAd();
        linOutLogin=(TextView) findViewById(R.id.out_login);
        findViewById(R.id.line_content).setOnClickListener(this);
        findViewById(R.id.layout_setting).setOnClickListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    /**
     * 加载头部广告
     */
    private void InitHeadAd() {
        // 滑动图片区域
        imagePageViews = new ArrayList<View>();
        viewPager = (ViewPager) this.findViewById(R.id.image_slide_page);
        // 圆点图片区域
        int length = AppConstant.imgsUrl.length;
        imageCircleViews = new ImageView[length];
        imageCircleView = (ViewGroup) this.findViewById(R.id.layout_circle_images);
        slideLayout = new SlideImageLayout(this);
        slideLayout.setCircleImageLayout(length);
        for (int i = 0; i < length; i++) {
            int defId = R.drawable.a01;
            switch (i) {
            case 1:
                defId = R.drawable.a02;
                break;
            case 2:
                defId = R.drawable.a03;
                break;
            case 3:
                defId = R.drawable.a04;
                break;
            }
            View ImageView = slideLayout.getSlideImageLayout(AppConstant.imgsUrl[i], i, defId);
            imagePageViews.add(ImageView);
            imageCircleViews[i] = slideLayout.getCircleImageLayout(i);
            imageCircleView.addView(slideLayout.getLinearLayout(imageCircleViews[i], 10, 10));
        }
        viewPager.setAdapter(new SlideImageAdapter());
        viewPager.setOnPageChangeListener(new ImagePageChangeListener());
    }

    // 滑动图片数据适配器
    private class SlideImageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            // adScrolling = true;
            return imagePageViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;

        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(imagePageViews.get(arg1));
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(imagePageViews.get(arg1));

            return imagePageViews.get(arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }

    // 滑动页面更改事件监听器
    private class ImagePageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int index) {
            pageIndex = index;
            updateAddSelecedStatus();
        }
    }

    /**
     * 更新广告选项中状态
     */
    private void updateAddSelecedStatus() {
        slideLayout.setPageIndex(pageIndex);
        for (int i = 0; i < imageCircleViews.length; i++) {
            if (i == pageIndex) {
                imageCircleViews[pageIndex].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                imageCircleViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

	@Override
	public void onBackPressed() 
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
 		AseoZdpAseo.initFinalTimer(this);
		startActivity(intent);
	}

    @Override
    protected void onResume() {
        super.onResume();
        initLogin();
    }
    public void initLogin(){
        if (SaveData.getData()!=""){
            linOutLogin.setText("退出登录（"+SaveData.getData()+")");
        }else{
            linOutLogin.setText("登录/注册");
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.layout_setting){
            if (SaveData.getData()!=""){
                SaveData.save("");
                initLogin();
            }else{
                startActivity(new Intent(this, loginActivity.class));
            }
            initLogin();
        }else{
            Intent intent = new Intent(MainActivity.this, SyncTechActivity.class);
            intent.putExtra("resId", "1");
            startActivity(intent);

        }

    }
}
