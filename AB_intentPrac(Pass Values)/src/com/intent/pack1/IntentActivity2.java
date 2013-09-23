package com.intent.pack1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class IntentActivity2 extends Activity implements OnClickListener{
	Bundle receivedData;
	CharSequence Sname,Sdata;
	TextView Lname,Ldata;
	Button btn;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen2);
		receivedData = getIntent().getExtras();
		if(receivedData==null){
			Toast.makeText(this, "No DATA found in Extras", Toast.LENGTH_SHORT).show();
			return;
		}
		Sname=receivedData.getString("Name");
		Sdata=receivedData.getCharSequence("Data");
		Lname=(TextView)findViewById(R.id.nameView1);
		Ldata=(TextView)findViewById(R.id.dataView1);
		btn=(Button)findViewById(R.id.screenbutton1);
		btn.setOnClickListener(this);
	}
	public void onClick(View v) {
		Lname.setText(Sname);
		Ldata.setText(Sdata);
		Toast.makeText(this, Sname , Toast.LENGTH_SHORT).show();
	}

}
