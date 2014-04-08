package edu.umkc.kdm_midterm.asynctask;

import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import edu.umkc.kdm_midterm.adapter.ImageBundle;

public class Downloader extends AsyncTask<Void, Void, Void>{

	ArrayList<ImageBundle> list;
	
	public Downloader(ArrayList<ImageBundle> list) {
	this.list = list;
	}
	@Override
	protected Void doInBackground(Void... params) {
		for(int i =0; i < list.size(); i++){
		FileOutputStream out = null;
		try {
			URL url = new URL(list.get(i).getUrl());
			Bitmap bmp =  BitmapFactory.decodeStream(url.openConnection() .getInputStream());
		       out = new FileOutputStream("/sdcard/kdm/"+list.get(i).id+".jpg");
		       bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		       try{
		           out.close();
		       } catch(Throwable ignore) {}
		}
		}
		return null;
	}

}
