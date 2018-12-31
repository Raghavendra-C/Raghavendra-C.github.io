package com.example.apathbandhava;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class SqlDatabaseHandler extends SQLiteOpenHelper
{
	String TABLE_NAME="contact";

	public SqlDatabaseHandler(Context context) {
		super(context, "ContactBook", null, 1);
		//SQLiteDatabase db=this.getWritableDatabase();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub
	  String q="create table contact(name text,phno text primary key)";
	  
		db.execSQL(q);
		
	}
     

	 /*  public String[] display()
	   {
		   String[]names={};
		   SQLiteDatabase db=this.getReadableDatabase();
		   //List<contact> list1=new ArrayList<contact>();
		   contact cc;//new contact();
		   cc=new contact();
		   int i=0;
		   //String q="select * from contact";
			   Cursor cur=db.rawQuery("select name from contact", null);
		  if(cur.moveToFirst())
		  {
			  do
			  {
			      	 
				  
				  names[i]=(cur.getString(0));
				    i++;
				  
			  }while(cur.moveToNext());
		  }   
		 return names;
		 
	   }*/

	
	   public List<contact> display()
	   {
		   SQLiteDatabase db=this.getReadableDatabase();
		   List<contact> list1=new ArrayList<contact>();
		   contact cc;//new contact();
		   //cc=new contact();
		   // int i=0;
		   //String q="select * from contact";
			   Cursor cur=db.rawQuery("select * from contact", null);
		  if(cur.moveToFirst())
		  {
			  do
			  {
			      	 
				  cc=new contact();
				  cc.setname(cur.getString(0));
				  cc.setnumber(cur.getString(1));
				  list1.add(cc);
				   
				  
			  }while(cur.moveToNext());
		  }   
		  return list1;
	   }

	 
	
	   
	public boolean insert(String name,String phone)
	{   long i=-1;
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("name",name);
		cv.put("phno",phone);
		i=db.insert("contact", null, cv);
		if(i==-1)
			return false;
		else
			return true;
		
	}
	
	
	
	public void update(String name,String phno)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues c1=new ContentValues();
		c1.put("name",name);
		c1.put("phno",phno);
		String num1=phno;
		db.update("contact", c1,"phno="+"'"+phno+"'", null);
		//return l;
	}
	public Integer delete(String phno)
	{
		SQLiteDatabase db=this.getWritableDatabase();
	
		int a=db.delete("contact", "phno="+phno,null);
	//	db.close();
		return a;
	} 
	
	public void deleteall()
	{
		  SQLiteDatabase db = this.getWritableDatabase();
		    db.delete(TABLE_NAME,null,null);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
   
}

