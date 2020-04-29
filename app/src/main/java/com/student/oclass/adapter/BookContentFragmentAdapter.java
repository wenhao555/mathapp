package com.student.oclass.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.justloginregistertest.R;
import com.student.oclass.fragment.BookContentFragment;

public class BookContentFragmentAdapter extends FragmentPagerAdapter {
private String[] titleStr = null;

	
	public BookContentFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public BookContentFragmentAdapter(FragmentManager fm, Context context) {
		super(fm);
		titleStr=context.getResources().getStringArray(R.array.famous_book_array);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 0:
		case 1:
			return BookContentFragment.newInstance(position);
		}
		return null;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleStr[position];
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return titleStr.length;
	}
}
