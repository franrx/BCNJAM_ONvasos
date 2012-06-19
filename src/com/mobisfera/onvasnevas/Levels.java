package com.mobisfera.onvasnevas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class Levels extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levels);
		
		setClicks();
	}
	
	private void setClicks() {
		ImageView level1 = (ImageView) findViewById(R.id.level1);
		level1.setOnClickListener(this);
		ImageView level2 = (ImageView) findViewById(R.id.level2);
		level2.setOnClickListener(this);
		ImageView level3 = (ImageView) findViewById(R.id.level3);
		level3.setOnClickListener(this);
		ImageView level4 = (ImageView) findViewById(R.id.level4);
		level4.setOnClickListener(this);
		ImageView level5 = (ImageView) findViewById(R.id.level5);
		level5.setOnClickListener(this);
		ImageView level6 = (ImageView) findViewById(R.id.level6);
		level6.setOnClickListener(this);
		ImageView level7 = (ImageView) findViewById(R.id.level7);
		level7.setOnClickListener(this);
		ImageView level8 = (ImageView) findViewById(R.id.level8);
		level8.setOnClickListener(this);
		ImageView level9 = (ImageView) findViewById(R.id.level9);
		level9.setOnClickListener(this);
		ImageView level10 = (ImageView) findViewById(R.id.level10);
		level10.setOnClickListener(this);
		ImageView level11 = (ImageView) findViewById(R.id.level11);
		level11.setOnClickListener(this);
		ImageView level12 = (ImageView) findViewById(R.id.level12);
		level12.setOnClickListener(this);
		ImageView level13 = (ImageView) findViewById(R.id.level13);
		level13.setOnClickListener(this);
		ImageView level14 = (ImageView) findViewById(R.id.level14);
		level14.setOnClickListener(this);
		ImageView level15 = (ImageView) findViewById(R.id.level15);
		level15.setOnClickListener(this);
		ImageView level16 = (ImageView) findViewById(R.id.level16);
		level16.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.level1:
				startActivity(new Intent(this, Game.class));
				break;
			default:
				Toast.makeText(getApplicationContext(), "Aquest nivell encara no está disponible", Toast.LENGTH_SHORT).show();
		}
	}
	
	

}
