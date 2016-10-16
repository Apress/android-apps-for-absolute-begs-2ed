package sixth.example.contentproviders;
import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button queryButton = (Button)findViewById(R.id.button1);
        queryButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {  queryContact();  }
        });
        Button addButton = (Button)findViewById(R.id.button2);
        addButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {  addContact("Steve Wozniak");  }
        });
        Button modifyButton = (Button)findViewById(R.id.button3);
        modifyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {  modContact("The Woz");  }
        });
        Button delButton = (Button)findViewById(R.id.button4);
        delButton.setOnClickListener(new OnClickListener() {
			@Override
			  public void onClick(View arg0) {  delContact("The Woz");  }
        });
    }
    private void queryContact() {
   	Cursor nameCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
   	 while (nameCursor.moveToNext()) { 
   	  String contactName = nameCursor.getString(nameCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
   	  Toast.makeText(this, contactName, Toast.LENGTH_SHORT).show();
   	 }
   	nameCursor.close();    	
    }    
    private void addContact(String newName) { 	    	
        ContentValues myContact = new ContentValues();
        myContact.put(RawContacts.ACCOUNT_NAME, newName);
        myContact.put(RawContacts.ACCOUNT_TYPE, newName);
        Uri addUri = getContentResolver().insert(RawContacts.CONTENT_URI, myContact);
        long rawContactId = ContentUris.parseId(addUri);
        myContact.clear();
        myContact.put(Data.RAW_CONTACT_ID, rawContactId);
        myContact.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        myContact.put(StructuredName.DISPLAY_NAME, newName);
        getContentResolver().insert(Data.CONTENT_URI, myContact);
        Toast.makeText(this, "New Contact: " + newName, Toast.LENGTH_SHORT).show();
        }    
    private void modContact(String modName) { 	    	
        ContentValues myContact = new ContentValues();
        myContact.put(RawContacts.ACCOUNT_NAME, modName);
        myContact.put(RawContacts.ACCOUNT_TYPE, modName);
        Uri addUri = getContentResolver().insert(RawContacts.CONTENT_URI, myContact);
        long rawContactId = ContentUris.parseId(addUri);
        myContact.clear();
        myContact.put(Data.RAW_CONTACT_ID, rawContactId);
        myContact.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        myContact.put(StructuredName.DISPLAY_NAME, modName);
        getContentResolver().update(Data.CONTENT_URI, myContact, null, null);
        Toast.makeText(this, "Modified Contact: " + modName, Toast.LENGTH_SHORT).show();
        }    
    private void delContact(String delName) {
    	ContentResolver cresolver = getContentResolver();
        Cursor cur = cresolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cur.moveToNext()) {
            try {
                String lookupKey = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
                Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
                Toast.makeText(this, "Deleted Contact URI: " + uri.toString(), Toast.LENGTH_SHORT).show();
                cresolver.delete(uri, null, null);
            }
            catch(Exception e)
            {
                System.out.println(e.getStackTrace());
            }
        }
    }    
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
