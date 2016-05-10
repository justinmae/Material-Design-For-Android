package materialdesign.udacity.com.activityenterandexittransitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;

/**
 * Created by justinmae on 5/10/16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //make detail activity slide in from the bottom
        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.text_detail_description);
        getWindow().setEnterTransition(slide);
//        getWindow().setReturnTransition(new Slide(Gravity.END));

    }
}
