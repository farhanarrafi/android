package aiub.eatl.farhan.contactdatabase;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactDatabaseActivity extends Activity {
	
	private ArrayList<String> contactList;
	private ArrayAdapter<String> adapter;
	private ListView list;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = (ListView) findViewById(0);
        setContentView(R.layout.main);
        
        SharedPreferences settings = getSharedPreferences("DATA", MODE_PRIVATE);
        contactList = new ArrayList<String>();
        String dataStatus = settings.getString("loaded", "no");
        DatabaseHandler db = new DatabaseHandler(this);
        if(dataStatus.equals("no")) {
        	
        	Log.d("Insert: ", "inserting ..");
        	db.addContact(new Contact("Rahim", "017200000000"));
        	db.addContact(new Contact("Rahim", "018200000000"));
        	db.addContact(new Contact("Rahim", "019200000000"));
        	db.addContact(new Contact("Rahim", "016200000000"));
        	db.addContact(new Contact("Rahim", "015200000000"));
        	
        	SharedPreferences.Editor editor = settings.edit();
        	editor.putString("loaded", "yes");
        	editor.commit();
        }
        
        Log.d("Settings: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();
        
        for(Contact cn : contacts) {
        	String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + 
        				" ,Phone: " + cn.getPhone_number();
        	
        	Log.d("Name; ", log);
        	contactList.add(cn.getName());
        }
        
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.main., );
        
        list.setAdapter(adapter);
    }
}