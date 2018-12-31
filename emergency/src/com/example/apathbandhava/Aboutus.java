package com.example.apathbandhava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Aboutus extends Activity {
 TextView tv;
 Button btn;
 String newname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aboutus);
		tv=(TextView)findViewById(R.id.textView1);
		btn=(Button)findViewById(R.id.button1);	
		
		btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=getIntent();
				 newname=in.getStringExtra("name");
				 //Toast.makeText(getBaseContext(), newname,Toast.LENGTH_SHORT).show();
				 //upper=newname.toUpperCase();
				//in.putExtra("result", upper);
				setResult(RESULT_OK,in);
				finish();
				
			}
		});
		
	}
}
