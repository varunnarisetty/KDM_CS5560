package edu.umkc.kdm_midterm.adapter;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.umkc.kdm_midterm.R;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	public ArrayList<ImageBundle> imageBean = new ArrayList<ImageBundle>();
	public ImageAdapter(Context c) {
		mContext = c;
		generateImageBeans();
		
	}

	public int getCount() {
		return imageBean.size();
	}

	public Object getItem(int position) {
		return imageBean.get(position);
	}

	public long getItemId(int position) {
		return position;
	}
	
	static class ViewHolder {
	    protected ImageView image;
	    protected TextView title;
	    
	  }

	
	
	@SuppressLint("NewApi")
	public View getView(int position, View convertView, ViewGroup parent) {
	View view = null;
    if (convertView == null) {
      LayoutInflater inflator = ((Activity)mContext).getLayoutInflater();
      view = inflator.inflate(R.layout.move_row, null);
      final ViewHolder viewHolder = new ViewHolder();
      viewHolder.image = (ImageView) view.findViewById(R.id.img);
      //viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
      viewHolder.title = (TextView)view.findViewById(R.id.title);
     
      view.setTag(viewHolder);
      viewHolder.image.setTag(imageBean.get(position));
     
    } else {
      view = convertView;
      //((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
    }
    ViewHolder holder = (ViewHolder) view.getTag();
    if(imageBean.get(position).bmp == null){
    	Bitmap bmp = BitmapFactory.decodeFile("/sdcard/kdm/"+imageBean.get(position).getId()+".jpg");
    	if(bmp == null){
    		bmp = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_launcher);
    	}
    	holder.image.setImageBitmap(bmp);
    }else{
    	holder.image.setImageBitmap(imageBean.get(position).bmp);	
    }
    
    holder.title.setText(imageBean.get(position).getId());
    if(imageBean.get(position).isSelected){
		
		(view).setBackgroundColor(Color.parseColor("#0080FF"));
	}else{
		
		view.setBackground(null);
		
	}
    return view;
	}
	

	

	private void generateImageBeans(){

		imageBean.add(new ImageBundle("0375406328","http://images.amazon.com/images/P/0375406328.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0446310786","http://images.amazon.com/images/P/0446310786.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0449005615","http://images.amazon.com/images/P/0449005615.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0060168013","http://images.amazon.com/images/P/0060168013.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("038078243X","http://images.amazon.com/images/P/038078243X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("055321215X","http://images.amazon.com/images/P/055321215X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("067176537X","http://images.amazon.com/images/P/067176537X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0061099686","http://images.amazon.com/images/P/0061099686.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0553582909","http://images.amazon.com/images/P/0553582909.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0671888587","http://images.amazon.com/images/P/0671888587.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0553582747","http://images.amazon.com/images/P/0553582747.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0425182908","http://images.amazon.com/images/P/0425182908.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("042518630X","http://images.amazon.com/images/P/042518630X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0440223571","http://images.amazon.com/images/P/0440223571.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0812523873","http://images.amazon.com/images/P/0812523873.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0842342702","http://images.amazon.com/images/P/0842342702.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0440225701","http://images.amazon.com/images/P/0440225701.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0060914068","http://images.amazon.com/images/P/0060914068.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0156047624","http://images.amazon.com/images/P/0156047624.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0245542957","http://images.amazon.com/images/P/0245542957.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0380715899","http://images.amazon.com/images/P/0380715899.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0553280333","http://images.amazon.com/images/P/0553280333.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0961769947","http://images.amazon.com/images/P/0961769947.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0964778319","http://images.amazon.com/images/P/0964778319.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0671623249","http://images.amazon.com/images/P/0671623249.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0679810307","http://images.amazon.com/images/P/0679810307.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0679865691","http://images.amazon.com/images/P/0679865691.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "2070423204","http://images.amazon.com/images/P/2070423204.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0345260317","http://images.amazon.com/images/P/0345260317.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0394743741","http://images.amazon.com/images/P/0394743741.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("042511774X","http://images.amazon.com/images/P/042511774X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0804106304","http://images.amazon.com/images/P/0804106304.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("1853262404","http://images.amazon.com/images/P/1853262404.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0312970242","http://images.amazon.com/images/P/0312970242.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "1853260053","http://images.amazon.com/images/P/1853260053.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("1414035004","http://images.amazon.com/images/P/1414035004.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0140067477","http://images.amazon.com/images/P/0140067477.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0345465083","http://images.amazon.com/images/P/0345465083.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0451625889","http://images.amazon.com/images/P/0451625889.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("1558531025","http://images.amazon.com/images/P/1558531025.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0441783589","http://images.amazon.com/images/P/0441783589.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0394895894","http://images.amazon.com/images/P/0394895894.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("1569871213","http://images.amazon.com/images/P/1569871213.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0375410538","http://images.amazon.com/images/P/0375410538.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0966986105","http://images.amazon.com/images/P/0966986105.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("087113375X","http://images.amazon.com/images/P/087113375X.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0340767936","http://images.amazon.com/images/P/0340767936.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0743403843","http://images.amazon.com/images/P/0743403843.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0060930365","http://images.amazon.com/images/P/0060930365.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0060177586","http://images.amazon.com/images/P/0060177586.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0071416331","http://images.amazon.com/images/P/0071416331.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0375509038","http://images.amazon.com/images/P/0375509038.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0553062042","http://images.amazon.com/images/P/0553062042.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("0316769487","http://images.amazon.com/images/P/0316769487.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("8445071408","http://images.amazon.com/images/P/8445071408.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("8445071769","http://images.amazon.com/images/P/8445071769.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle("8445071777","http://images.amazon.com/images/P/8445071777.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0679429220","http://images.amazon.com/images/P/0679429220.01.MZZZZZZZ.jpg"));
		imageBean.add(new ImageBundle( "0671867156","http://images.amazon.com/images/P/0671867156.01.MZZZZZZZ.jpg"));
	}
}