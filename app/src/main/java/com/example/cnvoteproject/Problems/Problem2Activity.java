package com.example.cnvoteproject.Problems;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.sacot41.scviewpager.DotsView;
import com.example.cnvoteproject.Adapters.Adapter2;
import com.example.cnvoteproject.Global;
import com.example.cnvoteproject.MainActivity;
import com.example.cnvoteproject.R;
import com.example.cnvoteproject.SolvedActivity;

import static com.example.cnvoteproject.Global.isOneSolved;
import static com.example.cnvoteproject.Global.totalScore;

public class Problem2Activity extends AppCompatActivity {

    Button btn_ok,btn_home;
    EditText edt_answer;
    String answer;
    String []correct = new String[]{"5/7", "4/7", "252"};
    //TODO : 문제 답 수정 - 4 겹침
    Adapter2 adapter2;
    ViewPager viewPager;
    DotsView mDotsView;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_two);

        viewPager = findViewById(R.id.two_view);
        adapter2 = new Adapter2(this);
        viewPager.setAdapter(adapter2);
        btn_ok = findViewById(R.id.two_btn_ok);
        edt_answer = findViewById(R.id.two_edt_answer);
        btn_home = findViewById(R.id.two_btn_home);
        txt = findViewById(R.id.txt2);

        mDotsView = (DotsView) findViewById(R.id.two_dotsview_main);
        mDotsView.setDotRessource(R.drawable.dot_selected, R.drawable.dot_unselected);
        mDotsView.setNumberOfPage(3);

        if( Global.secondProblem[0] + Global.secondProblem[1] + Global.secondProblem[2] == 3){
            txt.setVisibility(View.VISIBLE);

        }

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
                    Toast.makeText(Problem2Activity.this, "정답을 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
                else {
                    answer = edt_answer.getText().toString();

                    if(answer.equals(correct[0])) {
                        if(Global.secondProblem[0] == 1) {
                            Toast.makeText(Problem2Activity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 2;
                            isOneSolved = true;
                            Global.secondProblem[0] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 2);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else if(answer.equals(correct[1])) {
                        if(Global.secondProblem[1] == 1) {
                            Toast.makeText(Problem2Activity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 2;
                            isOneSolved = true;
                            Global.secondProblem[1] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 2);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else if(answer.equals(correct[2])) {
                        if(Global.secondProblem[2] == 1) {
                            Toast.makeText(Problem2Activity.this, "이미 푼 문제입니다!", Toast.LENGTH_SHORT).show();
                        }else {
                            totalScore += 2;
                            isOneSolved = true;
                            Global.secondProblem[2] = 1;
                            Intent mintent = new Intent(getApplicationContext(), SolvedActivity.class);
                            mintent.putExtra("whatSolved", 2);
                            startActivity(mintent);
                            finish();
                        }
                    }
                    else {
                        Toast.makeText(Problem2Activity.this, "정답이 아닙니다! 다시 한번 생각해보세요", Toast.LENGTH_SHORT).show();
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