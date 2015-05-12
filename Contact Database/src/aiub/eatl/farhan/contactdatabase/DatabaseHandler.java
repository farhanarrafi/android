package aiub.eatl.farhan.contactdatabase;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "contactmanager";
	private static final String TABLE_CONTACTS = "contacts";
	
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "phone_number";
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
//	public DatabaseHandler(Context context, String name, CursorFactory factory,
//			int version) {
//		super(context, name, factory, version);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + 
										"(" + 
										KEY_ID + " INTEGER PRIMARY KEY, " +
										KEY_NAME + " TEXT, " + 
										KEY_PH_NO + " TEXT " + 
										" )";
		db.execSQL(CREATE_CONTACTS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
		onCreate(db);
	}
	
	void addContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhone_number());
		
		db.insert(TABLE_CONTACTS, null, values);
		db.close();
	}
	
	Contact getContact(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		String sqlString[] = {KEY_ID, KEY_NAME, KEY_PH_NO};
		
		String valueOfID[] = {String.valueOf(id)};
		
		Cursor cursor = db.query(TABLE_CONTACTS, sqlString, KEY_ID + "=?",
				valueOfID, null, null, null, null);
		if(cursor != null)
			cursor.moveToFirst();
		
		int key_id = Integer.parseInt(cursor.getString(0));
		String key_name = cursor.getString(1);
		String key_ph_no = cursor.getString(2);
		
		Contact contact = new Contact(key_id,key_name,key_ph_no);
		return contact;
	}
	
	public List<Contact> getAllContacts() {
		
		List<Contact> contactList = new ArrayList<Contact>();
		String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()) {
			do {
				Contact contact = new Contact();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPhone_number(cursor.getString(2));
				contactList.add(contact);
			} while (cursor.moveToNext());
		}
		return contactList;
	}
	
	public int updateContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPhone_number());
		
		String valueOfID[] = {String.valueOf(contact.getID())};
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", valueOfID);
	}
	
	public void deleteContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		String valueOfID[] = {String.valueOf(contact.getID())};
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?" , valueOfID);
	}
	
	public int getContactsCount() {
		
		String countQuery = "SELECT * FROM " + TABLE_CONTACTS ;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		db.close();
		return cursor.getCount();
	}

}
