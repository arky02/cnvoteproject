package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cnvoteproject.Problems.Problem5Activity;
import com.example.cnvoteproject.Problems.Problem4Activity;
import com.example.cnvoteproject.Problems.Problem1Activity;
import com.example.cnvoteproject.Problems.Problem6Activity;
import com.example.cnvoteproject.Problems.Problem3Activity;
import com.example.cnvoteproject.Problems.Problem2Activity;

public class SolvedActivity extends AppCompatActivity {

    String whatSolved= null;
    ProgressBar progress;
    int progressStatusCounter = 0;
    Handler progressHandler = new Handler();
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solved);

        progress = findViewById(R.id.progress);
        score = findViewById(R.id.score);
        final int mintent = getIntent().getIntExtra("whatSolved", 0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatusCounter < 3) {
                    progressStatusCounter += 1;
                    progressHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progress.setProgress(progressStatusCounter);
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(progressStatusCounter == 3) {
                        Intent intent = new Intent();

                        switch (mintent) {
                            case 1 :
                                intent.setClass(getApplicationContext(), Problem1Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 2 :
                                intent.setClass(getApplicationContext(), Problem2Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 3 :
                                intent.setClass(getApplicationContext(), Problem3Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 4 :
                                intent.setClass(getApplicationContext(), Problem4Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 5 :
                                intent.setClass(getApplicationContext(), Problem5Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                            case 6 :
                                intent.setClass(getApplicationContext(), Problem6Activity.class);
                                startActivity(intent);
                                finish();
                                break;
                        }

                    }
                }
            }
        }).start();

        int total = 0;

        switch (mintent) {
            case 1 :
                total = Global.firstProblem[0] + Global.firstProblem[1] + Global.firstProblem[2];
                score.setText(total + " of 3" );
                break;
            case 2 :
                total = Global.secondProblem[0] + Global.secondProblem[1] + Global.secondProblem[2];
                score.setText(total + " of 3" );
                break;
            case 3 :
                total = Global.thirdProblem[0] + Global.thirdProblem[1] + Global.thirdProblem[2];
                score.setText(total + " of 3" );
                break;
            case 4 :
                total = Global.fourthProblem[0] + Global.fourthProblem[1] + Global.fourthProblem[2];
                score.setText(total + " of 3" );
                break;
            case 5 :
                total = Global.fifthProblem[0] + Global.fifthProblem[1] + Global.fifthProblem[2];
                score.setText(total + " of 3" );
                break;
            case 6 :
                total = Global.sixthProblem[0] + Global.sixthProblem[1] + Global.sixthProblem[2];
                score.setText(total + " of 3" );
                break;

        }

    }
}
