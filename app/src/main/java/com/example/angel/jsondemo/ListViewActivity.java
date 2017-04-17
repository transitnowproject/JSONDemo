package com.example.angel.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv;

    private ArrayList<Employee> arrayList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = (ListView) findViewById(R.id.lv);

        arrayList = getIntent().getParcelableArrayListExtra("empArrayList");
        adapter = new Adapter(this,arrayList);



        lv.setAdapter(adapter);


    }
}
