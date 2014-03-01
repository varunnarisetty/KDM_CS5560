package com.example.kdmlab4;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView lv;
	public static String url = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv = (ListView)findViewById(R.id.listView1);
		String[] values = new String[100];
		for(int i=0;i<100;i++){
			values[i] = "User "+i;
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        R.layout.list_item, R.id.label, values);
		
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Toast.makeText(MainActivity.this, "clicked user"+ arg2, Toast.LENGTH_SHORT).show();
				MovieRecommenderClass task = new MovieRecommenderClass(new CompleteListener(){

					@Override
					public void onReccomendationComplete(String[] arg0) {
						
						System.out.println("completed");
						
						Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
					    
					   // String message = editText.getText().toString();
					    //intent.putExtra(EXTRA_MESSAGE, message);
						intent.putExtra("result", arg0);
					    startActivity(intent);
					}
					
				});
				task.execute(new String[]{arg2+""});
				
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	
	class MovieRecommenderClass extends AsyncTask<String, Void, String>{

		private CompleteListener listener;
		
		public MovieRecommenderClass(CompleteListener listener){
			this.listener = listener;
		}
		
		
		@Override
		protected String doInBackground(String... params) {
	        StringBuilder stringBuilder = new StringBuilder();
	        try {
	        String zipcode = params[0];
	        zipcode = zipcode.replaceAll(" ","%20");    
	        url = "http://10.205.0.48:8080/FirstRestWebService/rest/json/metallica/" +zipcode.trim();
	        System.out.println(url);
	        HttpPost httppost = new HttpPost(url);
	        HttpClient client = new DefaultHttpClient();
	        HttpResponse response;
	        stringBuilder = new StringBuilder();


	            response = client.execute(httppost);
	            HttpEntity entity = response.getEntity();
	            InputStream stream = entity.getContent();
	            int b;
	            while ((b = stream.read()) != -1) {
	                stringBuilder.append((char) b);
	            }
	        } catch (ClientProtocolException e) {
	        	e.printStackTrace();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }

	        String result = stringBuilder.toString();
	       System.out.println(result);

	        return result;
	    }
		
		@Override
		protected void onPostExecute(String resul) {			
			super.onPostExecute(resul);
			try{
				
				//Toast.makeText(MainActivity.this, "result"+ resul, Toast.LENGTH_SHORT).show();
				 listener.onReccomendationComplete(resul.split(" "));
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	
		
	}
	
	interface CompleteListener{
		
		public void onReccomendationComplete(String[] result);
	}
}
