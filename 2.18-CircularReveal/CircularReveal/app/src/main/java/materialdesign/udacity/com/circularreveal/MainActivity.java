package materialdesign.udacity.com.circularreveal;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void circularReveal(View view) {
//        Button view = (Button) findViewById(R.id.button);

        float finalRadius = (float) Math.hypot(view.getWidth()/2, view.getHeight()/2);

        Animator anim = ViewAnimationUtils.createCircularReveal(
                view, view.getWidth()/2, view.getHeight()/2, 0, finalRadius);
        anim.start();
    }


}
