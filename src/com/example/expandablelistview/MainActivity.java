package com.example.expandablelistview;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

public class MainActivity extends Activity {

	private ExpandableListView elv;

	/**
	 * THIS DATA CAN BE FETCHED FROM DATABASES OR FROM WEB USING WEB API'S AND
	 * LOAD TO ADAPTER
	 * 
	 * **/

	private static final String[] groupname = { "Bangalore", "Mysore", "Kodagu" };

	private static final String[][] data = {
			{ "Vidhanasouda", "Cubbon park", "Lalbagh" },
			{ "Palace", "Chamundi Hills", "Zoo" },
			{ "Abbey Falls", "Talakaveri" } };

	private static final String[][] listinfo = {
			{ "Dr Ambedkar rd,, Sampangi Ramnagar, Bangalore, Karnataka",
					"Kasturba Road, Bangalore, Karnataka",
					"Lal Bagh Road, Lalbagh, Mavalli, Bangalore, Karnataka" },
			{ "Sayyaji Rao Rd, Mysore, Karnataka", "Mysore",
					"Ittige gudu, Mysore, Karnataka" },
			{ "Kodagu,Karnataka", "Kodagu,Karnataka" } };
	
	private static final int[] ImgBckgrnd = {R.drawable.bangalore,R.drawable.mysore,R.drawable.coorg};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		elv  = (ExpandableListView) findViewById(R.id.expandableListView);
		elv.setFocusable(false);
		
		elv.setAdapter(new CustomELVAdapter(this, MainActivity.this, groupname, ImgBckgrnd, listinfo,data));
			
		elv.setOnGroupClickListener(new OnGroupClickListener() {

	   		@Override
	   		public boolean onGroupClick(ExpandableListView parent, View v,
	   				int groupPosition, long id) {
	   		   /** 
	   		    * TODO:return true to enable group click
	   		    */
	   			
	   			// DO SOMETHING
	   			
	   			return false;
	   		}
	   	});
		
		int groupCount = elv.getCount();
		   for (int i=0; i<groupCount; i++) {
			   elv.expandGroup(i);
		       };
		
	}

}
