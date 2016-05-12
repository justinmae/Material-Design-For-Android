package materialdesign.udacity.com.instructivedesign;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScrollView = (ScrollView) findViewById(R.id.scroll_view);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        final int startScrollPos = getResources().getDimensionPixelSize(
                R.dimen.init_scroll_up_distance);

        // animator allows more customization
        Animator animator = ObjectAnimator.ofInt(
                mScrollView,
                "scrollY",
                startScrollPos)
                .setDuration(300);
        animator.start();

//        mScrollView.smoothScrollTo(0,500);
//        mScrollView.smoothScrollTo(0,1000);

    }
}
