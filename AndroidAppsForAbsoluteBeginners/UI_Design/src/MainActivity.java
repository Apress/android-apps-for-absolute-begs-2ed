package third.example.userinterfacedesign;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.app.AlertDialog; 
import android.content.DialogInterface;
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout bkgr = (RelativeLayout)findViewById(R.id.uilayout);
        final ImageView image = (ImageView)findViewById(R.id.imageView1);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick an Image!")
              .setMessage("Please Select Image One or Image Two:")
              .setCancelable(false)
              .setPositiveButton("IMAGE 1", new DialogInterface.OnClickListener()
              {
                    public void onClick(DialogInterface dialog, int id) {
                          image.setImageResource(R.drawable.image1);
                    }
              })
              .setNegativeButton("IMAGE 2", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                          image.setImageResource(R.drawable.image2);
                    }
               });
            switch (item.getItemId()) {
            case R.id.buttonone:
                            image.setImageResource(R.drawable.image1);
                            return true;
            case R.id.buttontwo:
                            image.setImageResource(R.drawable.image2);
                            return true;
            case R.id.buttonthree:
                            bkgr.setBackgroundResource(R.color.background);
                            return true;
            case R.id.buttonfour:
                            bkgr.setBackgroundResource(R.color.background2);
                            return true;
            case R.id.buttonfive:
                            builder.show();
                            return true;
            default:		return super.onOptionsItemSelected(item);
            }
        }    
}