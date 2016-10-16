package fifth.example.eventhandling;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);        
        button.setOnLongClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);        
        Button button3 = (Button) findViewById(R.id.button3);
        registerForContextMenu(button3);       
        Button button4 = (Button) findViewById(R.id.button4);
        registerForContextMenu(button4);          
    }
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, view, menuInfo);
    	menu.setHeaderTitle("Android Context Menu");
    	menu.add(0, view.getId(), 0, "Invoke Context Function 1");
    	menu.add(0, view.getId(), 0, "Invoke Context Function 2");
    }
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle().equals("Invoke Context Function 1")) {
                contextFunction1(item.getItemId());
        }
        else if(item.getTitle().equals("Invoke Context Function 2")){
                contextFunction2(item.getItemId());
        }
        else {
                return false;
        }
        return true;
    }
    public void contextFunction1(int id){
        Toast.makeText(this, "function 1 invoked!", Toast.LENGTH_SHORT).show();
    }
    public void contextFunction2(int id){
        Toast.makeText(this, "function 2 invoked!", Toast.LENGTH_SHORT).show();
    }    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public void onClick(View arg0) {  
    	TextView text = (TextView) findViewById(R.id.textmessage);	    	
		text.setText("BUTTON HAS BEEN CLICKED. EVENT PROCESSED.");
	}
	public boolean onLongClick(View arg0) {
    	TextView text = (TextView) findViewById(R.id.textmessage);	    	
		text.setText("BUTTON HAS BEEN HELD. onLongClick EVENT PROCESSED.");
		return true;
	}    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
        	textUpdate();
        	return true;
        }
        return false;
    }
    public void textUpdate() {
    	TextView text = (TextView)findViewById(R.id.textmessage);    	
    	text.setText("CENTER KEYPAD KEY PRESSED.");
    }    
}
