package com.major.completion;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TotalUpdateListener {
    private RecyclerView recyclerView;
    private ChecklistAdapter adapter;
    private Spinner departmentSpinner;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ChecklistAdapter(this);
        recyclerView.setAdapter(adapter);

        departmentSpinner = findViewById(R.id.departmentSpinner);
        totalTextView = findViewById(R.id.totalTextView);

        List<String> departmentOptions = new ArrayList<>();
        departmentOptions.add("1학년 1학기");
        departmentOptions.add("1학년 2학기");
        departmentOptions.add("2학년 1학기");
        departmentOptions.add("2학년 2학기");
        departmentOptions.add("3학년 1학기");
        departmentOptions.add("3학년 2학기");
        departmentOptions.add("4학년 1학기");
        departmentOptions.add("4학년 2학기");
        departmentOptions.add("전공 선택 과목");


        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departmentOptions);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(spinnerAdapter);

        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedDepartment = departmentOptions.get(position);
                updateChecklistForDepartment(selectedDepartment);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private void updateChecklistForDepartment(String department) {
        switch (department) {
            case "1학년 1학기":
                adapter.setItems(0);
                break;
            case "1학년 2학기":
                adapter.setItems(1);
                break;
            case "2학년 1학기":
                adapter.setItems(2);
                break;
            case "2학년 2학기":
                adapter.setItems(3);
                break;
            case "3학년 1학기":
                adapter.setItems(4);
                break;
            case "3학년 2학기":
                adapter.setItems(5);
                break;
            case "4학년 1학기":
                adapter.setItems(6);
                break;
            case "4학년 2학기":
                adapter.setItems(7);
                break;
            case "전공 선택 과목":
                adapter.setItems(8);
                break;

            default:
                adapter.setItems(0);
                break;
        }

        // list refresh
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTotalUpdate(int total, int totalCredits) {
        Log.e("onTotalUpdate", "ENTER");
        totalTextView.setText("Total: " + total + " / " + "127" + " 학점");
    }
}
