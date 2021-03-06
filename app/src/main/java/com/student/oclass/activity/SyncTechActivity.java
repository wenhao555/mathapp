package com.student.oclass.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.justloginregistertest.R;
import com.student.oclass.adapter.SynTechFragmentAdapter;
import com.student.oclass.view.pagerindicator.TabPageIndicator;

/**
 * 同步教材
 * @author lanyj
 *
 */
public class SyncTechActivity extends BaseActivity implements OnClickListener{

	private SynTechFragmentAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sync_tech);
		initView();
		int resId=getIntent().getIntExtra("resId", R.drawable.number_pressed);
		iv_title.setImageResource(resId);
		tv_title.setText("教材单元");
	}
	private void initView(){
		adapter = new SynTechFragmentAdapter(getSupportFragmentManager(), this);
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		iv_title=(ImageView)this.findViewById(R.id.iv_title);
		tv_title=(TextView)this.findViewById(R.id.tv_title);
		btn_back=(Button)this.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.btn_back:
			finish();
			break;
		}
	}

}
