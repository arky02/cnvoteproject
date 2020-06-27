package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.cnvoteproject.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.Collections;

import static android.view.View.GONE;
import static com.example.cnvoteproject.Global.gettingData;
import static com.example.cnvoteproject.Global.sumcount;

public class ShowActivity extends AppCompatActivity {

    TextView data, txt_average, diviation, range, card1, text_canPickCard,text_PickedCard,text_totalScore,LastText,txt,space;
    double average = 0.0f;
    int sum = 0;
    int NumCardFlipped = 0;
    boolean allEnabled = false;
    int i ;
    LinearLayout hide1,hide2;
    int count = 0;
    EasyFlipView[] FlipText = new EasyFlipView[81];
    TextView[] FlipNum = new TextView[81];
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        txt_average = findViewById(R.id.average);
        space = findViewById(R.id.space);
        LastText = findViewById(R.id.lastText);
        diviation = findViewById(R.id.diviation);
        range = findViewById(R.id.range);
        text_canPickCard = findViewById(R.id.text_canPickCard);
        text_PickedCard = findViewById(R.id.text_pickedCard);
        text_totalScore = findViewById(R.id.totalScore);
        table = findViewById(R.id.table);
        hide1 = findViewById(R.id.hide1);
        hide2 = findViewById(R.id.hide3);
        txt = findViewById(R.id.txtt2);


//        getAverage();
//        showAverage();
        text_totalScore.setText(""+Global.totalScore);
        text_PickedCard.setText(NumCardFlipped+"");
        text_canPickCard.setText(Global.totalScore-NumCardFlipped+"");

        FlipText[0]= (EasyFlipView) findViewById(R.id.cd1);
        FlipText[1]= (EasyFlipView) findViewById(R.id.cd2);
        FlipText[2]= (EasyFlipView) findViewById(R.id.cd3);
        FlipText[3]= (EasyFlipView) findViewById(R.id.cd4);
        FlipText[4]= (EasyFlipView) findViewById(R.id.cd5);
        FlipText[5]= (EasyFlipView) findViewById(R.id.cd6);
        FlipText[6]= (EasyFlipView) findViewById(R.id.cd7);
        FlipText[7]= (EasyFlipView) findViewById(R.id.cd8);
        FlipText[8]= (EasyFlipView) findViewById(R.id.cd9);
        FlipText[9]= (EasyFlipView) findViewById(R.id.cd10);
        FlipText[10]= (EasyFlipView) findViewById(R.id.cd11);
        FlipText[11]= (EasyFlipView) findViewById(R.id.cd12);
        FlipText[12]= (EasyFlipView) findViewById(R.id.cd13);
        FlipText[13]= (EasyFlipView) findViewById(R.id.cd14);
        FlipText[14]= (EasyFlipView) findViewById(R.id.cd15);
        FlipText[15]= (EasyFlipView) findViewById(R.id.cd16);
        FlipText[16]= (EasyFlipView) findViewById(R.id.cd17);
        FlipText[17]= (EasyFlipView) findViewById(R.id.cd18);
        FlipText[18]= (EasyFlipView) findViewById(R.id.cd19);
        FlipText[19]= (EasyFlipView) findViewById(R.id.cd20);
        FlipText[20]= (EasyFlipView) findViewById(R.id.cd21);
        FlipText[21]= (EasyFlipView) findViewById(R.id.cd22);
        FlipText[22]= (EasyFlipView) findViewById(R.id.cd23);
        FlipText[23]= (EasyFlipView) findViewById(R.id.cd24);
        FlipText[24]= (EasyFlipView) findViewById(R.id.cd25);
        FlipText[25]= (EasyFlipView) findViewById(R.id.cd26);
        FlipText[26]= (EasyFlipView) findViewById(R.id.cd27);
        FlipText[27]= (EasyFlipView) findViewById(R.id.cd28);
        FlipText[28]= (EasyFlipView) findViewById(R.id.cd29);
        FlipText[29]= (EasyFlipView) findViewById(R.id.cd30);
        FlipText[30]= (EasyFlipView) findViewById(R.id.cd31);
        FlipText[31]= (EasyFlipView) findViewById(R.id.cd32);
        FlipText[32]= (EasyFlipView) findViewById(R.id.cd33);
        FlipText[33]= (EasyFlipView) findViewById(R.id.cd34);
        FlipText[34]= (EasyFlipView) findViewById(R.id.cd35);
        FlipText[35]= (EasyFlipView) findViewById(R.id.cd36);
        FlipText[36]= (EasyFlipView) findViewById(R.id.cd37);
        FlipText[37]= (EasyFlipView) findViewById(R.id.cd38);
        FlipText[38]= (EasyFlipView) findViewById(R.id.cd39);
        FlipText[39]= (EasyFlipView) findViewById(R.id.cd40);
        FlipText[40]= (EasyFlipView) findViewById(R.id.cd41);
        FlipText[41]= (EasyFlipView) findViewById(R.id.cd42);
        FlipText[42]= (EasyFlipView) findViewById(R.id.cd43);
        FlipText[43]= (EasyFlipView) findViewById(R.id.cd44);
        FlipText[44]= (EasyFlipView) findViewById(R.id.cd45);
        FlipText[45]= (EasyFlipView) findViewById(R.id.cd46);
        FlipText[46]= (EasyFlipView) findViewById(R.id.cd47);
        FlipText[47]= (EasyFlipView) findViewById(R.id.cd48);
        FlipText[48]= (EasyFlipView) findViewById(R.id.cd49);
        FlipText[49]= (EasyFlipView) findViewById(R.id.cd50);
        FlipText[50]= (EasyFlipView) findViewById(R.id.cd51);
        FlipText[51]= (EasyFlipView) findViewById(R.id.cd52);
        FlipText[52]= (EasyFlipView) findViewById(R.id.cd53);
        FlipText[53]= (EasyFlipView) findViewById(R.id.cd54);
        FlipText[54]= (EasyFlipView) findViewById(R.id.cd55);
        FlipText[55]= (EasyFlipView) findViewById(R.id.cd56);
        FlipText[56]= (EasyFlipView) findViewById(R.id.cd57);
        FlipText[57]= (EasyFlipView) findViewById(R.id.cd58);
        FlipText[58]= (EasyFlipView) findViewById(R.id.cd59);
        FlipText[59]= (EasyFlipView) findViewById(R.id.cd60);
        FlipText[60]= (EasyFlipView) findViewById(R.id.cd61);
        FlipText[61]= (EasyFlipView) findViewById(R.id.cd62);
        FlipText[62]= (EasyFlipView) findViewById(R.id.cd63);
        FlipText[63]= (EasyFlipView) findViewById(R.id.cd64);
        FlipText[64]= (EasyFlipView) findViewById(R.id.cd65);
        FlipText[65]= (EasyFlipView) findViewById(R.id.cd66);
        FlipText[66]= (EasyFlipView) findViewById(R.id.cd67);
        FlipText[67]= (EasyFlipView) findViewById(R.id.cd68);
        FlipText[68]= (EasyFlipView) findViewById(R.id.cd69);
        FlipText[69]= (EasyFlipView) findViewById(R.id.cd70);
        FlipText[70]= (EasyFlipView) findViewById(R.id.cd71);
        FlipText[71]= (EasyFlipView) findViewById(R.id.cd72);
        FlipText[72]= (EasyFlipView) findViewById(R.id.cd73);
        FlipText[73]= (EasyFlipView) findViewById(R.id.cd74);
        FlipText[74]= (EasyFlipView) findViewById(R.id.cd75);
        FlipText[75]= (EasyFlipView) findViewById(R.id.cd76);
        FlipText[76]= (EasyFlipView) findViewById(R.id.cd77);
        FlipText[77]= (EasyFlipView) findViewById(R.id.cd78);
        FlipText[78]= (EasyFlipView) findViewById(R.id.cd79);
        FlipText[79]= (EasyFlipView) findViewById(R.id.cd80);

        for( int j=5; j<=79; j++){

            int k = getResources().getIdentifier("cd_tx"+(i+1), "id", getPackageName());
            FlipNum[   j   ] = findViewById( k );
        }

        FlipNum[0] = findViewById(R.id.cd_tx1);
        FlipNum[1] = findViewById(R.id.cd_tx2);
        FlipNum[2] = findViewById(R.id.cd_tx3);
        FlipNum[3] = findViewById(R.id.cd_tx4);
        FlipNum[4] = findViewById(R.id.cd_tx5);
        FlipNum[5] = findViewById(R.id.cd_tx6);
        FlipNum[6] = findViewById(R.id.cd_tx7);
        FlipNum[7] = findViewById(R.id.cd_tx8);
        FlipNum[8] = findViewById(R.id.cd_tx9);
        FlipNum[9] = findViewById(R.id.cd_tx10);
        FlipNum[10] = findViewById(R.id.cd_tx11);
        FlipNum[11] = findViewById(R.id.cd_tx12);
        FlipNum[12] = findViewById(R.id.cd_tx13);
        FlipNum[13] = findViewById(R.id.cd_tx14);
        FlipNum[14] = findViewById(R.id.cd_tx15);
        FlipNum[15] = findViewById(R.id.cd_tx16);
        FlipNum[16] = findViewById(R.id.cd_tx17);
        FlipNum[17] = findViewById(R.id.cd_tx18);
        FlipNum[18] = findViewById(R.id.cd_tx19);
        FlipNum[19] = findViewById(R.id.cd_tx20);
        FlipNum[20] = findViewById(R.id.cd_tx21);
        FlipNum[21] = findViewById(R.id.cd_tx22);
        FlipNum[22] = findViewById(R.id.cd_tx23);
        FlipNum[23] = findViewById(R.id.cd_tx24);
        FlipNum[24] = findViewById(R.id.cd_tx25);
        FlipNum[25] = findViewById(R.id.cd_tx26);
        FlipNum[26] = findViewById(R.id.cd_tx27);
        FlipNum[27] = findViewById(R.id.cd_tx28);
        FlipNum[28] = findViewById(R.id.cd_tx29);
        FlipNum[29] = findViewById(R.id.cd_tx30);
        FlipNum[30] = findViewById(R.id.cd_tx31);
        FlipNum[31] = findViewById(R.id.cd_tx32);
        FlipNum[32] = findViewById(R.id.cd_tx33);
        FlipNum[33] = findViewById(R.id.cd_tx34);
        FlipNum[34] = findViewById(R.id.cd_tx35);
        FlipNum[35] = findViewById(R.id.cd_tx36);
        FlipNum[36] = findViewById(R.id.cd_tx37);
        FlipNum[37] = findViewById(R.id.cd_tx38);
        FlipNum[38] = findViewById(R.id.cd_tx39);
        FlipNum[39] = findViewById(R.id.cd_tx40);
        FlipNum[40] = findViewById(R.id.cd_tx41);
        FlipNum[41] = findViewById(R.id.cd_tx42);
        FlipNum[42] = findViewById(R.id.cd_tx43);
        FlipNum[43] = findViewById(R.id.cd_tx44);
        FlipNum[44] = findViewById(R.id.cd_tx45);
        FlipNum[45] = findViewById(R.id.cd_tx46);
        FlipNum[46] = findViewById(R.id.cd_tx47);
        FlipNum[47] = findViewById(R.id.cd_tx48);
        FlipNum[48] = findViewById(R.id.cd_tx49);
        FlipNum[49] = findViewById(R.id.cd_tx50);
        FlipNum[50] = findViewById(R.id.cd_tx51);
        FlipNum[51] = findViewById(R.id.cd_tx52);
        FlipNum[52] = findViewById(R.id.cd_tx53);
        FlipNum[53] = findViewById(R.id.cd_tx54);
        FlipNum[54] = findViewById(R.id.cd_tx55);
        FlipNum[55] = findViewById(R.id.cd_tx56);
        FlipNum[56] = findViewById(R.id.cd_tx57);
        FlipNum[57] = findViewById(R.id.cd_tx58);
        FlipNum[58] = findViewById(R.id.cd_tx59);
        FlipNum[59] = findViewById(R.id.cd_tx60);
        FlipNum[60] = findViewById(R.id.cd_tx61);
        FlipNum[61] = findViewById(R.id.cd_tx62);
        FlipNum[62] = findViewById(R.id.cd_tx63);
        FlipNum[63] = findViewById(R.id.cd_tx64);
        FlipNum[64] = findViewById(R.id.cd_tx65);
        FlipNum[65] = findViewById(R.id.cd_tx66);
        FlipNum[66] = findViewById(R.id.cd_tx67);
        FlipNum[67] = findViewById(R.id.cd_tx68);
        FlipNum[68] = findViewById(R.id.cd_tx69);
        FlipNum[69] = findViewById(R.id.cd_tx70);
        FlipNum[70] = findViewById(R.id.cd_tx71);
        FlipNum[71] = findViewById(R.id.cd_tx72);
        FlipNum[72] = findViewById(R.id.cd_tx73);
        FlipNum[73] = findViewById(R.id.cd_tx74);
        FlipNum[74] = findViewById(R.id.cd_tx75);
        FlipNum[75] = findViewById(R.id.cd_tx76);
        FlipNum[76] = findViewById(R.id.cd_tx77);
        FlipNum[77] = findViewById(R.id.cd_tx78);
        FlipNum[78] = findViewById(R.id.cd_tx79);
        FlipNum[79] = findViewById(R.id.cd_tx80);

            FlipText[0].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
                @Override
                public void onViewFlipCompleted(EasyFlipView flipView, EasyFlipView.FlipState newCurrentSide) {
                    String text = "" + getData();
                    FlipNum[0].setText(text);
                    FlipText[0].setFlipEnabled(false);
                    ++NumCardFlipped;
                    update(text);
                }
            });


        FlipText[1].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipNum[1].setText(text);
                FlipText[1].setFlipEnabled(false);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[2].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            String text = "" + getData();
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                FlipText[2].setFlipEnabled(false);
                FlipNum[2].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[3].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[3].setFlipEnabled(false);
                FlipNum[3].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[4].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[4].setFlipEnabled(false);
                FlipNum[4].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[5].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[5].setFlipEnabled(false);
                FlipNum[5].setText(""+getData());
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[6].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[6].setFlipEnabled(false);
                FlipNum[6].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[7].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[7].setFlipEnabled(false);
                FlipNum[7].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[8].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[8].setFlipEnabled(false);
                FlipNum[8].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[9].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[9].setFlipEnabled(false);
                FlipNum[9].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[10].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[10].setFlipEnabled(false);
                FlipNum[10].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[11].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[11].setFlipEnabled(false);
                FlipNum[11].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[12].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[12].setFlipEnabled(false);
                FlipNum[12].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[13].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[13].setFlipEnabled(false);
                FlipNum[13].setText(text);

                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[14].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[14].setFlipEnabled(false);
                FlipNum[14].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[15].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[15].setFlipEnabled(false);
                FlipNum[15].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[16].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[16].setFlipEnabled(false);
                FlipNum[16].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[17].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[17].setFlipEnabled(false);
                FlipNum[17].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[18].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[18].setFlipEnabled(false);
                FlipNum[18].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[19].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[19].setFlipEnabled(false);
                FlipNum[19].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[20].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[20].setFlipEnabled(false);
                FlipNum[20].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[21].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[21].setFlipEnabled(false);
                FlipNum[21].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[22].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[22].setFlipEnabled(false);
                FlipNum[22].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[23].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[23].setFlipEnabled(false);
                FlipNum[23].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[24].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();

                FlipText[24].setFlipEnabled(false);
                FlipNum[24].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[25].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[25].setFlipEnabled(false);
                FlipNum[25].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[26].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[26].setFlipEnabled(false);
                FlipNum[26].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[27].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[27].setFlipEnabled(false);
                FlipNum[27].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[28].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[28].setFlipEnabled(false);
                FlipNum[28].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[29].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipNum[29].setText(text);
                FlipText[29].setFlipEnabled(false);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[30].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[30].setFlipEnabled(false);
                FlipNum[30].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[31].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[31].setFlipEnabled(false);
                FlipNum[31].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[32].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[32].setFlipEnabled(false);
                FlipNum[32].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[33].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[33].setFlipEnabled(false);
                FlipNum[33].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[34].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[34].setFlipEnabled(false);
                FlipNum[34].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[35].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[35].setFlipEnabled(false);
                FlipNum[35].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[36].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[36].setFlipEnabled(false);
                FlipNum[36].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[37].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[37].setFlipEnabled(false);
                FlipNum[37].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[38].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[38].setFlipEnabled(false);
                FlipNum[38].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[39].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[39].setFlipEnabled(false);
                FlipNum[39].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[40].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[40].setFlipEnabled(false);
                FlipNum[40].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[41].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[41].setFlipEnabled(false);
                FlipNum[41].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[42].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[42].setFlipEnabled(false);
                FlipNum[42].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[43].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[43].setFlipEnabled(false);
                FlipNum[43].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[44].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[44].setFlipEnabled(false);
                FlipNum[44].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[45].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[45].setFlipEnabled(false);
                FlipNum[45].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[46].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[46].setFlipEnabled(false);
                FlipNum[46].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[47].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[47].setFlipEnabled(false);
                FlipNum[47].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[48].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[48].setFlipEnabled(false);
                FlipNum[48].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[49].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[49].setFlipEnabled(false);
                FlipNum[49].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[50].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[50].setFlipEnabled(false);
                FlipNum[50].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[51].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[51].setFlipEnabled(false);
                FlipNum[51].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[52].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[52].setFlipEnabled(false);
                FlipNum[52].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[53].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[53].setFlipEnabled(false);
                FlipNum[53].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[54].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[54].setFlipEnabled(false);
                FlipNum[54].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[55].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[55].setFlipEnabled(false);
                FlipNum[55].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[56].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[56].setFlipEnabled(false);
                FlipNum[56].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[57].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[57].setFlipEnabled(false);
                FlipNum[57].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[58].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[58].setFlipEnabled(false);
                FlipNum[58].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[59].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[59].setFlipEnabled(false);
                FlipNum[59].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[60].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[60].setFlipEnabled(false);
                FlipNum[60].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[61].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[61].setFlipEnabled(false);
                FlipNum[61].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[62].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[62].setFlipEnabled(false);
                FlipNum[62].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[63].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[63].setFlipEnabled(false);
                FlipNum[63].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[64].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[64].setFlipEnabled(false);
                FlipNum[64].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[65].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[65].setFlipEnabled(false);
                FlipNum[65].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[66].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[66].setFlipEnabled(false);
                FlipNum[66].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[67].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[67].setFlipEnabled(false);
                FlipNum[67].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[68].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[68].setFlipEnabled(false);
                FlipNum[68].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[69].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[69].setFlipEnabled(false);
                FlipNum[69].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[70].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[70].setFlipEnabled(false);
                FlipNum[70].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[71].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[71].setFlipEnabled(false);
                FlipNum[71].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[72].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[72].setFlipEnabled(false);
                FlipNum[72].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[73].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[73].setFlipEnabled(false);
                FlipNum[73].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[74].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[74].setFlipEnabled(false);
                FlipNum[74].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[75].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[75].setFlipEnabled(false);
                FlipNum[75].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[76].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[76].setFlipEnabled(false);
                FlipNum[76].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[77].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[77].setFlipEnabled(false);
                FlipNum[77].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });
        FlipText[78].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[78].setFlipEnabled(false);
                FlipNum[78].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });  FlipText[79].setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                String text = "" + getData();
                FlipText[79].setFlipEnabled(false);
                FlipNum[79].setText(text);
                ++NumCardFlipped;
                update(text);
            }
        });

    }
    public int getData() { //데이터 추출
        Collections.shuffle(Global.data);
        int returnData = (int)Global.data.get(0);
        Global.data.remove(0);
        sum += returnData;
        count++;
        Log.d("returnData", returnData+"");
        Log.d("sum",sum+"");
        Log.d("count", count+"");

        return returnData;
    }

    public void showAverage(int sum, int sumcount) {

        float total = Math.round((float)sum / (float)sumcount* 100) / 100;
        txt_average.setText(""+total);
    }

    public void show() {
        range.setText(Math.round(getFirstRange() * 100)/100.0 + "<= x <=" + Math.round(getSecondRange() * 100)/100.0+2);
    }

    public double getFirstRange() {
        return Global.average - 1.96 * (Global.diviation / Math.sqrt(Global.gettingDataSize));
    }
    public double getSecondRange() {
        return Global.average + 1.96 * (Global.diviation / Math.sqrt(Global.gettingDataSize));
    }
    public void update(String text){
        Global.gettingDataSize += 1;
        text_PickedCard.setText(NumCardFlipped+"");
        text_canPickCard.setText(Global.totalScore-NumCardFlipped+"");
        gettingData.add(text);

        Global.summ = Global.summ + Integer.parseInt(text);
        ++Global.sumcount;


        if (Global.totalScore-NumCardFlipped == 0){
            LastText.setText("모든 카드를 다 뽑았습니다! \n이제 모든 카드들의 진짜 평균을 추측하고 부스 운영자에게 추측한 답을 말해주세요!");
            String finalnum = "내가 뽑은 카드 :";
            for (int i = 0; i< gettingData.size(); i++){
                finalnum = finalnum + " "+gettingData.get(i);
            }
            txt.setText(finalnum);
            LastText.setGravity(View.TEXT_ALIGNMENT_CENTER);
            LastText.setTextColor(Color.argb(100, 243, 106, 3));
            hide1.setVisibility(GONE);
            space.setVisibility(View.VISIBLE);
            hide2.setVisibility(GONE);
            text_canPickCard.setVisibility(GONE);
            text_PickedCard.setVisibility(GONE);
            table.setVisibility(GONE);
        }

        showAverage(Global.summ,sumcount);
        show();
    }
    @Override public void onBackPressed() { //super.onBackPressed(); }
    }
}
