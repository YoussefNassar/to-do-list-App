package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Listing extends AppCompatActivity implements TaskAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Task> tasks;

    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        // setting layout maneger
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myDB = new DatabaseHelper(this);
        tasks = new ArrayList<Task>();

        Cursor data = myDB.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(Listing.this, "no elements", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {

                Task task = new Task(data.getString(1), data.getString(2));
                tasks.add(task);

                myAdapter = new TaskAdapter(this, tasks);
                recyclerView.setAdapter(myAdapter);
            }
        }

    }


    @Override
    public void onItemClicked(int index) {
        Intent intent = new Intent(this,Details.class);
        intent.putExtra("title",tasks.get(index).getTitle());
        intent.putExtra("desc",tasks.get(index).getDesc());
        startActivity(intent);
    }
}
