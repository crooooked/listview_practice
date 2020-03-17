package com.example.listview_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private int []photos={R.drawable.photo_1,R.drawable.photo_2,R.drawable.photo_3,R.drawable.photo_4,R.drawable.photo_5,R.drawable.photo_6,R.drawable.photo_7,R.drawable.photo_8,R.drawable.photo_9,R.drawable.photo_10,R.drawable.photo_11,R.drawable.photo_12,R.drawable.photo_13,R.drawable.photo_14,R.drawable.photo_15,R.drawable.photo_16,R.drawable.photo_17,R.drawable.photo_18,R.drawable.photo_19,R.drawable.photo_20,R.drawable.photo_21,R.drawable.photo_22,R.drawable.photo_23,R.drawable.photo_24,R.drawable.photo_25,R.drawable.photo_26,R.drawable.photo_27,R.drawable.photo_28,R.drawable.photo_29,R.drawable.photo_30,R.drawable.photo_31,R.drawable.photo_32};
    private String[] arrayDemo={"20161707", "20161713", "20171591", "20171592", "20171616", "20171627", "20171641", "20171649", "20171650", "20171653", "20171654", "20171655", "20171656", "20171659", "20171664", "20171666", "20171667", "20171668", "20171669", "20171670", "20171679", "20171688", "20171697", "20171705", "20171707", "20171714", "20171717", "20171731", "20171742", "20175064", "20175980", "20175990"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.list_view);
        BaseAdapter baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayDemo.length;
            }

            @Override
            public Object getItem(int position) {
                return arrayDemo[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View layout=View.inflate(MainActivity.this, R.layout.item, null);
                ImageView imageView = (ImageView)layout.findViewById(R.id.item_image);
                TextView textView =(TextView)layout.findViewById(R.id.item_text);
                imageView.setImageResource(photos[position]);
                textView.setText(arrayDemo[position]);
                return layout;
            }
        };
//        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.item,R.id.item_text,arrayDemo);
//        listView.setAdapter(arrayAdapter);
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setContentView(R.layout.detail);
                ImageView imageView=findViewById(R.id.image_detail);
                imageView.setImageResource(photos[position]);
                TextView textView=findViewById(R.id.text_detail);
                textView.setText(arrayDemo[position]);
                Toast.makeText(getApplicationContext(),"You clicked "+ arrayDemo[position],Toast.LENGTH_LONG).show();
            }
        });

    }

}
