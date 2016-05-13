package materialdesign.udacity.com.interpolation;

import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView textView;
    Spinner spinner;
    Interpolator interpolator;
    DisplayMetrics metrics;
    private static final String PACKAGE = "android.view.animation.";
    private static final String PACKAGE_V4 = "android.support.v4.view.animation.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
    }

    public void fastOutSlowInInterpolator(View view) {

        Interpolator interpolator = new FastOutSlowInInterpolator();
        textView.setTranslationY(10000);

        textView.animate()
                .setInterpolator(interpolator)
                .setStartDelay(500)
                .setDuration(900)
                .translationYBy(-10000)
                .start();
    }


    public void fastOutLinearInInterpolator(View view) {

        Interpolator interpolator = new FastOutLinearInInterpolator();
        textView.setTranslationY(10000);

        textView.animate()
                .setInterpolator(interpolator)
                .setStartDelay(500)
                .setDuration(900)
                .translationYBy(-10000)
                .start();
    }

    public void linearOutSlowInInterpolator(View view) {

        Interpolator interpolator = new LinearOutSlowInInterpolator();
        textView.setTranslationY(10000);

        textView.animate()
                .setInterpolator(interpolator)
                .setStartDelay(500)
                .setDuration(900)
                .translationYBy(-10000)
                .start();
    }

    public void otherInterpolators(View view) {

        Interpolator interpolator = new AccelerateDecelerateInterpolator();
        textView.setTranslationY(10000);

        textView.animate()
                .setInterpolator(interpolator)
                .setStartDelay(500)
                .setDuration(900)
                .translationYBy(-10000)
                .start();
    }


    String findFullInterpolatorPath(String className) {
        if (className.equals("FastOutLinearInInterpolator") || className.equals("FastOutSlowInInterpolator") || className.equals("LinearOutSlowInInterpolator"))
            return PACKAGE_V4 + className;
        else if (className.startsWith("-"))
            return null;
        else return PACKAGE + className;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String interpolatorName = (String) spinner.getAdapter().getItem(position);


        textView.setTranslationY(metrics.heightPixels);

//        textView.setTranslationY(10000);

        try {
            String path = findFullInterpolatorPath(interpolatorName);
            if (path ==null) return;


            interpolator = (Interpolator) Class.forName(path).newInstance();

            textView.animate()
                    .setInterpolator(interpolator)
                    .setDuration(900)
                    .setStartDelay(500)
                    .translationYBy(-metrics.heightPixels)
                    .start();
//
//            textView.animate()
//                    .setInterpolator(interpolator)
//                    .setDuration(900)
//                    .setStartDelay(1500)
//                    .translationYBy(metrics.heightPixels)
//                    .start();

//            textView.setTranslationY(-metrics.heightPixels);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
