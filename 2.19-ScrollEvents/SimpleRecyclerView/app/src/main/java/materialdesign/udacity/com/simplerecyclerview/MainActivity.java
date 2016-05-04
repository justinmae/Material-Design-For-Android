package materialdesign.udacity.com.simplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(getLayoutInflater().inflate(R.layout.list_item, parent, false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.text1.setText("SimpleRecyclerView");
                holder.text2.setText("this is the body");
            }

            @Override
            public int getItemCount() {
                return 15;
            }
        });

    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
        }
    }

}
