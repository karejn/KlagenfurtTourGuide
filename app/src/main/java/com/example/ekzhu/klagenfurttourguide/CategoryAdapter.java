package com.example.ekzhu.klagenfurttourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MuseumsFragment();
            case 1:
                return new DrinkingFragment();
            case 2:
                return new EatingFragment();
            case 3:
                return new ShoppingFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.museums_tab);
            case 1:
                return mContext.getString(R.string.drinking_tab);
            case 2:
                return mContext.getString(R.string.eating_tab);
            case 3:
                return mContext.getString(R.string.shopping_tab);
        }
        return null;
    }
}
