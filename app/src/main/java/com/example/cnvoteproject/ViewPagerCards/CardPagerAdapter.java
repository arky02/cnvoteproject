package com.example.cnvoteproject.ViewPagerCards;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cnvoteproject.Global;
import com.example.cnvoteproject.Problems.Problem5Activity;
import com.example.cnvoteproject.Problems.Problem4Activity;
import com.example.cnvoteproject.Problems.Problem1Activity;
import com.example.cnvoteproject.Problems.Problem6Activity;
import com.example.cnvoteproject.Problems.Problem3Activity;
import com.example.cnvoteproject.Problems.Problem2Activity;
import com.example.cnvoteproject.R;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;
    Button btn;


    public CardPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(CardItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }



    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);
        bind(mData.get(position),view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Log.d("0", "0");
                        Intent mintent = new Intent(view.getContext(), Problem1Activity.class);
//                        mintent.putExtra("probNum", "1");
                        view.getContext().startActivity(mintent);
                        break;
                    case 1:
                        Log.d("0", "1");
                        Intent mintent1 = new Intent(view.getContext(), Problem2Activity.class);
                        view.getContext().startActivity(mintent1);
                        break;
                    case 2:
                        Log.d("0", "2");
                        Intent mintent2 = new Intent(view.getContext(), Problem3Activity.class);
                        view.getContext().startActivity(mintent2);
                        break;
                    case 3:
                        Log.d("0", "3");
                        Intent mintent3 = new Intent(view.getContext(), Problem4Activity.class);
                        view.getContext().startActivity(mintent3);
                        break;
                    case 4:
                        Log.d("0", "4");
                        Intent mintent4 = new Intent(view.getContext(), Problem5Activity.class);
                        view.getContext().startActivity(mintent4);
                        break;
                    case 5:
                        Log.d("0", "5");
                        Intent mintent5 = new Intent(view.getContext(), Problem6Activity.class);
                        view.getContext().startActivity(mintent5);
                        break;
                    case 6:
                        if (Global.isActivity) {
                            //enable
                            break;
                        }


                }

            }
        });


        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageBitmap(item.getResources());
        titleTextView.setText(item.getTitle());
    }
}
