package com.map.marker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class OverLayItemContent extends ItemizedOverlay<OverlayItem>{

	

	private ArrayList<OverlayItem> mOverLayItems=new ArrayList<OverlayItem>();
	private MapView mMapView;
	private Context mContext;
	
	public OverLayItemContent(Drawable defaultMarker ,Context context) {
		super(boundCenter(defaultMarker));
		mContext=context;
	}

	public void addOverLay(OverlayItem overLayItem){
		mOverLayItems.add(overLayItem);
		populate();
	}
	
	
	@Override
	protected OverlayItem createItem(int i) {
		return mOverLayItems.get(i);
	}

	@Override
	public int size() {
		return mOverLayItems.size();
	}

	@Override
	protected boolean onTap(int index) {
		OverlayItem items=mOverLayItems.get(index);
		AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
		builder.setTitle("Alert");
		builder.setMessage(items.getTitle()+"\n"+items.getSnippet());
		builder.setNegativeButton("Cancel", null);
		
		AlertDialog dialog=builder.create();
		
		dialog.show();
		
		
		return super.onTap(index);
		
	}
	
	

}
