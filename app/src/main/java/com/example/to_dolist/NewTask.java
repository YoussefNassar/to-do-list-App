package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTask extends AppCompatActivity {
    EditText etNewTitle, etNewDesc;

    DatabaseHelper myDB;
    Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        etNewTitle = findViewById(R.id.etNewTitle);
        etNewDesc = findViewById(R.id.etNewDesc);

        myDB = new DatabaseHelper(this);


    }


    public void onClickSave(View view){
        String newTitle = etNewTitle.getText().toString().trim();
        String newDesc = etNewDesc.getText().toString().trim();
        if(newTitle.length() == 0 && newDesc.length() != 0){
            Toast.makeText(this, "you need to write a title", Toast.LENGTH_SHORT).show();
        }else if(newTitle.length() != 0 && newDesc.length() == 0){
            Toast.makeText(this, "you need to write a description", Toast.LENGTH_SHORT).show();
        }else if(newTitle.length() == 0 && newDesc.length() == 0){
            Toast.makeText(this, "both fields are empty", Toast.LENGTH_SHORT).show();
        }else if(newTitle.length() != 0 && newDesc.length() != 0){
            addData(newTitle, newDesc);
            Intent intent = new Intent(this,Listing.class);
            startActivity(intent);
        }
    }

    public void addData(String title, String desc){
        boolean insertData = myDB.addData(title,desc);
        if(insertData){
            Toast.makeText(this, "Successfully Enterd Data :)", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Something Went Wrong :(", Toast.LENGTH_SHORT).show();
        }

    }
}
