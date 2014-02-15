package com.massgroup.myfirstapp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) 
        	{ 
        		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); 
        		StrictMode.setThreadPolicy(policy); 
        	}
        
        // Creating HTTP client
        HttpClient httpClient = new DefaultHttpClient();
        // Creating HTTP Post
        HttpPost httpPost = new HttpPost("http://www.google.com/");
        
        
        // Making HTTP Request
        try {
            HttpResponse response = httpClient.execute(httpPost);
 
            // writing response to log
            Log.d("Http Response:", response.toString());
        } catch (ClientProtocolException e) {
            // writing exception to log
            e.printStackTrace();
        } catch (IOException e) {
            // writing exception to log
            e.printStackTrace();
        }        

        
        // Get the message from the intent
        Intent intent = getIntent();
        
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Set the text view as the activity layout
        setContentView(textView);
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_logout:
                openLogout();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
		    case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
		    default:
	            return super.onOptionsItemSelected(item);
            
        }
        //return super.onOptionsItemSelected(item);
    }


	private void openSettings() {
		// TODO Auto-generated method stub
		
	}


	private void openLogout() {
		finish();
		//clearstack
		// TODO Auto-generated method stub
		
	}
}