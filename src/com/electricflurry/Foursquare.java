/*
 * This class is used to house 
 * le foursquare API stuff*/
package com.electricflurry;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Foursquare {
	
	String fqUrl = 
		"https://api.foursquare.com/v2/venues/search?ll=40.7,-74&oauth_token=XHPKH51XG5J41S01AR1YBMOQROEZVHRTVO2Q5ULLDI4FGHZZ&v=20130330";
	String oAuthToken;//ultimately when a user log in for the 1st time I will store oAuth token
	
	String firstThing;
	
	public Foursquare() {
		try {
			URL url = new URL(fqUrl);
			InputStream conn = url.openStream();
			DataInputStream stream = new DataInputStream(new BufferedInputStream(conn));
			
			firstThing = stream.readLine();
			try {
				JSONObject jsonObj = new JSONObject(firstThing);
				jsonObj = jsonObj.getJSONObject("response");
				JSONArray venues = jsonObj.getJSONArray("venues");
				JSONObject oneVenue = venues.getJSONObject(0);
				
				firstThing = oneVenue.getString("name");
			}
			catch(JSONException e) {
				Log.d("Foursquare", "JSON issue", e);
			}
			
			conn.close();
		}
		catch(MalformedURLException e) { Log.d("Foursquare", "The URL failed"); }
		catch(IOException e) { 
			Log.d("Foursquare", "InputStream failed for some reason"); 
			Log.d("Foursquare", "InputStream Stacktrace", e);
			}
		
	}//end of constructor
	
	
	public String returnLeString() {
		return firstThing;
	}//end of returnLeString
	
	
	
	

}//end of Foursquare class
