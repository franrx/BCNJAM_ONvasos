package com.mobisfera.onvasnevas;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener{
	Contenidor contenidor;
//	Timer timer;
	int Score;
	int Stars = 3;
	int Fails = 0;
	int time;
	Random rndContenidor;
	Random rndElement;
	int remainElements; 
	int contenidorActiu = 0;
	Vector<ParrillaElement> parrilla;
	Handler timer = new Handler();
	
        private Runnable RefreshTimer = new Runnable() {
 		   public void run() {
 			   if (time == 0 || remainElements == 0){
 				  TextView t = (TextView) findViewById(R.id.time);
 				  t.setText(Integer.toString(time));
 				  final Intent intent2 = new Intent(getApplicationContext(), Help.class);
 				  intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 				  intent2.putExtra("clase", "win_no_register");
 				  intent2.putExtra("stars", Stars);
 				  startActivity(intent2);
 				}
 			    else{
 			    	if (time % 5 == 0 && time != 60){
 					//renovar interfaz
 			    		generateContenidor();
	 				}
	 				TextView t = (TextView) findViewById(R.id.time);
	 				t.setText(Integer.toString(time));
	 				time = time - 1;
	 				//actualizar UI
	 				
	 				timer.postDelayed(RefreshTimer, 1000);
 			    }
 	        }
 		   
 		};
        
        
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        InitElements();
        
        InitGame();
        
    }
	
	
	private void InitGame() {
//		timer.schedule((TimerTask) RefreshTimer, 1000);
		timer.postDelayed(RefreshTimer, 1000);
		
		
	}
	
	
	
	private void InitElements() {
		contenidor = new Contenidor();
		rndContenidor = new Random();
		rndElement = new Random();
		remainElements = 30;
		time = 60;
		//setear los elementos clicables
		initClicable();
		//generar contenedor activo
		generateContenidor();
		//generar los elementos de la parrilla
		generateParrilla();
	}
	
	private void initClicable() {
		ImageView img = (ImageView) findViewById(R.id.back);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.pause);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.reset);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object1);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object2);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object3);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object4);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object5);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object6);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object7);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object8);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object9);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object10);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object11);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object12);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object13);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object14);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object15);
		img.setOnClickListener(this);
		img = (ImageView) findViewById(R.id.object16);
		img.setOnClickListener(this);
	
	
	}
	private void generateContenidor(){
		int seleccio = rndContenidor.nextInt(6);
		desactivaContenidor();
		contenidorActiu = seleccio;
		ImageView img;
		//pendiente
		switch (seleccio){
			case 0:
				img = (ImageView) findViewById(R.id.vidre);
				img.setImageDrawable(getResources().getDrawable(R.drawable.verd_on));
				break;
			case 1:
				img = (ImageView) findViewById(R.id.plastic);
				img.setImageDrawable(getResources().getDrawable(R.drawable.groc_on));
				break;
			case 2:
				img = (ImageView) findViewById(R.id.paper);
				img.setImageDrawable(getResources().getDrawable(R.drawable.blau_on));
				break;
			case 3:
				img = (ImageView) findViewById(R.id.organica);
				img.setImageDrawable(getResources().getDrawable(R.drawable.marro_on));
				break;
			case 4:
				img = (ImageView) findViewById(R.id.rebuig);
				img.setImageDrawable(getResources().getDrawable(R.drawable.gris_on));
				break;
			case 5:
				img = (ImageView) findViewById(R.id.punt_verd);
				img.setImageDrawable(getResources().getDrawable(R.drawable.punt_verd_on));
				break;
		}
	}
	private void desactivaContenidor(){
		ImageView img;
		switch (contenidorActiu){
			case 0:
				img = (ImageView) findViewById(R.id.vidre);
				img.setImageDrawable(getResources().getDrawable(R.drawable.verd_off));
				break;
			case 1:
				img = (ImageView) findViewById(R.id.plastic);
				img.setImageDrawable(getResources().getDrawable(R.drawable.groc_off));
				break;
			case 2:
				img = (ImageView) findViewById(R.id.paper);
				img.setImageDrawable(getResources().getDrawable(R.drawable.blau_off));
				break;
			case 3:
				img = (ImageView) findViewById(R.id.organica);
				img.setImageDrawable(getResources().getDrawable(R.drawable.marro_off));
				break;
			case 4:
				img = (ImageView) findViewById(R.id.rebuig);
				img.setImageDrawable(getResources().getDrawable(R.drawable.gris_off));
				break;
			case 5:
				img = (ImageView) findViewById(R.id.punt_verd);
				img.setImageDrawable(getResources().getDrawable(R.drawable.punt_verd_off));
				break;
		}
	}
	
	private void generateParrilla(){
		parrilla = new Vector<Game.ParrillaElement>();
		int cat;
		int id;
		contenidor.initNElements();
		for (int i = 0; i < 16; i++){
			cat = rndElement.nextInt(6);
			if (i == 15)
				cat = checkMinimOneElement(i, cat);
			id = rndElement.nextInt(contenidor.getMaxElem(cat));
			//id = checkMinimOneElement(i);
			ParrillaElement element = new ParrillaElement(id, cat, contenidor.getElement(cat, id));
			parrilla.add(element);
			setImage(i, id, cat);
			//increaseCat
		}
	}
	
	private int checkMinimOneElement(int i, int cat) {
		//int ID = rndElement.nextInt(contenidor.getMaxElem(cat));
		if (contenidorActiu == 0 && contenidor.nVerd == 0){
			return contenidorActiu;
		}
		else if (contenidorActiu == 1 && contenidor.nGroc == 0){
			return contenidorActiu;
		}
		else if (contenidorActiu == 2 && contenidor.nBlau == 0){
			return contenidorActiu;
		}
		else if (contenidorActiu == 3 && contenidor.nMarro == 0){
			return contenidorActiu;
		}
		else if (contenidorActiu == 4 && contenidor.nGris == 0){
			return contenidorActiu;
		}
		else if (contenidorActiu == 5 && contenidor.nPuntVerd == 0){
			return contenidorActiu;
		}
	
		return cat;
	}
	private void refreshCell(int i){
		int cat = rndElement.nextInt(6);
		int id = rndElement.nextInt(contenidor.getMaxElem(cat));
		ParrillaElement element = new ParrillaElement(id, cat, contenidor.getElement(cat, id));
		parrilla.set(i, element);
		setImage(i, id, cat);
	}
	
	/**
	 * @param i
	 * @param id
	 * @param cat
	 */
	private void setImage(int i, int id, int cat) {
		ImageView img = null;
		
		//capturamos el id de la imagen que vamos a setear
		if (i == 0)
			img = (ImageView) findViewById(R.id.object1);
		else if(i == 1)
			img = (ImageView) findViewById(R.id.object2);			
		else if(i == 2)
			img = (ImageView) findViewById(R.id.object3);			
		else if(i == 3)
			img = (ImageView) findViewById(R.id.object4);			
		else if(i == 4)
			img = (ImageView) findViewById(R.id.object5);			
		else if(i == 5)
			img = (ImageView) findViewById(R.id.object6);			
		else if(i == 6)
			img = (ImageView) findViewById(R.id.object7);			
		else if(i == 7)
			img = (ImageView) findViewById(R.id.object8);			
		else if(i == 8)
			img = (ImageView) findViewById(R.id.object9);			
		else if(i == 9)
			img = (ImageView) findViewById(R.id.object10);			
		else if(i == 10)
			img = (ImageView) findViewById(R.id.object11);			
		else if(i == 11)
			img = (ImageView) findViewById(R.id.object12);			
		else if(i == 12)
			img = (ImageView) findViewById(R.id.object13);			
		else if(i == 13)
			img = (ImageView) findViewById(R.id.object14);			
		else if(i == 14)
			img = (ImageView) findViewById(R.id.object15);			
		else if(i == 15)
			img = (ImageView) findViewById(R.id.object16);			
		
		//incrementamos contador de elementos
		if (cat == 0){
			contenidor.nVerd++;
		}
		else if (cat == 1){
			contenidor.nGroc++;
		}
		else if (cat == 2){
			contenidor.nBlau++;
		}
		else if (cat == 3){
			contenidor.nMarro++;
		}
		else if (cat == 4){
			contenidor.nGris++;
		}
		else if (cat == 5){
			contenidor.nPuntVerd++;
		}
		
		
		if (img != null){
//			InputStream is = getClass().getResourceAsStream("/drawable/" + contenidor.getElement(cat, id));
//			img.setImageDrawable(Drawable.createFromStream(is, ""));
			int resId = getResources().getIdentifier(contenidor.getElement(cat, id), "drawable", getPackageName());
			img.setImageResource(resId);
		}
		
	}

	//checkelement
	private void checkElement(int index){
		if (parrilla.get(index).getCat() == contenidorActiu){
			refreshCell(index);
			remainElements--;
			TextView remain = (TextView) findViewById(R.id.objective);
			remain.setText(Integer.toString(remainElements));
			if (parrilla.get(index).getCat() == 0){
				contenidor.nVerd--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu && contenidor.nVerd == 0){
					generateParrilla();
				}
			}
			else if (parrilla.get(index).getCat() == 1){
				contenidor.nGroc--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu && contenidor.nGroc == 0){
					generateParrilla();
				}
			}
			else if (parrilla.get(index).getCat() == 2){
				contenidor.nBlau--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu && contenidor.nBlau == 0){
					generateParrilla();
				}
			}
			else if (parrilla.get(index).getCat() == 3){
				contenidor.nMarro--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu&& contenidor.nMarro == 0){
					generateParrilla();
				}
			}
			else if (parrilla.get(index).getCat() == 4){
				contenidor.nGris--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu&& contenidor.nGris == 0){
					generateParrilla();
				}
			}
			else if (parrilla.get(index).getCat() == 5){
				contenidor.nPuntVerd--;
				//comprobamos si ya no quedan elementos del contenedor 
				if(parrilla.get(index).getCat() == contenidorActiu && contenidor.nPuntVerd == 0){
					generateParrilla();
				}
			}
			
			
		}
		else{
			Fails++;
			if (Fails % 2 == 0){
				Stars--;
				//actualizar estrellas en la interfaz
				if (Fails == 2){ 
					ImageView st = (ImageView) findViewById(R.id.stars);
					st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_2));
				}
				else if(Fails == 4) {
					ImageView st = (ImageView) findViewById(R.id.stars);
					st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_1));
				}
				else if(Fails == 6) {
					ImageView st = (ImageView) findViewById(R.id.stars);
					st.setImageDrawable(getResources().getDrawable(R.drawable.estrellas_0));
				}
			}
		}
	}
	
	
	

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.back){
			final Intent intent2 = new Intent(this, Levels.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent2);
		}
		else if(id == R.id.reset){
			final Intent intent2 = new Intent(this, Game.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent2);
		}
		else if(id == R.id.object1){
			checkElement(0);
		}
		else if(id == R.id.object2){
			checkElement(1);
		}
		else if(id == R.id.object3){
			checkElement(2);
		}
		else if(id == R.id.object4){
			checkElement(3);
		}
		else if(id == R.id.object5){
			checkElement(4);
		}
		else if(id == R.id.object6){
			checkElement(5);
		}
		else if(id == R.id.object7){
			checkElement(6);
		}
		else if(id == R.id.object8){
			checkElement(7);
		}
		else if(id == R.id.object9){
			checkElement(8);
		}
		else if(id == R.id.object10){
			checkElement(9);
		}
		else if(id == R.id.object11){
			checkElement(10);
		}
		else if(id == R.id.object12){
			checkElement(11);
		}
		else if(id == R.id.object13){
			checkElement(12);
		}
		else if(id == R.id.object14){
			checkElement(13);
		}
		else if(id == R.id.object15){
			checkElement(14);
		}
		else if(id == R.id.object16){
			checkElement(15);
		}
	}

	public class ParrillaElement{
		private int id;
		private int cat;
		private String img;
		public ParrillaElement(int id, int cat, String imag){
			this.id = id;
			this.cat = cat;
			this.img = imag;
		}
		public int getID(){
			return id;
		}
		public int getCat(){
			return cat;
		}
		public String getImg(){
			return img;
		}
		public void setID(int iD){
			id = iD;
		}
		public void setCat(int caT){
			cat = caT;
		}
		public void setImg(String imag){
			img = imag;
		}
	}
}
