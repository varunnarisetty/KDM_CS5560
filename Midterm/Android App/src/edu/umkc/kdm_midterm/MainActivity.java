package edu.umkc.kdm_midterm;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import edu.umkc.kdm_midterm.adapter.ImageAdapter;
import edu.umkc.kdm_midterm.adapter.ImageBundle;

public class MainActivity extends Activity {

	private ImageAdapter adapter;
	public static ArrayList<String> list = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		File file = new File("/sdcard/kdm/");
		file.mkdirs();
		GridView gridview = (GridView) findViewById(R.id.gridview);
		Button button = (Button)findViewById(R.id.button1);
		adapter = new ImageAdapter(this);
	    gridview.setAdapter(adapter);
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				arg1.setBackgroundColor(Color.parseColor("#0080FF"));
				list.add(((ImageBundle)adapter.getItem(arg2)).id);
			}
		});

	    button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
