package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AlertActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btn = findViewById(R.id.btn_start2);

        btn.setOnClickListener(v->{
            Intent mintent = new Intent(getApplicationContext(),ShowActivity.class);
            startActivity(mintent);
            finish();
        });


    }
}
