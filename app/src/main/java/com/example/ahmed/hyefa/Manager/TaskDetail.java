package com.example.ahmed.hyefa.Manager;

/**
 * Created by MOIZ on 11/9/2018.
 */
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.hyefa.R;

public class TaskDetail extends AppCompatActivity {

    ListView list;
    String titles[] = {"Emp Name", "Emp Name", "Emp Name", "Emp Name", "Emp Name"};
    String description[] = {"Emp Description", "Emp Description", "Emp Description", "Emp Description", "Emp Description"};
    String taskdetail[] = {"Do something","Do something","Do something","Do something","Do something"};
    int imgs[]={R.drawable.ic_home_black_24dp, R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskdetail);


        list = (ListView) findViewById(R.id.listview);

        MyAdapter adapter = new MyAdapter(this,titles,imgs,taskdetail,description);
        list.setAdapter(adapter);

        //click to go to another activity
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(TaskDetail.this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1) {
                    Toast.makeText(TaskDetail.this, "Item 2 clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 2) {
                    Toast.makeText(TaskDetail.this, "Item 3 clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 3) {
                    Toast.makeText(TaskDetail.this, "Item 4 clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 4) {
                    Toast.makeText(TaskDetail.this, "Item 5 clicked", Toast.LENGTH_SHORT).show();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();  return true;
        }

        return super.onOptionsItemSelected(item);
    }



    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String myTitles[];
        String mytaskdetail[];
        String myDescription[];
        int[] imgs;

        MyAdapter(Context c, String[] titles, int[] imgs, String[] description, String[] task) {
            super(c,R.layout.task_detail,R.id.text1,titles);
            this.context=c;
            this.imgs=imgs;
            this.mytaskdetail=task;
            this.myTitles=titles;
            this.myDescription=description;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater layoutInflater = (LayoutInflater)   getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.task_detail, parent, false);
            ImageView images = (ImageView) row.findViewById(R.id.logo);
            TextView myTitle = (TextView) row.findViewById(R.id.text1);
            TextView myDescription = (TextView) row.findViewById(R.id.text2);
            TextView mytaskdetail = (TextView) row.findViewById(R.id.text3);
            images.setImageResource(imgs[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(description[position]);
            mytaskdetail.setText(taskdetail[position]);
            return row;
        }
    }
}
