package com.example.miwokapp;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    private Context mContext;


    public FragmentPagerAdapter(Context context, FragmentManager fm) {
        // Required empty public constructor
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.numbers_label);
        } else if (position == 1) {
            return mContext.getString(R.string.family_label);
        } else if (position == 2) {
            return mContext.getString(R.string.colors_label);
        } else {
            return mContext.getString(R.string.phrases_label);
        }
    }
}
