package com.example.advanceview.Tablayout.Tablayouts;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerMessagerAdpter extends FragmentPagerAdapter    {
    public ViewpagerMessagerAdpter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChatFragment();

        } else if (position == 1) {
            return new SatausFragment();
        } else {
            return new CallsFragment();
        }


    }

    @Override
    public int getCount() {
        return 3;//no of tabs ketla fragment  joy che
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Chats";
        } else if (position == 1) {
            return "Status";
        } else {
            return "Calls";
        }


    }
    
}
