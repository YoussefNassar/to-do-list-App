package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView tvTitleDetails;
    TextView tvDescDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvTitleDetails = findViewById(R.id.tvTitleDetails);
        tvDescDetails = findViewById(R.id.tvDescDetails);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        tvTitleDetails.setText(title);
        tvDescDetails.setText(desc);

    }



}
