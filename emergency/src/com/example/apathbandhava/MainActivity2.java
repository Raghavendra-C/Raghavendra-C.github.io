package com.example.apathbandhava;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi") public class MainActivity2 extends Activity {
	List l1;
	TextView tv1,tv2,tv3;
	EditText name,phone;
	Button add,back,Delete,Clear,Update;
    String newname,upper;
    String n,ph,got;
    SqlDatabaseHandler db;
    SQLiteDatabase d;
    int a;
    contact c=new contact();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
	   db=new SqlDatabaseHandler(MainActivity2.this);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv3=(TextView)findViewById(R.id.textView3);
		name=(EditText)findViewById(R.id.editText1);
		phone=(EditText)findViewById(R.id.editText2);
		add=(Button)findViewById(R.id.BACK);
		back=(Button)findViewById(R.id.button2);
		Delete=(Button)findViewById(R.id.button3);
		Clear=(Button)findViewById(R.id.button4);
		Update=(Button)findViewById(R.id.button5);
		Intent in=getIntent();
		 newname=in.getStringExtra("name");
		 upper=newname.toUpperCase();
	 Toast.makeText(getBaseContext(),""+newname+"",Toast.LENGTH_SHORT).show();
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=getIntent();
				 newname=in.getStringExtra("name");
				 upper=newname.toUpperCase();
				in.putExtra("result", upper);
				setResult(RESULT_OK,in);
				finish();
				
			}
	});
		add.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				n=name.getText().toString();
			
				ph=phone.getText().toString();
				Toast.makeText(getBaseContext(),n +" "+ph,Toast.LENGTH_SHORT).show();
				
				contact c;
				if(n.isEmpty() || ph.isEmpty())
				{
				 Toast.makeText(getBaseContext(), "Enter the valid data",Toast.LENGTH_LONG).show();	
				}
				else {
			    boolean i=db.insert(n,ph);
			    if(i==true)
			   {Toast.makeText(getBaseContext(),"Data sent to db",Toast.LENGTH_SHORT).show();}
			    else
			    	{Toast.makeText(getBaseContext(),"Data not sent to db",Toast.LENGTH_SHORT).show();}
			} 
				 	
				}
			
		
		});
		 
	    Delete.setOnClickListener(new OnClickListener (){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				got=phone.getText().toString();
				if(got.isEmpty())
				{
				 Toast.makeText(getBaseContext(), "Enter the valid key to delete tuple",Toast.LENGTH_LONG).show();	
				}
				else
			   {Toast.makeText(getBaseContext(),"deleting",Toast.LENGTH_SHORT).show();
				a=db.delete(got);
				if(a>0)
				{	Toast.makeText(getBaseContext(),"Data deleted",Toast.LENGTH_LONG).show();}
				else 
				{Toast.makeText(getBaseContext(),"Data not deleted",Toast.LENGTH_LONG).show();}
			}
			}
	});
	    
	    Clear.setOnClickListener(new OnClickListener (){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(),"clear",Toast.LENGTH_LONG).show();
				db.deleteall();
				Toast.makeText(getBaseContext(),"Table deleted ",Toast.LENGTH_LONG).show();
			  
			}
	}); 
	    
	    Update.setOnClickListener(new OnClickListener (){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				n=name.getText().toString();
				
				ph=phone.getText().toString();
				Toast.makeText(getBaseContext(),n +" "+ph,Toast.LENGTH_SHORT).show();
				
				contact c;
				if(n.isEmpty() || ph.isEmpty())
				{
				 Toast.makeText(getBaseContext(), "Enter the valid data fro updation",Toast.LENGTH_LONG).show();	
				}
				else {
				Toast.makeText(getBaseContext(),"Update",Toast.LENGTH_LONG).show();
				db.update(n, ph);
				Toast.makeText(getBaseContext(),"Table updated ",Toast.LENGTH_LONG).show();
			  
			}
			}
	}); 
		
}
		
	}

