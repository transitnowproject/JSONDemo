package com.example.angel.jsondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCreate, btnParse, btnShow;
    private TextView txt;
    private String jsonString, name;
    private StringBuffer buffer;
    private int id, salary;
    private Employee emp;
    private ArrayList<Employee> arrayList;
    public static final String TAG="state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnParse = (Button) findViewById(R.id.btnParse);
        btnShow = (Button) findViewById(R.id.btnShow);
        txt = (TextView) findViewById(R.id.txt);


        btnCreate.setOnClickListener(this);
        btnParse.setOnClickListener(this);
        btnShow.setOnClickListener(this);
        arrayList = new ArrayList<Employee>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:

                try {
                    JSONObject object1 = new JSONObject();
                    object1.put("id", 101);
                    object1.put("name", "Diksha");
                    object1.put("salary", 50000);

                    JSONObject object2 = new JSONObject();
                    object2.put("id", 102);
                    object2.put("name", "Rohan");
                    object2.put("salary", 60000);

                    JSONObject object3 = new JSONObject();
                    object3.put("id", 103);
                    object3.put("name", "Lovish");
                    object3.put("salary", 70000);

                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(object1);
                    jsonArray.put(object2);
                    jsonArray.put(object3);

                    JSONObject employee = new JSONObject();
                    employee.put("EMPLOYEE", jsonArray);
                    jsonString = employee.toString();
                    txt.setText(jsonString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btnParse:

                buffer = new StringBuffer();

                try {
                    JSONObject object = new JSONObject(jsonString);
                    JSONArray jsonArray = object.getJSONArray("EMPLOYEE");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject objectt = (JSONObject) jsonArray.get(i);

                        name = objectt.getString("name");
                        Log.d(TAG, "name");
                        id = objectt.getInt("id");
                        Log.d(TAG, "id");
                        salary = objectt.getInt("salary");
                        Log.d(TAG, "salary");
                        buffer.append(id + " " + name + " " + salary + "\n");

                        emp = new Employee(name, id, salary);
                        arrayList.add(emp);
                        // Toast.makeText(MainActivity.this,buffer.toString(),Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<arrayList.size();i++){
                    Employee e= arrayList.get(i);
                    id = e.getId();
                    salary = e.getSalary();
                    name = e.getName();
                }

                //txt.setText(buffer.toString());
                Toast.makeText(MainActivity.this, buffer.toString(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btnShow:
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                intent.putParcelableArrayListExtra("empArrayList", arrayList);
                startActivity(intent);


        }

    }
}
