package me.servicelink.client;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	
	String menuItems[] = {"New Service Request", "View Previous", "Account Information"};
	String classes[] = {"NewRequest", "Results", "account_info"};

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String classValue = "me.servicelink.client." + classes[position];
		try {
			startActivity(new Intent(Menu.this, Class.forName(classValue)));
			/* Alternate: Class ourClass = Class.forName(classValue); Intent ourIntent = new Intent(Menu.this, ourClass); startActivity(ourIntent); */
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Display menu items as a list
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, menuItems));
		//setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, menuItems));
	}
}