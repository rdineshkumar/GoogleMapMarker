package com.map.marker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		Button alertBtn=(Button)findViewById(R.id.button1);
		alertBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, GoogleMapMarkerActivity.class);	
				intent.putExtra("ViewType", "Alert");
				startActivity(intent);
			}
		});
		Button ViewBtn=(Button)findViewById(R.id.button2);
		ViewBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, GoogleMapMarkerActivity.class);	
				intent.putExtra("ViewType", "View");
				startActivity(intent);
			}
		});
		
		Button ViewImageBtn=(Button)findViewById(R.id.button3);
		ViewImageBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, GoogleMapMarkerActivity.class);	
				intent.putExtra("ViewType", "Image");
				startActivity(intent);
			}
		});
		
	}
	

}
