package com.mobisfera.onvasnevas;

import java.util.Random;
import java.util.Vector;

public class Contenidor {
	Marro mArro;
	Verd vErd;
	Blau bLau;
	Gris gRis;
	Groc gRoc;
	PuntVerd puntVerd; 
	
	int nVerd;
	int nGris;
	int nGroc;
	int nBlau;
	int nMarro;
	int nPuntVerd;
	enum contenidors {VERD, GROC, BLAU, MARRO, GRIS, PUNTVERD};
	public Contenidor(){
		mArro = new Marro();
		vErd = new Verd();
		bLau = new Blau();
		gRis = new Gris();
		gRoc = new Groc();
		puntVerd = new PuntVerd();
		initNElements();
		
		
	}
	
	public void initNElements() {
		setBlau(0);
		setGris(0);
		setGroc(0);
		setMarro(0);
		setPuntVerd(0);
		setVerd(0);
		
	}
	
	public int getMaxElem(int tag){
		//verd
		if (tag == 0){
			return vErd.Imagenes.size();
		}
		//groc
		else if (tag == 1){
			return gRoc.Imagenes.size();
		}
		//blau
		else if (tag == 2){
			return bLau.Imagenes.size();
		}
		//Marro
		else if (tag == 3){
			return mArro.Imagenes.size();
		}
		//gris
		else if (tag == 4){
			return gRis.Imagenes.size();
		}
		//punt verd
		else if (tag == 5){
			return puntVerd.Imagenes.size();
		}
		return -1;
	}
	public String getElement(int cat, int id){
		if (cat == 0){
			return vErd.getVerd(id);
		}
		else if (cat == 1){
			return gRoc.getGroc(id);
		}
		else if (cat == 2){
			return bLau.getBlau(id);
		}
		else if (cat == 3){
			return mArro.getMarro(id);
		}
		else if (cat == 4){
			return gRis.getGris(id);
		}
		else if (cat == 5){
			return puntVerd.getPuntVerd(id);
			
		}
		return "";
	}
	
	public void setMarro(int n){
		nMarro = n;
	}

	public void setVerd(int n){
		nVerd = n;
	}

	public void setBlau(int n){
		nBlau = n;
	}

	public void setGroc(int n){
		nGroc = n;
	}

	public void setGris(int n){
		nGris = n;
	}

	public void setPuntVerd(int n){
		nPuntVerd = n;
	}

	public int getMarro(){
		return nMarro;
	}

	public int getVerd(){
		return nVerd;
	}

	public int getBlau(){
		return nBlau;
	}

	public int getGroc(){
		return nGroc;
	}

	public int getGris(){
		return nGris;
	}

	public int getPuntVerd(){
		return nPuntVerd;
	}
	
	public class Marro {
		Vector<String> Imagenes;
		
		public Marro(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
			Imagenes.add("marro_1");
			Imagenes.add("marro_2");
			Imagenes.add("marro_3");
			Imagenes.add("marro_4");
			Imagenes.add("marro_5");
			Imagenes.add("marro_6");
			Imagenes.add("marro_7");
			Imagenes.add("marro_8");			
		}
		
		public boolean esMarro(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getMarro(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
		
	}
	public class Verd {
		Vector<String> Imagenes;
		
		public Verd(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
		//	Imagenes.add("Verd_1");
			Imagenes.add("verd_2");
			Imagenes.add("verd_3");
			Imagenes.add("verd_4");
			Imagenes.add("verd_5");
			Imagenes.add("verd_6");
			Imagenes.add("verd_7");
			Imagenes.add("verd_8");
			Imagenes.add("verd_9");
			Imagenes.add("verd_10");
			Imagenes.add("verd_11");
			Imagenes.add("verd_12");
			Imagenes.add("verd_13");
			Imagenes.add("verd_14");
			Imagenes.add("verd_15");			

		}
		
		public boolean esVerd(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getVerd(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
	}
	
	public class Blau {
		Vector<String> Imagenes;
		
		public Blau(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
			Imagenes.add("blau_1");
			Imagenes.add("blau_2");
			Imagenes.add("blau_3");
			Imagenes.add("blau_4");
			Imagenes.add("blau_5");
			Imagenes.add("blau_6");
			Imagenes.add("blau_7");
			Imagenes.add("blau_8");
			Imagenes.add("blau_9");
			Imagenes.add("blau_10");
			Imagenes.add("blau_11");
			Imagenes.add("blau_12");
			Imagenes.add("blau_13");
			Imagenes.add("blau_14");
			Imagenes.add("blau_15");			
			Imagenes.add("blau_16");
		}
		
		public boolean esBlau(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getBlau(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
	}
	
	public class Gris {
		Vector<String> Imagenes;
		
		public Gris(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
			Imagenes.add("gris_1");
			Imagenes.add("gris_2");
			Imagenes.add("gris_3");
			Imagenes.add("gris_4");
			Imagenes.add("gris_5");
	/*		Imagenes.add("Gris_6");
			Imagenes.add("Gris_7");
			Imagenes.add("Gris_8");
			Imagenes.add("Gris_9");
			Imagenes.add("Gris_10");
			Imagenes.add("Gris_11");
			Imagenes.add("Gris_12");
			Imagenes.add("Gris_13");
			Imagenes.add("Gris_14");
			Imagenes.add("Gris_15");			
			Imagenes.add("Gris_16");*/
		}
		
		public boolean esGris(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getGris(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
	}
	

	public class Groc {
		Vector<String> Imagenes;
		
		public Groc(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
			Imagenes.add("groc_1");
			Imagenes.add("groc_2");
			Imagenes.add("groc_3");
			Imagenes.add("groc_4");
			Imagenes.add("groc_5");
			Imagenes.add("groc_6");
			Imagenes.add("groc_7");
			Imagenes.add("groc_8");
			Imagenes.add("groc_9");
			Imagenes.add("groc_10");
			Imagenes.add("groc_11");
			Imagenes.add("groc_12");
			Imagenes.add("groc_13");
			Imagenes.add("groc_14");
			Imagenes.add("groc_15");			
			Imagenes.add("groc_16");
			Imagenes.add("groc_17");
			Imagenes.add("groc_18");
			Imagenes.add("groc_19");
			Imagenes.add("groc_20");
			Imagenes.add("groc_21");
			Imagenes.add("groc_22");
			Imagenes.add("groc_23");
			Imagenes.add("groc_24");			
			Imagenes.add("groc_25");
		}
		
		public boolean esGroc(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getGroc(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
	}
	
	public class PuntVerd {
		Vector<String> Imagenes;
		
		public PuntVerd(){
			initImagenes();
		}

		private void initImagenes() {
			Imagenes = new Vector<String>();
			Imagenes.add("punt_verd_1");
			Imagenes.add("pun_verd_2");
			Imagenes.add("pun_verd_3");
			Imagenes.add("punt_verd_4");
			Imagenes.add("punt_verd_5");
			Imagenes.add("punt_verd_6");
			Imagenes.add("punt_verd_7");
			Imagenes.add("punt_verd_8");
			Imagenes.add("punt_verd_9");
			Imagenes.add("punt_verd_10");
			Imagenes.add("punt_verd_11");
			/*Imagenes.add("puntVerd_12");
			Imagenes.add("puntVerd_13");
			Imagenes.add("puntVerd_14");
			Imagenes.add("puntVerd_15");			
			Imagenes.add("puntVerd_16");
			Imagenes.add("puntVerd_17");
			Imagenes.add("puntVerd_18");
			Imagenes.add("puntVerd_19");
			Imagenes.add("puntVerd_20");
			Imagenes.add("puntVerd_21");
			Imagenes.add("puntVerd_22");
			Imagenes.add("puntVerd_23");
			Imagenes.add("puntVerd_24");			
			Imagenes.add("puntVerd_25");*/
		}
		
		public boolean esPuntVerd(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (Imagenes.get(i).equals(name))
					return true;
			}
			return false;
		}
		public String getRandom(){
			Random rnd = new Random();
			return Imagenes.get(rnd.nextInt(8));
		}
		public String getPuntVerd(int index){
			return Imagenes.get(index);
		}
		
		public int getPos(String name){
			for (int i = 0; i < Imagenes.size(); i++){
				if (name.equals(Imagenes.get(i)))
					return i;
			}
			return -1;
		}
		
	}

	
	
}
