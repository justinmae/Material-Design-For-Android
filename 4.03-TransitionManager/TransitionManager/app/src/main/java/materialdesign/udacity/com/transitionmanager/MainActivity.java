package materialdesign.udacity.com.transitionmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.END);

        ViewGroup root =(ViewGroup) view.getRootView();

        TransitionManager.beginDelayedTransition(root, slide);
//        TransitionManager.beginDelayedTransition(root, new AutoTransition());
        ImageView imageView = (ImageView) findViewById(R.id.imageview);
//        imageView.setVisibility(View.INVISIBLE);

    }

}
