package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManagerMainActivity extends AppCompatActivity {

    EditText edt_com, edt_password;
    Button btn_com, btn_password,btn_clear,btn_statistics;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);

        edt_com = findViewById(R.id.edt_com);
        edt_password = findViewById(R.id.edt_password);
        btn_password = findViewById(R.id.btn_password);
        btn_com = findViewById(R.id.btn_com);
        btn_clear = findViewById(R.id.btn_clear);
        btn_statistics = findViewById(R.id.btn_statistics);

        btn_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //통계보기로 넘어가기
            }
        });

        btn_com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edt_com.getText().toString().equals("")){
                    databaseReference.child("opinion").push().setValue(edt_com.getText().toString());
                    edt_com.setText("");
                    Toast.makeText(getApplicationContext(), "안건이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edt_password.getText().toString().equals("")){
                    databaseReference.child("password").child("pw").setValue(edt_password.getText().toString());
                    edt_password.setText("");
                    Toast.makeText(getApplicationContext(), "비밀번호 설정이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("opinion").setValue(edt_com.getText().toString());
                Toast.makeText(getApplicationContext(), "초기화가 완료되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
