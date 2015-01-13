package com.example.getimage;

import java.io.ByteArrayOutputStream;
import java.util.Collections;


import com.example.getimage.AsyncBitmapLoader.ImageCallBack;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listview = (ListView) findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter();
        listview.setAdapter(adapter);
	}
	private class MyAdapter extends BaseAdapter{

    	private AsyncBitmapLoader asyncBitmapLoader;
    	public MyAdapter(){
    		asyncBitmapLoader = new AsyncBitmapLoader();
    	}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView == null){
				convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.items, null);
			}
			ImageView image = (ImageView) convertView.findViewById(R.id.imageview1);
			String imageURL = "http://www.baidu.com/img/baidu_sylogo1.gif";
			final Bitmap bitmap = asyncBitmapLoader.loadBitmap(image, imageURL, new ImageCallBack() {
				
		public void imageLoad(ImageView imageView, Bitmap bitmap) {
					// TODO Auto-generated method stub
					imageView.setImageBitmap(bitmap);
				}
			});
			 if(bitmap == null)  
		        {  
				   image.setImageResource(R.drawable.ic_launcher);  
		        }  
		        else  
		        {  
		        	image.setImageBitmap(bitmap);  
		        }			
			 			 
			 image.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.putExtra("bitmap", bitmap);
					intent.setClass(MainActivity.this, PageChange.class);
					startActivity(intent);					
				}
			});			 			 		 
			return convertView;
		}	
	}
	
}
    	


