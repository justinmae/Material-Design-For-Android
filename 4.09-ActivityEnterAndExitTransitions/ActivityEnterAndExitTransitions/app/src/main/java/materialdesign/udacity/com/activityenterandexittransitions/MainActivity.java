package materialdesign.udacity.com.activityenterandexittransitions;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        gridView.setAdapter(new GridAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) view.findViewById(R.id.textview)).setText("CLICKED");
                TextView sharedView = ((TextView) view.findViewById(R.id.textview));

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        sharedView, sharedView.getTransitionName()).toBundle();

                startActivity(new Intent(context, DetailActivity.class), bundle);
            }
        });


//        getWindow().setReenterTransition(new Slide(Gravity.TOP));
    }


    private class GridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.grid_item, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.textview);
            textView.setText(Integer.toString(position));
            return convertView;
        }
    }
}
