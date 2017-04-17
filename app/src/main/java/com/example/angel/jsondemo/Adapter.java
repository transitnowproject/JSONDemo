package com.example.angel.jsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by angel on 2017-04-12.
 */

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> arrayList;
    private LayoutInflater inflater;

    public Adapter(Context context, ArrayList<Employee> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_employee, parent, false);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtId = (TextView) view.findViewById(R.id.txtId);
        TextView txtSalary = (TextView) view.findViewById(R.id.txtSalary);

        Employee e = arrayList.get(position);
        String name = e.getName();
        int id = e.getId();
        int salary = e.getSalary();

        txtName.setText(name);
        txtId.setText(String.valueOf(id));
        txtSalary.setText(String.valueOf(salary));
        return view;

    }
}
