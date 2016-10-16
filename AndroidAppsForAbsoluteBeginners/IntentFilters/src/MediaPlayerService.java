package seventh.example.intentfilters;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaPlayerService extends Service {
    MediaPlayer myMediaPlayer;    
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
    @Override
    public void onCreate() {
        myMediaPlayer = MediaPlayer.create(this, R.raw.mindtaffy);
        myMediaPlayer.setLooping(true);
    }
    @Override    
    public void onStart(Intent intent, int startId) {
    	myMediaPlayer.start();
    }
    @Override
    public void onDestroy() {
        myMediaPlayer.stop();    
    }
}
