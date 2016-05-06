package materialdesign.udacity.com.addcustomfont;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Typeface Courgette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Courgette = Typeface.createFromAsset(getAssets(), "Courgette-Regular.ttf");

        TextView text1 = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        TextView text3 = (TextView) findViewById(R.id.text3);
        TextView text4 = (TextView) findViewById(R.id.text4);
        TextView text5 = (TextView) findViewById(R.id.text5);

        text1.setTextSize(50);
        text2.setTextSize(50);
        text3.setTextSize(50);
        text4.setTextSize(50);
        text5.setTextSize(50);

        text2.setTypeface(Courgette);
        text3.setTypeface(Courgette, Typeface.ITALIC);
        text4.setTypeface(Courgette, Typeface.BOLD);
        text5.setTypeface(Courgette, Typeface.BOLD_ITALIC);

    }

    
}
