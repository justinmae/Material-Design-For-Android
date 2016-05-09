package materialdesign.udacity.com.sceneandtransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {

        TransitionManager.go(Scene.getSceneForLayout(
                (ViewGroup) view.getRootView(),
                R.layout.activity_main2,
                this),
                TransitionInflater.from(this).inflateTransition(R.transition.default_to_info));
    }
}
