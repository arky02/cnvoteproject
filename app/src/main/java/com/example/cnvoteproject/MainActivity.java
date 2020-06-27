package com.example.cnvoteproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.cnvoteproject.ViewPagerCards.CardItem;
import com.example.cnvoteproject.ViewPagerCards.CardPagerAdapter;
import com.example.cnvoteproject.ViewPagerCards.ShadowTransformer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    List data = new ArrayList();
    private ViewPager mViewPager;
    Bitmap image, resize_image, image1, image2, image3, image4,image5, image6;
    ImageView btn_data;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_main);

        btn_data = findViewById(R.id.btn_data);

        image1 = BitmapFactory.decodeResource(getResources(), R.drawable.q1_1);
        image2 = BitmapFactory.decodeResource(getResources(), R.drawable.q2_1);
        image3 = BitmapFactory.decodeResource(getResources(), R.drawable.q3_1);
        image4 = BitmapFactory.decodeResource(getResources(), R.drawable.q4_1);
        image5 = BitmapFactory.decodeResource(getResources(), R.drawable.q5_1);
        image6 = BitmapFactory.decodeResource(getResources(), R.drawable.q6_1);

        image = BitmapFactory.decodeResource(getResources(), R.drawable.sucess);

        btn_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), AlertActivity.class);
                startActivity(intent1);
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, image1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, image2));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, image3));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, image4));
        mCardAdapter.addCardItem(new CardItem(R.string.title_5, image5));
        mCardAdapter.addCardItem(new CardItem(R.string.title_6, image6));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);

        mViewPager.setAdapter(mCardAdapter); //mFragmentCardAdapter사용 X, mCardAdapter사용
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mCardShadowTransformer.enableScaling(true);

    }

    @Override
    public void onBackPressed() {
        //
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}