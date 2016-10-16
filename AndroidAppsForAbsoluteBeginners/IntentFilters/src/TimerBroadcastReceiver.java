package seventh.example.intentfilters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TimerBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Alarm Notification", Toast.LENGTH_LONG).show();
	}
}
