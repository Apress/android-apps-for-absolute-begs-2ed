package seventh.example.intentfilters;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button activity1 = (Button) findViewById(R.id.button1);
        activity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = 
                new Intent(arg0.getContext(), AlternateActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });        
        Button startButton = (Button) findViewById(R.id.button2);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                startService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });
        Button stopButton = (Button) findViewById(R.id.button3);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                stopService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
