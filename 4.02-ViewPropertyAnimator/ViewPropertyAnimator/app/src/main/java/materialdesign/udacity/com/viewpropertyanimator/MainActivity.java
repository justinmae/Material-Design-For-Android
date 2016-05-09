package materialdesign.udacity.com.viewpropertyanimator;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void animate(View view) {
        TextView tv = (TextView) findViewById(R.id.text_view);
//        tv.setText("HELLO");
        tv.animate()
//                .scaleX(2f).scaleY(2f)
                .rotation(360f)
//                .x(500).y(500);
                .translationX(500f).translationY(1000f)
//                .alpha(1f);
//                .translationY(-tv.getHeight())
                .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))    //200ms
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        TextView tv = (TextView) findViewById(R.id.text_view);
                        tv.animate().rotation(-360f)
                                .translationX(0f).translationY(0f)
                                .setDuration(2000);
                    }
                });
    }

    public void changeTextColorAnim(View view) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        ObjectAnimator.ofObject(
                tv,
                "textColor",
                new ArgbEvaluator(),
                Color.BLACK,
                Color.RED)

                .setDuration(1000)
                .start();
    }


}
