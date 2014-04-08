package edu.umkc.kdm_midterm.adapter;

import java.util.ArrayList;

import edu.umkc.kdm_midterm.R;
import edu.umkc.kdm_midterm.adapter.ImageAdapter.ViewHolder;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultAdapter extends BaseAdapter {

	
	private ArrayList<ImageBundle> list;
	private Activity mContext;
	public ResultAdapter(Activity mContext,ArrayList<ImageBundle> list){
		
		this.mContext = mContext;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		View view = null;
	    if (convertView == null) {
	      LayoutInflater inflator = mContext.getLayoutInflater();
	      view = inflator.inflate(R.layout.result_row, null);
	      final ViewHolder viewHolder = new ViewHolder();
	      viewHolder.image = (ImageView) view.findViewById(R.id.imageView1);
	      viewHolder.image.setImageBitmap(BitmapFactory.decodeFile("/sdcard/kdm/"+list.get(position).getId()+".jpg"));
	      viewHolder.title = (TextView)view.findViewById(R.id.textView1);
	      viewHolder.title.setText(list.get(position).id);
	      view.setTag(viewHolder);
	     
	     
	    } else {
	      view = convertView;
	      //((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
	    }
		return view;
	}

}
