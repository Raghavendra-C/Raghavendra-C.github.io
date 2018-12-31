package com.example.apathbandhava;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.BroadcastReceiver; 
public class MainActivity extends Activity{
 Button settings,send,Call,exit,abt;
 String name,named,lat,lon;
 SqlDatabaseHandler db;
 SQLiteDatabase d;
 double latitude,longitude;
 String a,b;
 String getLatitude;
 String getLongitude; 
 double x;
 double y;
 String s;
 contact cc=new contact();
 SmsManager sms=SmsManager.getDefault();
 List<contact> a1=new ArrayList<contact>();
 Geocoder geocoder;
 List<Address> addresses;
 TextView view;
 String smsBody,address;
 SmsReceiver obj=new SmsReceiver();
 Cursor cursor;

   // GPSTracker class
   GPSTracker gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings=(Button)findViewById(R.id.button1);
        send=(Button)findViewById(R.id.button2);
        Call=(Button)findViewById(R.id.button3);
        exit=(Button)findViewById(R.id.button4);
        abt=(Button)findViewById(R.id.button5);
       /* settings.setBackgroundColor(Color.RED);
        send.setBackgroundColor(Color.YELLOW);
        Call.setBackgroundColor(Color.);
        exit.setBackgroundColor(Color.WHITE);
        abt.setBackgroundColor(Color.BLUE);*/
        view=(TextView)findViewById(R.id.textView1);
        db=new SqlDatabaseHandler(MainActivity.this);
         final Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        //db.onCreate(d);
        //db.onUpgrade(d);
       
       
        settings.setOnClickListener(new OnClickListener(){
     
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  named="activity4";
				  Intent intent=new Intent(MainActivity.this,MainActivity4.class);
			        intent.putExtra("name",named);
			        startActivityForResult(intent,1);
				
			} 
      
        });
        exit.setOnClickListener(new OnClickListener(){
            
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
				
				
			} 
      
        });
abt.setOnClickListener(new OnClickListener(){
            
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				named="about us";
				 Intent intent=new Intent(MainActivity.this,Aboutus.class);
			        intent.putExtra("name",named);
			        startActivityForResult(intent,1);
				
			} 
      
        });
       
             
       send.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			  gps = new GPSTracker(MainActivity.this);
			  
              // check if GPS enabled     
              if(gps.canGetLocation()){
                  // \n is for new line
                  double latitude = gps.getLatitude();
                  double longitude = gps.getLongitude();
                   x=latitude;
                   y=longitude;

                  Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();    
                 getAddress();
                 send();
              }else{
                  // can't get location
                  // GPS or Network is not enabled
                  // Ask user to enable GPS/network in settings
                  gps.showSettingsAlert();
              }    	
		}
       });
      
      Call.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent i=new Intent(Intent.ACTION_CALL);
		i.setData(Uri.parse("tel:8660191104"));
		startActivity(i);
		}
	});
    }
    
    public void getAddress()
    {
      			geocoder = new Geocoder(MainActivity.this, Locale.ENGLISH);
      			StringBuilder str = new StringBuilder();
			try {
				addresses = geocoder.getFromLocation(x, y, 1);
				
				
			/*	Toast.makeText(getApplicationContext(),
				"geocoder present", Toast.LENGTH_SHORT).show();*/
				Address returnAddress = addresses.get(0);
				 
				String localityString = returnAddress.getLocality();
				String city = returnAddress.getCountryName();
				String region_code = returnAddress.getCountryCode();
				String zipcode = returnAddress.getPostalCode();
String actualpoint=returnAddress.getSubLocality();
String area=returnAddress.getAdminArea();
String feature=returnAddress.getFeatureName();
String throughfare=returnAddress.getThoroughfare();
String url=returnAddress.getUrl();
Locale local=returnAddress.getLocale();
Bundle extra=returnAddress.getExtras();
String premises=returnAddress.getPremises();
String subthroughfare=returnAddress.getSubThoroughfare(); 
lat=Double.toString(x);
lon=Double.toString(y);
str.append(x+"#"+y+"#"+" "+localityString+" "+city + " " + region_code + " "+zipcode+" "+actualpoint+" "+area+" "+feature+" "+throughfare+" "+subthroughfare+" "+url+" "+"Apathbandhava");
				Toast.makeText(getApplicationContext(), str,
				Toast.LENGTH_SHORT).show();
			   s=str.toString();	
            
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  }
          public void send()
          {
        	  //SmsManager sms=SmsManager.getDefault();
        		 //String b=str.toString();
 				List<contact> a1=new ArrayList<contact>();
 				 a1=db.display();
 			
                 // \n is for new line
              String lat,lon;
              lat=Double.toString(x);
              lon=Double.toString(y);
 				for(contact cc:a1)
 				{
 				 	String n=cc.getnumber();
 				 	Toast.makeText(getBaseContext(),n,Toast.LENGTH_LONG).show();
 				 //	sms.sendTextMessage(n,null,lat,null,null);
 				 	//sms.sendTextMessage(n,null,lon,null,null);
 				 	sms.sendTextMessage(n,null,s,null,null);
 				 	Toast.makeText(getBaseContext(),"sent to:"+cc.getname(),Toast.LENGTH_LONG).show();
 				}
 				
          }
        
          	
          
          
}