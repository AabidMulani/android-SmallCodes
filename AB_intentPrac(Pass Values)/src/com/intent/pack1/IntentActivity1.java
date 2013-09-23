package com.intent.pack1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class IntentActivity1 extends Activity implements OnClickListener {
private static final int REQUEST_CODE = 10;
Button submit;
EditText name,data;
Intent i;
protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen1);
		name=(EditText)findViewById(R.id.editText1);
		data=(EditText)findViewById(R.id.editText2);
		submit=(Button)findViewById(R.id.button1);
		submit.setOnClickListener(IntentActivity1.this);
	}
	
	public void onClick(View v) {
		Toast.makeText(this, "Welcome" +name.getText()+data.getText(), Toast.LENGTH_SHORT).show();
		i=new Intent(this,IntentActivity2.class);
		// TODO Auto-generated method stub
		i.putExtra("Name", name.getText().toString());
		i.putExtra("Data", data.getText().toString());
		 startActivityForResult(i, REQUEST_CODE);
	}
	
}
