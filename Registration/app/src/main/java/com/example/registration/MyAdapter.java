package com.example.registration;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RegistrationPage1();

            case 1:
                return new RegistrationPage2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
