package com.mobisfera.onvasnevas;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;

public class Geolocalitzacio extends MapActivity implements OnClickListener {
	  private MapView map=null;
	  private MyLocationOverlay me=null;
	  private OverlayItem Item;
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.map);
	    
	    map=(MapView)findViewById(R.id.map);
	    
	    ImageView img = (ImageView) findViewById(R.id.center);
	    img.setOnClickListener(this);
	    
	    map.getController().setCenter(getPoint(41.4007241, 2.1972149000000627));
	    map.getController().setZoom(17);
	    map.setBuiltInZoomControls(true);
	    
	    Drawable marker=getResources().getDrawable(R.drawable.marker);
	    
	    marker.setBounds(0, 0, marker.getIntrinsicWidth(),marker.getIntrinsicHeight());
	    
	    map.getOverlays().add(new SitesOverlay(marker));
	    
	    me=new MyLocationOverlay(this, map);
	    map.getOverlays().add(me);
	  }
	  
	  @Override
	  public void onResume() {
	    super.onResume();
	    
	    me.enableCompass();
	  }  
	  
	  @Override
	  public void onPause() {
	    super.onPause();
	    
	    me.disableCompass();
	  }  
	  
	  @Override
	  protected boolean isRouteDisplayed() {
	    return(false);
	  }
	  
	  @Override
	  public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_S) {
	      map.setSatellite(!map.isSatellite());
	      return(true);
	    }
	    else if (keyCode == KeyEvent.KEYCODE_Z) {
	      map.displayZoomControls(true);
	      return(true);
	    }
	    
	    return(super.onKeyDown(keyCode, event));
	  }

	  private GeoPoint getPoint(double lat, double lon) {
	    return(new GeoPoint((int)(lat*1000000.0), (int)(lon*1000000.0)));
	  }
	    
	  private class SitesOverlay extends ItemizedOverlay<OverlayItem> {
	    private List<OverlayItem> items=new ArrayList<OverlayItem>();
	    private Drawable marker=null;
	    
	    public SitesOverlay(Drawable marker) {
	      super(marker);
	      this.marker=marker;
	      
	      InputStream inputStream = getResources().openRawResource(R.raw.test);
	      List<PuntoVerde> puntos = parsePuntosVerdes(inputStream);
	      
	      for(int i = 0; i < puntos.size(); i++) {
	    	  if(puntos.get(i).getDescription().contains("Verd")) {
	    		  Double latitude = Double.parseDouble(puntos.get(i).getLatitude());
	    		  Double longitude = Double.parseDouble(puntos.get(i).getLongitude());
	    		  items.add(new OverlayItem(getPoint(latitude, longitude), puntos.get(i).getDescription(), ""));
	    	  }
	      }

	      populate();
	    }
	    
	    private List<PuntoVerde> parsePuntosVerdes(InputStream input){
	    	SAXParserFactory factory = SAXParserFactory.newInstance();
	    	try{
	    		SAXParser parser = factory.newSAXParser();
	    		PuntoVerdeParser handler = new PuntoVerdeParser();
	    		parser.parse(input, handler);
	    		return handler.getPuntosVerdes();
	    	} catch (Exception e){
	    		Log.d("Error XML", "El XML ha parsear es incorrecto");
	    		Log.d("Error", e.getMessage());
	    	}
	    	return null;
	    }
	    
	    @Override
	    protected OverlayItem createItem(int i) {
	      return(items.get(i));
	    }
	    
	    @Override
	    public void draw(Canvas canvas, MapView mapView,
	                      boolean shadow) {
	      super.draw(canvas, mapView, shadow);
	      
	      boundCenterBottom(marker);
	    }
	    
	    @Override
	    public int size() {
	      return(items.size());
	    }
	    
	    @Override
	    public boolean onTouchEvent(MotionEvent event, MapView mapView) {
	    	final int action=event.getAction();
	    	final int x=(int)event.getX();
	    	final int y=(int)event.getY();
	    	boolean result=false;
		      
	    	if (action==MotionEvent.ACTION_DOWN) {
	    		for (OverlayItem item : items) {
	    			Point p=new Point(0,0);
	    			map.getProjection().toPixels(item.getPoint(), p);
		          
	    			if (hitTest(item, marker, x-p.x, y-p.y)) {
	    				Item = item;
	    				dialogo(item.getTitle());
	    			}
	    		}
	    	}
	    	return(result || super.onTouchEvent(event, mapView));
	    	}
	  	}
	  
	  private void dialogo(String title) {
		  AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		  
	        // Setting Dialog Title
	        alertDialog.setTitle(title.replace("*", ", "));
	 
	        // Setting Dialog Message
	        alertDialog.setMessage("Desitja obtenir la ruta fins al punt verd seleccionat?");
	 
	        // Setting Icon to Dialog
	 
	        // Setting Positive "Yes" Button
	        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog,int which) {
	            	Intent intent = new Intent(Intent.ACTION_VIEW);
	            	intent.setData(Uri.parse("geo:" + Item.getPoint().getLatitudeE6() / 1E6 + "," + Item.getPoint().getLongitudeE6() / 1E6 + "?q=" + Item.getPoint().getLatitudeE6() / 1E6 + "," + Item.getPoint().getLongitudeE6() / 1E6));
	            	startActivity(intent);
	            }
	        });
	 
	        // Setting Negative "NO" Button
	        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	            	dialog.cancel();
	            }
	        });
	 
	        // Showing Alert Message
	        alertDialog.show();
	  }

	@Override
	public void onClick(View v) {
		map.getController().setCenter(getPoint(41.4007241, 2.1972149000000627));
	    map.getController().setZoom(17);		
	}
}