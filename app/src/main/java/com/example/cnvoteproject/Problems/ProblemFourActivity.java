package com.example.cnvoteproject.Problems;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.sacot41.scviewpager.DotsView;
import com.example.cnvoteproject.Adapters.Adapter4;
import com.example.cnvoteproject.ClearEditText;
import com.example.cnvoteproject.Global;
import com.example.cnvoteproject.MainActivity;
import com.example.cnvoteproject.R;
import com.example.cnvoteproject.SolvedActivity;

import static com.example.cnvoteproject.Global.isOneSolved;
import static com.example.cnvoteproject.Global.totalScore;

public class ProblemFourActivity extends AppCompatActivity {

    Button btn_ok,btn_home;
    ClearEditText edt_answer;
    String answer;
    ViewPager viewPager;
    Adapter4 adapter;
    TextView txt;
    String []correct = new String[]{"1/4", "125", "70"};
    //TODO : 문제 답 업데이트
    DotsView  mDotsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_four);

        btn_ok = findViewById(R.id.four_btn_ok);
        edt_answer = findViewById(R.id.four_edt_answer);
        btn_home = findViewById(R.id.four_btn_home);
        txt = findViewById(R.id.txt4);
        viewPager = findViewById(R.id.four_view);
        adapter = new Adapter4(this);
        viewPager.setAdapter(adapter);
        if( Global.fourthProblem[0] + Global.fourthProblem[1] + Global.fourthProblem[2] == 3){
            txt.setVisibility(View.VISIBLE);

        }

        mDotsView = (DotsView) findViewById(R.id.four_dotsview_main);
        mDotsView.setDotRessource(R.drawable.dot_selected, R.drawable.dot_unselected);
        mDotsView.setNumberOfPage(3);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mDotsView.selectDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_answer.getText().toString().equals("")) {
                    Toast.makeText(ProblemFourActivity.this, "정답을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    answer = edt_answer.getText().toString();

                    if(answer.equals(correct[0])) {
                        if(Global.fourthProblem[0] == 1) {
                            Toast.makeText(ProblemFourActivity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 4;
                            isOneSolved = true;
                            Global.fourthProblem[0] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 4);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else if(answer.equals(correct[1])) {
                        if(Global.fourthProblem[1] == 1) {
                            Toast.makeText(ProblemFourActivity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 4;
                            isOneSolved = true;
                            Global.fourthProblem[1] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 4);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else if(answer.equals(correct[2])) {
                        if(Global.fourthProblem[2] == 1) {
                            Toast.makeText(ProblemFourActivity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 4;
                            isOneSolved = true;
                            Global.fourthProblem[2] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 4);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else {
                        Toast.makeText(ProblemFourActivity.this, "정답이 아닙니다! 다시 한번 생각해보세요", Toast.LENGTH_SHORT).show();
                    }

                }
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
        builder.setTitle("홈으로 돌아갑니다");
        builder.setMessage("홈으로 돌아가시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"홈으로 돌아갑니다.",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
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