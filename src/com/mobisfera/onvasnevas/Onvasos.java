package com.mobisfera.onvasnevas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class Onvasos extends Activity implements OnClickListener{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        setClicks();
        
    }

    private void setClicks() {
    	LinearLayout play = (LinearLayout) findViewById(R.id.layout_play);
    	play.setOnClickListener(this);
    	
    	LinearLayout help = (LinearLayout) findViewById(R.id.layout_help);
    	help.setOnClickListener(this);
    	
    	LinearLayout guide = (LinearLayout) findViewById(R.id.layout_guide);
    	guide.setOnClickListener(this);

    	LinearLayout score = (LinearLayout) findViewById(R.id.layout_score);
    	score.setOnClickListener(this);
    	
    	LinearLayout geo = (LinearLayout) findViewById(R.id.layout_geo);
    	geo.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.layout_play:
				startActivity(new Intent(this, Levels.class));
				break;
			case R.id.layout_help:
				startActivity(new Intent(this, Help.class));
				break;
			case R.id.layout_guide:
				startActivity(new Intent(this, Guide.class));
				break;
			case R.id.layout_score:
				break;
			case R.id.layout_geo:
				startActivity(new Intent(this, Geolocalitzacio.class));
				break;
		}
	}
}