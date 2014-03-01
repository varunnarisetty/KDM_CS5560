package com.example.kdmlab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RajeshActivity extends Activity {

	EditText et;
	Button bt;
	public static String url = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.rajesh_layout);
		
		bt = (Button)findViewById(R.id.button1);
		et = (EditText)findViewById(R.id.editText1);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				url = "http://10.205.0.48:8080/FirstRestWebService/rest/json/metallica/" +et.getText().toString().trim();
				Intent intent = new Intent(RajeshActivity.this, DisplayMessageActivity.class);
			    
				   // String message = editText.getText().toString();
				    //intent.putExtra(EXTRA_MESSAGE, message);
					intent.putExtra("result", new String[]{""});
				    startActivity(intent);
			}
		});
		
	}
}
