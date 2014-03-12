package edu.kdm.recipereccomender;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.NumberPicker;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		NumberPicker min = (NumberPicker) findViewById(R.id.min);
		min.setMaxValue(60);
		min.setMinValue(0);
		min.setWrapSelectorWheel(false);
		
		NumberPicker hr = (NumberPicker) findViewById(R.id.hr);
		hr.setMaxValue(12);
		hr.setMinValue(0);
		hr.setWrapSelectorWheel(false);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
