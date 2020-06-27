package com.example.cnvoteproject.ViewPagerCards;

import android.graphics.Bitmap;

public class CardItem {

    private int mTextResource;
    private int mTitleResource;
    private Bitmap mImageResource;

    public CardItem(int title,Bitmap drawable) {
        mTitleResource = title;
        mImageResource = drawable;
    }

    public int getText() {
        return mTextResource;
    }
    public Bitmap getResources() {
        return mImageResource;
    }

    public int getTitle() {
        return mTitleResource;
    }
}
