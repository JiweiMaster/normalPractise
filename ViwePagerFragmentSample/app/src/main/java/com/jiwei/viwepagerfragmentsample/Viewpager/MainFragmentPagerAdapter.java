package com.jiwei.viwepagerfragmentsample.Viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.jiwei.viwepagerfragmentsample.Viewpager.fragment.Fragment2;
import com.jiwei.viwepagerfragmentsample.Viewpager.fragment.Fragment1;
import com.jiwei.viwepagerfragmentsample.Viewpager.fragment.Fragment3;
import com.jiwei.viwepagerfragmentsample.Viewpager.fragment.Fragment4;


/**
 * Created by 18099 on 2018/12/29.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 4;

    public static Fragment1 fragment1 = null;
    public static Fragment2 fragment2 = null;
    public static Fragment3 fragment3 = null;
    public static Fragment4 fragment4 = null;

    public MainFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        fragment1 = new Fragment1();
        fragment2= new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            //检测MainActivity的数值进行判断，返回的fragment
            case 0:
                fragment = fragment1;
                break;
            case 1:
                fragment = fragment2;
                break;
            case 2:
                fragment = fragment3;
                break;
            case 3:
                fragment = fragment4;
                break;
        }
        return fragment;
    }

}
