package com.example.demoapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity {

	
	
	

	public EditText lat;
	public EditText long1;
	public Button latLong; 
	public EditText addressView;
	public TextView gasStationView;
	public Button cheap;
	
	private String zipcode;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.activity_main);
		lat = (EditText)findViewById(R.id.editText1);
		long1 = (EditText)findViewById(R.id.editText2);
		//adds = (Button)findViewById(R.id.button1);
		latLong = (Button)findViewById(R.id.button2);
		addressView = (EditText)findViewById(R.id.textView4);
		
		gasStationView = (TextView)findViewById(R.id.gas_station);
		cheap = (Button)findViewById(R.id.cheap);

		//adds.setOnClickListener(new View.OnClickListener() {});

		latLong.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(lat.getText().toString().trim().equals("") || long1.getText().toString().trim().equals("") ){
				JSONLocationTask task = new JSONLocationTask();
				task.execute(new String[]{addressView.getText().toString()});
				
				}else{


					String lat1 = lat.getText().toString();
					String lon = long1.getText().toString();
					List<android.location.Address> addresses = null;
					Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
					try {
						 addresses = geocoder.getFromLocation(Double.parseDouble(lat1), Double.parseDouble(lon), 1);
					} catch (NumberFormatException e) {
						Toast.makeText(MainActivity.this, "Enter proper numbers", Toast.LENGTH_SHORT).show();
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					String str = "";
					for(int i=0;addresses !=null && i<addresses.size();i++){
						android.location.Address add = addresses.get(i);
						str = str+add.getAddressLine(0);
						str = str+add.getAddressLine(1)+add.getCountryName()+add.getPostalCode();
						zipcode = add.getPostalCode();
						Toast.makeText(MainActivity.this, "ZipCode -->"+zipcode, Toast.LENGTH_SHORT).show();
					}
					
					addressView.setText(str);
					
					
					
					
				
				}
				
			}
		});
		
		cheap.setOnClickListener(new View.OnClickListener() {
			
			

			@Override
			public void onClick(View arg0) {
			
				if(!zipcode.equals("")){
				GasStationClass gas = new GasStationClass();
				
				gas.execute(new String[]{zipcode});
				}else{
					Toast.makeText(MainActivity.this, "Need to get zipcode from address or lat/long",Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	public static JSONObject getLocationInfo(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        try {

        address = address.replaceAll(" ","%20");    

        HttpPost httppost = new HttpPost("http://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false");
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
        } catch (IOException e) {
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObject;
    }


	

	
	

	
	private class JSONLocationTask extends AsyncTask<String, Void, JSONObject> {
		
		@Override
		protected JSONObject doInBackground(String... params) {
	        StringBuilder stringBuilder = new StringBuilder();
	        try {
	        String address = params[0];
	        address = address.replaceAll(" ","%20");    

	        HttpPost httppost = new HttpPost("http://maps.google.com/maps/api/geocode/json?address=" + address + "&sensor=false");
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
	        } catch (IOException e) {
	        }

	        JSONObject jsonObject = new JSONObject();
	        try {
	            jsonObject = new JSONObject(stringBuilder.toString());
	            
	            System.out.println(stringBuilder.toString());
	        } catch (JSONException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return jsonObject;
	    }
		
		@Override
		protected void onPostExecute(JSONObject jsonObject) {			
			super.onPostExecute(jsonObject);
			
			

	        try {
	        	String location = "";
	           double longitute = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
	                .getJSONObject("geometry").getJSONObject("location")
	                .getDouble("lng");

	           double latitude = ((JSONArray)jsonObject.get("results")).getJSONObject(0)
	                .getJSONObject("geometry").getJSONObject("location")
	                .getDouble("lat");
	           String zip = getZipCodeFromJSon(jsonObject);
	           MainActivity.this.lat.setText(""+latitude);
	           MainActivity.this.long1.setText(""+longitute);
	           MainActivity.this.zipcode = zip;
	          
	           
	        } catch (JSONException e) {
	        	 Toast.makeText(MainActivity.this, "Enter Proper Address:", Toast.LENGTH_SHORT).show();
	           e.printStackTrace();

	        }

	        
	    
			
		}
		
		private String getZipCodeFromJSon(JSONObject result)  {
			try{
			JSONArray arr = result.getJSONArray("results");
			//JSONArray obj = ((JSONObject) arr.get(0)).getJSONArray("address_components");
			JSONObject obj = (JSONObject) arr.get(0);
			JSONArray addArr = obj.getJSONArray("address_components");
			JSONObject postalObj = (JSONObject)addArr.get(addArr.length()-1);
			String zip = postalObj.getString("long_name");
			return zip;
			}catch(Exception e){
				return null;
			}
			
		}
			
	}

	
	class GasStationClass extends AsyncTask<String, Void, JSONObject>{

		
		@Override
		protected JSONObject doInBackground(String... params) {
	        StringBuilder stringBuilder = new StringBuilder();
	        try {
	        String zipcode = params[0];
	        zipcode = zipcode.replaceAll(" ","%20");    

	        HttpPost httppost = new HttpPost("http://www.mshd.net/api/gasprices/" +zipcode);
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
	        } catch (IOException e) {
	        }

	        JSONObject jsonObject = new JSONObject();
	        try {
	            jsonObject = new JSONObject(stringBuilder.toString());
	            
	            System.out.println(stringBuilder.toString());
	        } catch (JSONException e) {
	           
	            e.printStackTrace();
	        }

	        return jsonObject;
	    }
		
		@Override
		protected void onPostExecute(JSONObject jsonObject) {			
			super.onPostExecute(jsonObject);
			try{
			ArrayList<String> list = new ArrayList<String>();
			double d = 100.00;
			int minIndex = 0;
			JSONArray gaslist = jsonObject.getJSONArray("item");
			for(int i=0;i<gaslist.length();i++){
				JSONObject ob = (JSONObject)gaslist.get(i);
				double price = ob.getDouble("regular");
				if(price < d){
					minIndex = i;
				}
				String brand = ob.getString("brand");
				list.add(brand);
				//System.out.println("brand---->"+brand);
				Log.i("brand---->", brand);
			}
			
			JSONObject minObj = (JSONObject)gaslist.get(minIndex);
			
			String str = "Price :"+ minObj.getDouble("regular")+"\n";
			str = str + "Brand :"+ minObj.getString("brand")+"\n";
			str = str + "Address :"+minObj.getString("address");
			
			gasStationView.setText(str);
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
			
	
		
	}

	
}

