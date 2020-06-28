package com.example.cnvoteproject.ViewPagerCards;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.cnvoteproject.Global;
import com.example.cnvoteproject.MainActivity;
import com.example.cnvoteproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataSettingActivity extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    ProgressBar progress;

    String[] opinions = new String[12];
    boolean parsingDone = true;

    public class FirebaseSet extends AsyncTask<String, Boolean, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setIndeterminate(true);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            firebaseDatabase.getReference().addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        if(parsingDone && Parsing(snapshot.getValue()) != "") {
                            Log.e("check", ""+(snapshot.getValue()));
                            setData(Parsing(snapshot.getValue()));
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            progress.setIndeterminate(false);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_setting);

        progress = findViewById(R.id.progress);
        FirebaseSet firebaseSet = new FirebaseSet();
        firebaseSet.execute();
    }

    public String Parsing(Object o) {
        String data = o.toString();
        StringBuffer stringBuffer = new StringBuffer();
        int check = 0;
        if(data.charAt(1) == 'l' && data.charAt(2) == 'o') return "";
        for (int i = 0; ; i++) {
            if(data.charAt(i) == '}'){
                break;
            }
            if(check != 0) {
                stringBuffer.append(data.charAt(i));
            }
            if(data.charAt(i) == '{') {
                check ++;
            }
        }
        parsingDone = false;
        return stringBuffer.toString();
    }

    public void setData(String s){
        String[] temp = s.split(", ");
        Global.length = temp.length;
        for (int i = 0; i < temp.length; i++) {
            String[] temp2 = temp[i].split("=");
            Global.stringdata[i] = temp2[1];
        }
    }

}
