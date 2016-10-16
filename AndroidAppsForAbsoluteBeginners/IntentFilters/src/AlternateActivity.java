package seventh.example.intentfilters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
public class AlternateActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate);
        Button activity2 = (Button) findViewById(R.id.button1);
        activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
        Button startTimer = (Button) findViewById(R.id.button2);
        startTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                timerAlert(arg0);
            }
        });        
    }
    public void timerAlert(View view) {
        EditText textField = (EditText) findViewById(R.id.editText1);
        int i = Integer.parseInt(textField.getText().toString());
        Intent timerIntent = new Intent(this, TimerBroadcastReceiver.class);
        PendingIntent myPendingIntent =
          PendingIntent.getBroadcast(this.getApplicationContext(), 0, timerIntent, 0);
        AlarmManager myAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        myAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 
          (i * 1000), myPendingIntent);
        Toast.makeText(this, "Alarm is set for " + i + " seconds!", 
                       Toast.LENGTH_LONG).show();
    }    
}
