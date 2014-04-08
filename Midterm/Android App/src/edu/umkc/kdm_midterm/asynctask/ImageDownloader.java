package edu.umkc.kdm_midterm.asynctask;

import java.io.IOException;
import java.net.URL;

import edu.umkc.kdm_midterm.adapter.ImageBundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageDownloader extends AsyncTask<Void, Void, Void>{
	
	private ImageView view;
	private URL url;
	private Bitmap bit;
	private ImageBundle bundle;
	public ImageDownloader(ImageView view, URL url, ImageBundle imageBundle){
		this.view = view;
		this.url = url;
		this.bundle = imageBundle;
	}

	@Override
	protected Void doInBackground(Void... params) {
		
		try {
			bit = BitmapFactory.decodeStream(url.openConnection() .getInputStream());
			bundle.bmp = bit;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		
		super.onPostExecute(result);
		if(bit!=null)
		view.setImageBitmap(bit);
		
	}

}
