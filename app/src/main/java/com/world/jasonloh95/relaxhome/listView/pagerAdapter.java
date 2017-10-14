package com.world.jasonloh95.relaxhome.listView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by JasonLoh95 on 10/10/2017.
 */

public class pagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    public pagerAdapter (FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return fragments.size();
    }

    public void addFragment(Fragment f){
        fragments.add(f);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title= fragments.get(position).toString();
        return title.toString();
    }
}
