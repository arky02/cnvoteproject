package com.example.cnvoteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ServerActivity extends AppCompatActivity {

    EditText edt_teamName;
    Button btn_enter;
    Boolean parsingDone = true;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    int[] data = new int[80];
    float average = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        edt_teamName = findViewById(R.id.edt_teamName);
        btn_enter = findViewById(R.id.btn_enter);

        firebaseDatabase.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if(parsingDone && checkData(snapshot.getValue())) {

                        for (int i = 0; i < 80; i++) {
                            data[i] = split(Parsing(snapshot.getValue()))[i];
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                for (int i = 0; i < 80; i++) {
                    Global.data.add(data[i]);
                }

                pushData(edt_teamName.getText().toString());
                getAverage();
                Global.average = average;
                Global.diviation = getDiviation();
                startActivity(intent);
                finish();
            }
        });
    }
    public String Parsing(Object o) {
        String data = o.toString();
        StringBuffer stringBuffer = new StringBuffer();
        int check = 0;
        for (int i = 0; ; i++) {
            if(data.charAt(i) == ']'){
                break;
            }
            if(check != 0) {
                stringBuffer.append(data.charAt(i));
            }
            if(data.charAt(i) == '[') {
                check ++;
            }
        }
        parsingDone = false;
        return stringBuffer.toString();
    }

    public void pushData(String teamName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/");
        stringBuffer.append(teamName);
        stringBuffer.append("/");

        HashMap<String, Object> result = new HashMap<>();
        result.put("/player/" + stringBuffer.toString(), toMap());
        databaseReference.updateChildren(result);
    }

    public int[] split(String s) {
        int returnData[] = new int[80];
        String[] data = s.split(", ");
        for (int i = 0; i < 80; i++) {
            returnData[i] = Integer.parseInt(data[i]);
        }
        return returnData;
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Time", 0);
        result.put("Similarity", 0.0f);
        return result;
    }

    public boolean checkData(Object o) {
        String data = o.toString();
        if(data.charAt(0) == '[') return true;
        else return false;
    }

    public void getAverage() {
        float sum = 0.0f;
        for (int i = 0; i < 80; i++) {
            sum += (float)data[i];
        }
        average =  sum / 80;
    }

    public double getDiviation() {
        double sum = 0.0f;
        double result = 0.0f;
        for (int i = 0; i < 80; i++) {
            sum += (data[i] - average) * (data[i] - average);
        }
        result = sum / 80;
        return Math.sqrt(result);
    }
}
