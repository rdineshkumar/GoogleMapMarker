package com.map.marker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GoogleMapMarkerActivity extends MapActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        
        String ViewType;
        ViewType=this.getIntent().getStringExtra("ViewType");
        
        final MapView mapView=(MapView)findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        mapView.setStreetView(true);
        
        Drawable drawable = getResources().getDrawable(R.drawable.iamhere);
        List<Overlay> mapOverLay=mapView.getOverlays();
        
        if(ViewType.equals("Alert")){
        	OverLayItemContent overLayItems=new OverLayItemContent(drawable,this);
        	
        	GeoPoint point1=new GeoPoint((int)(10.7637 * 1E6),(int)(78.7162 * 1E6));
            OverlayItem overLayItem1=new OverlayItem(point1, "This is Tamilnadu", "Trichy");
            
            LocationManager locMgr=(LocationManager)this.getSystemService(LOCATION_SERVICE);
            Location loc=locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            GeoPoint point2=new GeoPoint((int)(loc.getLatitude() * 1E6),(int)(loc.getLongitude() * 1E6));
            OverlayItem overLayItem2=new OverlayItem( point2, "This is Tamilnadu", "Thanjavur" );
            
            overLayItems.addOverLay(overLayItem1);
            overLayItems.addOverLay(overLayItem2);
            
            mapOverLay.add(overLayItems);
            
            mapView.setOnTouchListener(new OnTouchListener() {
				
				public boolean onTouch(View v, MotionEvent event) {
					List<Overlay> mOverLay=new ArrayList<Overlay>();
					if (event.getAction() == 1) {                
			            	GeoPoint p = mapView.getProjection().fromPixels((int) event.getX(),(int) event.getY());
			                //Toast.makeText(GoogleMap.this,p.getLatitudeE6() / 1E6 + "," +p.getLongitudeE6() /1E6 ,Toast.LENGTH_SHORT).show();
			                int CurrentLatitude=(int) (p.getLatitudeE6() / 1E6);
			                int CurrentLongitude=(int) (p.getLongitudeE6()/1E6);
			                Geocoder getAddress =new Geocoder(GoogleMapMarkerActivity.this, Locale.getDefault());
			                
			                try {
			                	
								List<Address> AddressList=getAddress.getFromLocation(CurrentLatitude,  CurrentLongitude, 1);
								String AddressStriing="";
								if(AddressList.size()>0)
								{
									for(int i=0;i<AddressList.get(0).getMaxAddressLineIndex();i++)
									{
										AddressStriing+=AddressList.get(0).getAddressLine(i)+"\n";
									}
								}
								OverLayItemContent overLayItems=new OverLayItemContent(GoogleMapMarkerActivity.this.getResources().getDrawable(R.drawable.ic_launcher),GoogleMapMarkerActivity.this);
					        	
					        	GeoPoint point1=new GeoPoint((int)(CurrentLatitude * 1E6),(int)(CurrentLongitude * 1E6));
					            OverlayItem overLayItem1=new OverlayItem(point1, AddressStriing, "");
					            overLayItems.addOverLay(overLayItem1);
					            mOverLay.add(overLayItems);
					            //populate();
					            Log.d("Address",""+AddressStriing);
								//Toast.makeText(mContext, ""+AddressStriing, 1).show();
								
							} catch (IOException e) {
								e.printStackTrace();
							}
			        }                            
			       // return true;
					return false;
				}
			});
            
        }else if(ViewType.equals("View")){
        	
        	CustomOverLayItem overLayItems=new CustomOverLayItem(drawable,mapView);
        	 
        	GeoPoint point1=new GeoPoint((int)(10.7637 * 1E6),(int)(78.7162 * 1E6));
            OverlayItem overLayItem1=new OverlayItem(point1, "This is Tamilnadu", "Trichy");
            
            LocationManager locMgr=(LocationManager)this.getSystemService(LOCATION_SERVICE);
            Location loc=locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            GeoPoint point2=new GeoPoint((int)(loc.getLatitude() * 1E6),(int)(loc.getLongitude() * 1E6));
            OverlayItem overLayItem2=new OverlayItem( point2, "This is Tamilnadu", "Thanjavur" );
            
            overLayItems.addOverLayItem(overLayItem1);
            overLayItems.addOverLayItem(overLayItem2);
            
            mapOverLay.add(overLayItems);
        	
        }else{
        	
        	CustomImageMarker<CustomImageOverLayItem> customItemizedOverLay=new CustomImageMarker<CustomImageOverLayItem>(drawable, mapView);
        	
        	GeoPoint point1=new GeoPoint((int)(10.7637 * 1E6),(int)(78.7162 * 1E6));
        	CustomImageOverLayItem customImageOverlay1=new CustomImageOverLayItem(point1, "This is Tamilnadu", "Trichy", getResources().getDrawable(R.drawable.loc_img1));
        	customItemizedOverLay.addCustomOverLay(customImageOverlay1);
        	
        	LocationManager locMgr=(LocationManager)this.getSystemService(LOCATION_SERVICE);
            Location loc=locMgr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            GeoPoint point2=new GeoPoint((int)(loc.getLatitude() * 1E6),(int)(loc.getLongitude() * 1E6));
            CustomImageOverLayItem customImageOverlay2=new CustomImageOverLayItem(point2, "This is Tamilnadu", "Thanjavur", getResources().getDrawable(R.drawable.loc_img2));
            customItemizedOverLay.addCustomOverLay(customImageOverlay2);
            
            mapOverLay.add(customItemizedOverLay);
        	
        }
        
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}