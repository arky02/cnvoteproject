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
import com.github.mikephil.charting.data.BarData;
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
    List<Object> Array = new ArrayList<Object>();

    int[] yn = new int[24];

    BarChart stackedChart;
    int[] colorArray = new int[]{Color.BLUE,Color.RED};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        stackedChart = findViewById(R.id.chart);

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
                                    ++yn[0];
                                }else if(msg2.equals("안건1/반대")){
                                    ++yn[1];
                                }else if(msg2.equals("안건2/찬성")){
                                    ++yn[2];
                                }else if(msg2.equals("안건2/반대")){
                                    ++yn[3];
                                }else if(msg2.equals("안건3/찬성")){
                                    ++yn[4];
                                }else if(msg2.equals("안건3/반대")){
                                    ++yn[5];
                                }else if(msg2.equals("안건4/찬성")){
                                    ++yn[6];
                                }else if(msg2.equals("안건4/반대")){
                                    ++yn[7];
                                }else if(msg2.equals("안건5/찬성")){
                                    ++yn[8];
                                }else if(msg2.equals("안건5/반대")){
                                    ++yn[9];
                                }else if(msg2.equals("안건6/찬성")){
                                    ++yn[10];
                                }else if(msg2.equals("안건6/반대")){
                                    ++yn[11];
                                }else if(msg2.equals("안건7/찬성")){
                                    ++yn[12];
                                }else if(msg2.equals("안건7/반대")){
                                    ++yn[13];
                                }else if(msg2.equals("안건8/찬성")){
                                    ++yn[14];
                                }else if(msg2.equals("안건8/반대")){
                                    ++yn[15];
                                }else if(msg2.equals("안건9/찬성")){
                                    ++yn[16];
                                }else if(msg2.equals("안건9/반대")){
                                    ++yn[17];
                                }else if(msg2.equals("안건10/찬성")){
                                    ++yn[18];
                                }else if(msg2.equals("안건10/반대")){
                                    ++yn[19];
                                }else if(msg2.equals("안건11/찬성")){
                                    ++yn[20];
                                }else if(msg2.equals("안건11/반대")){
                                    ++yn[21];
                                }else if(msg2.equals("안건12/찬성")){
                                    ++yn[22];
                                }else if(msg2.equals("안건12/반대")){
                                    ++yn[23];
                                }
                            }
                BarDataSet bardataset = new BarDataSet(dataValues1(), "안건투표결과");
                bardataset.setColors(colorArray);
                stackedChart.animateY(5000);
                BarData barData = new BarData(bardataset);
                stackedChart.setData(barData);

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


        for(int i = 0;i<=(Global.length)*2-2;i+=2){
            datavals.add(new BarEntry(i, new float[]{yn[i],yn[i+1]}));
        }

        return datavals;
    }
    private ArrayList votes(){
        ArrayList votes= new ArrayList<>();

        for(int i = 0;i<(Global.length)*2;i+=2){
            votes.add("안건"+(i+2)/2);
        }

        return votes;
    }
}
