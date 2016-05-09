package materialdesign.udacity.com.viewpropertyanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.text);

        tv.animate()
                .alpha(0f)
                .translationY(-tv.getHeight())
                .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
    }
}
