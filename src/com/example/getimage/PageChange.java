package com.example.getimage;

import java.io.ByteArrayOutputStream;

import com.example.getimage.R;
import com.example.getimage.AsyncBitmapLoader.ImageCallBack;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PageChange extends Activity {
	
	private ViewPager viewPager;
	private int currentPage;
	private ViewGroup container;
	private AsyncBitmapLoader asyncBitmapLoader;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pagechange);
		
		viewPager = (ViewPager) findViewById(R.id.viewpager1);
		
		PagerAdapter adapter = new PagerAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 10;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
						
			public Object instantiateItem(View container, int position){
				View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.items, null);
				ImageView imageView = (ImageView) view.findViewById(R.id.imageview1);
				imageView.setImageResource(position);				
				((ViewPager) container).addView(view, 0);
				Intent intent = getIntent();
				if(intent != null){
					Bitmap bitmap = intent.getParcelableExtra("bitmap");
					imageView.setImageBitmap(bitmap);
				}
				return view;
							
			}
						
		};
		viewPager.setAdapter(adapter);
			
		viewPager.setOnPageChangeListener(new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				currentPage = position;
			}
			
		});
		
		
	}
}