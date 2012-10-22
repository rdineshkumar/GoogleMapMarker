package com.map.marker;

import android.R.drawable;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class CustomImageOverLayItem  extends OverlayItem{

	private Drawable mDrawable;
	public CustomImageOverLayItem(GeoPoint point, String title, String snippet,Drawable drawable) {
		super(point, title, snippet);
		this.mDrawable=drawable;
		
	}
	
	public void setImageView(Drawable drawable){
		this.mDrawable=drawable;
	}
	
	public Drawable getImageView(){
		return mDrawable;
	}

}
