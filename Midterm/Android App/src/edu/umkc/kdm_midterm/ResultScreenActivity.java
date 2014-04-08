package edu.umkc.kdm_midterm;

import java.util.ArrayList;

import edu.umkc.kdm_midterm.adapter.ImageBundle;
import edu.umkc.kdm_midterm.adapter.ResultAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ResultScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_layout);
		
		ListView lv = (ListView)findViewById(R.id.listView1);
		
		ResultAdapter adapter = new ResultAdapter(this, getResult());
		lv.setAdapter(adapter);
	}

	private ArrayList<ImageBundle> getResult() {
		ArrayList<ImageBundle> imageBean = new ArrayList<ImageBundle>();
		
		
		imageBean.add(new ImageBundle("0743403843","http://images.amazon.com/images/P/0743403843.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("8445071769","http://images.amazon.com/images/P/8445071769.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("8445071777","http://images.amazon.com/images/P/8445071777.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0440225701","http://images.amazon.com/images/P/0440225701.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0060930365","http://images.amazon.com/images/P/0060930365.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0679429220","http://images.amazon.com/images/P/0679429220.01.MZZZZZZZ.jpg"));
		return imageBean;
	}
}
