package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManagerActivity extends AppCompatActivity {

    Button btn_login;
    EditText edt_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        btn_login = findViewById(R.id.btn_login);
        edt_check = findViewById(R.id.edt_check);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edt_check.equals("") && edt_check.getText().toString().equals("cnsahasik")){
                    Intent intent = new Intent(ManagerActivity.this, ManagerMainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "정확히 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
