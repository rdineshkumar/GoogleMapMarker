package com.map.marker;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.MapView;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;
import com.readystatesoftware.mapviewballoons.BalloonOverlayView;

public class CustomImageMarker<Item extends CustomImageOverLayItem> extends BalloonItemizedOverlay<CustomImageOverLayItem>{

	private ArrayList<CustomImageOverLayItem> mCustomOverLayItem=new ArrayList<CustomImageOverLayItem>();
	private MapView mMapView;
	private Context mContext;
	
	public CustomImageMarker(Drawable defaultMarker, MapView mapView) {
		super(boundCenter( defaultMarker), mapView);
		mMapView=mapView;
		mContext=mapView.getContext();
	}
	
	public void addCustomOverLay(CustomImageOverLayItem cOverLayItem){
		mCustomOverLayItem.add(cOverLayItem);
		populate();
	}

	@Override
	protected CustomImageOverLayItem createItem(int i) {
		return mCustomOverLayItem.get(i);
	}

	@Override
	public int size() {
		return mCustomOverLayItem.size();
	}

	@Override
	protected boolean onBalloonTap(int index, CustomImageOverLayItem item) {
		return super.onBalloonTap(index, item);
	}

	@Override
	protected BalloonOverlayView<CustomImageOverLayItem> createBalloonOverlayView() {
		return new CustomOverlaySetView<CustomImageOverLayItem>(getMapView().getContext(), getBalloonBottomOffset());
	}

}
