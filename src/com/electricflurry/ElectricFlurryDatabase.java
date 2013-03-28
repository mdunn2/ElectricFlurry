package com.electricflurry;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ElectricFlurryDatabase {

	/*
	 * This main class uses our database rather than access it directly
	 * */
	
	private String DB_NAME = "electricflurry.db";
	private int DB_VERSION = 1;
	
	private ElectricFlurryOpenHelper openHelper; //Opens the databse for us
	private SQLiteDatabase database;//access to the database ports for Android
	
	public ElectricFlurryDatabase(Context context) {
		openHelper = new ElectricFlurryOpenHelper(context);
		database = openHelper.getWritableDatabase();
	}//end of constructor
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Inner class thqt actually creates the database
	 * */
	private class ElectricFlurryOpenHelper extends SQLiteOpenHelper {
		
		public ElectricFlurryOpenHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase dBase) {
			/*
			 * This first creates the databse
			 * and is only run once until a new
			 * version number is sent to it
			 * */
			String userCreate = "CREATE TABLE user (id INTEGER PRIMARY KEY, username text) ";
			dBase.execSQL(userCreate);
			
			
		}//end of constructor

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
			/*This is used when we want to upgrade
			 * users database if any changes are made
			 * but for development purposes we should just
			 * delete app data to tell android to invoke create again*/
			
		}//end of onUpgrade
		
	}//end of inner class
	
	
	
	
}//end of class
