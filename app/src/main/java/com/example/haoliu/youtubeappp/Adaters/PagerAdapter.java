package com.example.haoliu.youtubeappp.Adaters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.haoliu.youtubeappp.fragments.ChannelFragment;
import com.example.haoliu.youtubeappp.fragments.LiveFragment;
import com.example.haoliu.youtubeappp.fragments.PlayListFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int NumOfTabs;



    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.NumOfTabs = NumOfTabs;

    }

    @Override
    public Fragment getItem(int i) {

        switch(i) {
            case 0:
                ChannelFragment tab1 = new ChannelFragment();
                return tab1;
            case 1:
                PlayListFragment tab2 = new PlayListFragment();
                return tab2;
            case 2:
                LiveFragment tab3 = new LiveFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
