package fourth.example.graphicdesign;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends Activity {	
	AnimationDrawable logoAnimation;	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView logoAnimHolder = (ImageView) findViewById(R.id.imageView1);   
        logoAnimHolder.setBackgroundResource(R.drawable.logo_animation);          
        logoAnimHolder.post(new Runnable() {
        public void run() {
        	logoAnimation = (AnimationDrawable) logoAnimHolder.getBackground();
        	}
        });
        TextView textAnim = (TextView) findViewById(R.id.animText);
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animation);
        textAnim.startAnimation(textAnimation);
        TransitionDrawable trans = (TransitionDrawable) getResources().getDrawable(R.drawable.image_transition);
        ImageView transImage = (ImageView) findViewById(R.id.imageTrans);
        transImage.setImageDrawable(trans);
        trans.startTransition(10000);        
    }
    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
    	logoAnimation.start();
    }    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}