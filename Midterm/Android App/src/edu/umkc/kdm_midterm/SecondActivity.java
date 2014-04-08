package edu.umkc.kdm_midterm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends Activity {

	private ImageView img1;
	private ImageView img2;
	private ImageView img3;
	private ImageView img4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.collage_layout);
		Button result = (Button)findViewById(R.id.button1);
		img1 = (ImageView)findViewById(R.id.imageView1);
		img2 = (ImageView)findViewById(R.id.imageView2);
		img3 = (ImageView)findViewById(R.id.imageView3);
		img4 = (ImageView)findViewById(R.id.ImageView01);
		
		img1.setImageBitmap(BitmapFactory.decodeFile("/sdcard/kdm/"+MainActivity.list.get(0)+".jpg"));
		img2.setImageBitmap(BitmapFactory.decodeFile("/sdcard/kdm/"+MainActivity.list.get(1)+".jpg"));
		img3.setImageBitmap(BitmapFactory.decodeFile("/sdcard/kdm/"+MainActivity.list.get(2)+".jpg"));
		img4.setImageBitmap(BitmapFactory.decodeFile("/sdcard/kdm/"+MainActivity.list.get(3)+".jpg"));
		
		result.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SecondActivity.this,ResultScreenActivity.class);
				startActivity(intent);
			}
		});
	}
}
