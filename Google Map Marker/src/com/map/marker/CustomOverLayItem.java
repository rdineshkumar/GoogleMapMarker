package com.map.marker;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;

public class CustomOverLayItem  extends BalloonItemizedOverlay<OverlayItem>{
	private ArrayList<OverlayItem> mOverLayItems=new ArrayList<OverlayItem>();
	private MapView mMapView;
	private Context mContext;

	public CustomOverLayItem(Drawable defaultMarker, MapView mapView) {
		super(boundCenter(defaultMarker), mapView);
		mMapView=mapView;
		mContext=mapView.getContext();
	}

	public void addOverLayItem(OverlayItem overLayItem){
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
	protected boolean onBalloonTap(int index, OverlayItem item) {
		return super.onBalloonTap(index, item);
	}
	

}
