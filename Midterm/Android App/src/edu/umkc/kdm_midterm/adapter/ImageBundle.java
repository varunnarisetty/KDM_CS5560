package edu.umkc.kdm_midterm.adapter;

import android.graphics.Bitmap;

public class ImageBundle {

	public String id;
	public String url;
	public Bitmap bmp;
	public boolean isSelected;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ImageBundle(String id, String url) {
		
		this.id = id;
		this.url = url;
		isSelected = false;
	}
	
	
}
