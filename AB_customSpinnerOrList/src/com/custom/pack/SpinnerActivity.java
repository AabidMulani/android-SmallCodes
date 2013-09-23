package com.custom.pack;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerActivity extends Activity {
	Spinner spn=null;
	String str[]={
			"AAbid","Yogesh","Sagar","Salwa","Afrin","Abdullah"
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spn=(Spinner)findViewById(R.id.spin1);
        try{
        	//	spn.setAdapter(new MyAdapter(this));
        		spn.setAdapter(new MyAdapter(getApplicationContext()));
        }catch(Exception e){
    	Toast.makeText(this, "Error he be....", Toast.LENGTH_SHORT).show();
        }
    }
    class MyAdapter extends BaseAdapter{
    	LayoutInflater minflate;
    	public Bitmap micon[] = new Bitmap[6];
		public MyAdapter(Context cc){
            minflate = LayoutInflater.from(cc);
            micon[0]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.aa);
            micon[1]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.ab);
            micon[2]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.ac);
            micon[3]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.aq);
            micon[4]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.ay);
            micon[5]=	BitmapFactory.decodeResource(cc.getResources(), R.drawable.az);
		}
		public int getCount() {
			return micon.length;
		}
		public Object getItem(int position) {
			return position;
		}
			public long getItemId(int position) {
				return position;
		}
        public View getView(int position, View convertView, ViewGroup parent) {        
            ViewHolder holder;
            if (convertView == null) {
                convertView = minflate.inflate(R.layout.spinnerlayout, null);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.spintext);
                holder.icon = (ImageView) convertView.findViewById(R.id.spinimage);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.text.setText(str[position]);
            holder.icon.setImageBitmap(micon[position]);
            return convertView;
        }
    }
	        static class ViewHolder {
	            TextView text;
	            ImageView icon;
	        }
}