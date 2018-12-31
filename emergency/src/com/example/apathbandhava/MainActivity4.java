package com.example.apathbandhava;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends Activity {
Button add,view,back,Delete,Clear;
TextView title,name,phone;
String upper,newname,named; 
SqlDatabaseHandler db;
contact cc=new contact();
ListView l1;
//StringBuffer buffer=new StringBuffer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity4);
		
		db=new SqlDatabaseHandler(MainActivity4.this);
		add=(Button)findViewById(R.id.BACK);
		view=(Button)findViewById(R.id.button2);
		back=(Button)findViewById(R.id.button3);
		title=(TextView)findViewById(R.id.textView1);
		name=(TextView)findViewById(R.id.textView2);
		 Delete=(Button)findViewById(R.id.button4); 
		l1=(ListView)findViewById(R.id.listView1);
		Intent in=getIntent();
		//Intent in=getIntent();
		 newname=in.getStringExtra("name");
		 upper=newname.toUpperCase();
	 Toast.makeText(getBaseContext(),""+newname+"",Toast.LENGTH_SHORT).show();
	//viewall();
	  //view();
//	 click2();
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
					  named="activitytwo";
					  Intent intent=new Intent(MainActivity4.this,MainActivity2.class);
				        intent.putExtra("name",named);
				        startActivityForResult(intent,1);
				        
				        
					
				} 
	      
	        });
		  view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				 List<contact> a1=new ArrayList<contact>();
				 
				 List<String>names=new ArrayList<String>();
			//	 List<String>phone=new ArrayList<String>();
				 a1=db.display();
				 
				Toast.makeText(getBaseContext(),String.valueOf(a1.size()),Toast.LENGTH_SHORT).show();
				for(contact cc:a1)
				{
					Toast.makeText(getBaseContext(),cc.getname()+":"+cc.getnumber(),Toast.LENGTH_LONG).show();
				 	names.add(cc.getname()+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+cc.getnumber());
				 	
				}
				String[]n=(String[])names.toArray(new String[0]);
			 //String[]p=(String[])phone.toArray();
				ArrayAdapter<String>adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,n);
				l1.setAdapter(adapter);
				
				
			}
		});
		
	  
	}
	
		

	}
		   
		
	
	
     


