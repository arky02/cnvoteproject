package com.example.cnvoteproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {



    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    List<Object> Array = new ArrayList<Object>();

    int one_yes=0;
    int two_yes=0;
    int three_yes= 0;
    int four_yes= 0;
    int five_yes =0;
    int six_yes =0;
    int seven_yes = 0;
    int eight_yes = 0;
    int nine_yes =0;
    int ten_yes =0;
    int eleven_yes = 0;
    int twelve_yes = 0;
    int one_no = 0;
    int two_no = 0;
    int three_no = 0;
    int four_no = 0;
    int five_no = 0;
    int six_no = 0;
    int seven_no = 0;
    int eight_no = 0;
    int nine_no = 0;
    int ten_no = 0;
    int eleven_no = 0;
    int twelve_no = 0;
    int[] yn = new int[24];

    BarChart stackedChart;
    int[] colorArray = new int[]{Color.BLUE,Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        stackedChart = findViewById(R.id.chart);

        BarDataSet bardataset = new BarDataSet(dataValues1(), "BarSEt");
        bardataset.setColors(colorArray);


        initDatabase();


        mReference = mDatabase.getReference("result"); // 변경값을 확인할 child 이름
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    String msg2 = messageData.getValue().toString();

                    Array.add(msg2);
                    // child 내에 있는 데이터만큼 반복합니다. for(int i=0;i<Array.size();i++){
                                if(msg2.equals("안건1/찬성")){
                                    ++one_yes;
                                }else if(msg2.equals("안건1/반대")){
                                    ++one_no;
                                }else if(msg2.equals("안건2/찬성")){
                                    ++two_yes;
                                }else if(msg2.equals("안건2/반대")){
                                    ++two_no;
                                }else if(msg2.equals("안건3/찬성")){
                                    ++three_yes;
                                }else if(msg2.equals("안건3/반대")){
                                    ++three_no;
                                }else if(msg2.equals("안건4/찬성")){
                                    ++four_yes;
                                }else if(msg2.equals("안건4/반대")){
                                    ++four_no;
                                }else if(msg2.equals("안건5/찬성")){
                                    ++five_yes;
                                }else if(msg2.equals("안건5/반대")){
                                    ++five_no;
                                }else if(msg2.equals("안건6/찬성")){
                                    ++six_yes;
                                }else if(msg2.equals("안건6/반대")){
                                    ++six_no;
                                }else if(msg2.equals("안건7/찬성")){
                                    ++seven_yes;
                                }else if(msg2.equals("안건7/반대")){
                                    ++seven_no;
                                }else if(msg2.equals("안건8/찬성")){
                                    ++eight_yes;
                                }else if(msg2.equals("안건8/반대")){
                                    ++eight_no;
                                }else if(msg2.equals("안건9/찬성")){
                                    ++nine_yes;
                                }else if(msg2.equals("안건9/반대")){
                                    ++nine_no;
                                }else if(msg2.equals("안건10/찬성")){
                                    ++ten_yes;
                                }else if(msg2.equals("안건10/반대")){
                                    ++ten_no;
                                }else if(msg2.equals("안건11/찬성")){
                                    ++eleven_yes;
                                }else if(msg2.equals("안건11/반대")){
                                    ++eleven_no;
                                }else if(msg2.equals("안건12/찬성")){
                                    ++twelve_yes;
                                }else if(msg2.equals("안건12/반대")){
                                    ++twelve_no;
                                }
                            }








                Log.d("one_yes", Integer.toString(one_yes));
                Log.d("one_no", Integer.toString(one_no));
                Log.d("2_yes", Integer.toString(two_yes));
                Log.d("2_no", Integer.toString(two_no));
                Log.d("3_no", Integer.toString(three_no));
                Log.d("3_yes", Integer.toString(three_yes));



                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }



    private void initDatabase() {

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("log");
        mReference.child("log").setValue("check");

        mChild = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mReference.addChildEventListener(mChild);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }

    private ArrayList<BarEntry> dataValues1(){
        ArrayList<BarEntry> datavals = new ArrayList<>();

        one_yes = yn[0];
        one_no = yn[1];
        two_yes = yn[2];
        two_no = yn[3];
        three_yes = yn[4];
        three_no = yn[5];
        four_yes = yn[6];
        four_no = yn[7];
        five_yes = yn[8];
        five_no = yn[9] ;
        six_yes = yn[10];
        six_no = yn[11];
        seven_yes = yn[12];
        seven_no = yn[13];
        eight_yes=yn[14];
        eight_no = yn[15];
        nine_yes = yn[16];
        nine_no = yn[17];
        ten_yes = yn[18];
        ten_no = yn[19];
        eleven_yes = yn[20];
        eleven_no = yn[21];
        twelve_yes = yn[22];
        two_no = yn[23];

        for(int i = 0;i<Global.length;i+=2){
            datavals.add(new BarEntry(0, new float[]{yn[i],yn[i+1]}));
        }

        return datavals;
    }
}
