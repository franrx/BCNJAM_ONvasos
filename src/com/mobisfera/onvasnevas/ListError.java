package com.mobisfera.onvasnevas;

import java.io.File;
import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListError extends Activity {
	
	private LayoutInflater mInflater;
	//private Vector<RowData> dat;
	//private RowData rd;
	private ListView infosList;
	//private infoAdapter adapter;
	//private Vector<Info> infos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.error_list);
		mInflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		//addInfo();
	}
	
	/*private void addInfo() {
		dat = new Vector<RowData>();
		for(int i = 0; i < infos.size(); i++) {
			rd = new RowData(infos.get(i).getTitle(), ImageFetcher.downloadBitmap(getApplicationContext(), urlImages + infos.get(i).getImage()));
			dat.add(rd);
		}
		infosList = (ListView) findViewById(R.id.info);
		adapter = new infoAdapter (this, R.layout.infoclub_item, R.id.title, dat);
		infosList.setAdapter(adapter);
		infosList.setOnItemClickListener(this);
	}
	
	
	private class infoAdapter extends ArrayAdapter<RowData> {

		public infoAdapter(Context context, int resource, int title, List<RowData> objects) {
			super(context, resource, objects);
		}

		@Override
	    public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
		    TextView title = null;
		    ImageView thumbnail = null;
		    
		    RowData rowData= getItem(position);
		    if(null == convertView){
		    	convertView = mInflater.inflate(R.layout.infoclub_item, null);
		        holder = new ViewHolder(convertView);
		        convertView.setTag(holder);
		    }
		    
		    holder = (ViewHolder) convertView.getTag();
            
		    title = holder.getTitle();
            title.setText(rowData.Title);
            
            thumbnail = holder.getThumbnail();
            thumbnail.setImageBitmap(rowData.Thumbnail);
            return convertView;
		}
		
		private class ViewHolder {
			private View mRow;
	        private TextView title = null;
	        private ImageView thumbnail = null;
	        
	        public ViewHolder(View row) {
	        	mRow = row;
	        }
	        
	        public TextView getTitle() {
	        	if(null == title) {
	        		title = (TextView) mRow.findViewById(R.id.title);
	        	}
	        	return title;
	        }   
	        
	        public ImageView getThumbnail() {
	        	if(null == thumbnail) {
	        		thumbnail = (ImageView) mRow.findViewById(R.id.thumbnail);
	        	}
	        	return thumbnail;
	        }
		}
	}
	
	private class RowData {
	    protected String Title;
		protected Bitmap Thumbnail;
	    RowData(String title, File thumbnail) {
	    	Title = title;
	    	Thumbnail = decodeBitmap(thumbnail);
	    }
	    
	    @Override
	    public String toString() {
	    	return Title;
	    }
	}*/


}
