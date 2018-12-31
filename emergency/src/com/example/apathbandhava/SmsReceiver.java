package com.example.apathbandhava;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver{
	 String smsBody,address,smsMessageStr,lat,lon;
	 String c,b;
	 int i=0;
	@SuppressLint({ "NewApi", "UseValueOf" }) @Override
	public void onReceive(Context context, Intent intent) {
		
		// TODO Auto-generated method stub
		  Toast.makeText(context,"inside recieve", Toast.LENGTH_SHORT).show();
  
          Bundle intentExtras = intent.getExtras();
          
          if (intentExtras != null) {
              Object[] sms = (Object[]) intentExtras.get("pdus");
              for (int i = 0; i < sms.length; i++) {
              	
              //Create an SmsMessage from a raw PDU with the specified message format.    	
                  SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);
                  
                  smsBody = smsMessage.getDisplayMessageBody();
                  address = smsMessage.getOriginatingAddress();
                  smsMessageStr += "SMS From:" + address + "\n";
                  smsMessageStr+= smsBody + "\n";
                  
              Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();}
              
              }
          if(smsMessageStr.contains("help"))
          {
          String[] latlong=smsBody.split("#");
         Toast.makeText(context,latlong[0]+":"+latlong[1], Toast.LENGTH_SHORT).show();
          }
        
    
         
       	}

}
