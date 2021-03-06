package com.example.cnvoteproject.Problems;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cnvoteproject.FirebasePost;
import com.example.cnvoteproject.Global;
import com.example.cnvoteproject.MainActivity;
import com.example.cnvoteproject.R;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Problem9Activity extends AppCompatActivity {

    Button btn_yes,btn_no,btn_home;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    String what ="";
    LinearLayout nine_1,nine_2;
    boolean real = false;

    TextView nine_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem9);

        btn_yes = findViewById(R.id.nine_btn_yes);
        btn_no = findViewById(R.id.nine_btn_no);
        nine_1 =findViewById(R.id.nine_1);
        nine_2 = findViewById(R.id.nine_2);
        btn_home = findViewById(R.id.nine_btn_home);
        nine_context = findViewById(R.id.nine_context);
        nine_context.setText(""+Global.stringData.get(8));

        if(Global.real9){
            nine_1.setVisibility(View.GONE);
            nine_2.setVisibility(View.VISIBLE);
        }


        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                what = "찬성";
                Toast.makeText(getApplicationContext(), "찬성을 선택히였습니다.", Toast.LENGTH_SHORT).show();

            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                what = "반대";
                Toast.makeText(getApplicationContext(), "반대를 선택히였습니다.", Toast.LENGTH_SHORT).show();

            }
        });


        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show(); // 진짜?
            }
        });

    }
    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("투표를 결정하시겠습니까?");
        builder.setMessage("투표결정 이후에는 다시 선택할 수 없습니다.");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(what.equals("")){
                            Toast.makeText(getApplicationContext(),"찬반투표를 진행해주세요",Toast.LENGTH_LONG).show();
                        }else{
                            databaseReference.child("result").push().setValue("안건9"+"/"+what);
                            Global.real9 = true;
                            finish();
                        }

                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"취소했습니다",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
}
