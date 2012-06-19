package com.mobisfera.onvasnevas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Help extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		Intent i = this.getIntent();
		
		if(i != null) {
			setContentView(R.layout.win_no_register);
			int stars = i.getIntExtra("stars", 0);
			int time = i.getIntExtra("time", 0);
			if (stars == 3){ 
				ImageView st = (ImageView) findViewById(R.id.stars);
				st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_2));
			}
			else if(stars == 2) {
				ImageView st = (ImageView) findViewById(R.id.stars);
				st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_1));
			}
			else if(stars == 1) {
				ImageView st = (ImageView) findViewById(R.id.stars);
				st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_0));
			}
			TextView t = (TextView) findViewById(R.id.score);
			t.setText(Integer.toString((time*stars)+(100*stars)));
			
			ImageView levels = (ImageView) findViewById(R.id.menu);
			levels.setOnClickListener(this);
			
			ImageView replay = (ImageView) findViewById(R.id.replay);
			replay.setOnClickListener(this);
		}
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.replay:
				  final Intent intent = new Intent(getApplicationContext(), Game.class);
				  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				  startActivity(intent);
				  break;
			case R.id.menu:
				  final Intent intent2 = new Intent(getApplicationContext(), Levels.class);
				  intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				  startActivity(intent2);
		}
	}

	
}
