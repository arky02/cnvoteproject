package com.example.cnvoteproject.ViewPagerCards;

import android.graphics.Bitmap;

public class CardItem {

    private int mTextResource;
    private String mTitleResource;
    private Bitmap mImageResource;

    public CardItem(String title,Bitmap drawable) {
        mTitleResource = title;
        mImageResource = drawable;
    }

    public int getText() {
        return mTextResource;
    }
    public Bitmap getResources() {
        return mImageResource;
    }

    public String getTitle() {
        return mTitleResource;
    }
}
