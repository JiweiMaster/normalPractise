package com.jiwei.viwepagerfragmentsample;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.jiwei.viwepagerfragmentsample.BottomNavigator.BottomNavigationViewHelper;
import com.jiwei.viwepagerfragmentsample.Viewpager.MainFragmentPagerAdapter;
import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BottomNavigationMenuView menuView;

    MainFragmentPagerAdapter mainFragmentPagerAdapter;
    ViewPager mainViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MMKV.initialize(this);
        MMKV mmkv = MMKV.defaultMMKV();
        mmkv.putString("fragment1","1");
        mmkv.putString("fragment2","2");
        mmkv.putString("fragment3","3");
        mmkv.putString("fragment4","4");
        bottomNavigationView = this.findViewById(R.id.bottomNavigationView);
        mainViewPager = this.findViewById(R.id.mainViewPager);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        BottomNavigationViewHelper.setBottomNavigationColor(this,bottomNavigationView);

        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainFragmentPagerAdapter);
        mainViewPager.setOffscreenPageLimit(3);
        mainViewPager.setCurrentItem(0);

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int[] idArray = new int[]{R.id.scan,R.id.navigator,R.id.duty,R.id.my};
                bottomNavigationView.setSelectedItemId(idArray[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
                switch (item.getItemId()){
                    case R.id.scan:
                        mainViewPager.setCurrentItem(0);
                        break;
                    case R.id.navigator:
                        mainViewPager.setCurrentItem(1);
                        break;
                    case R.id.duty:
                        mainViewPager.setCurrentItem(2);
                        break;
                    case R.id.my:
                        mainViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
                switch (item.getItemId()){
                    case R.id.scan:
                        mainViewPager.setCurrentItem(0);
                        break;
                    case R.id.navigator:
                        mainViewPager.setCurrentItem(1);
                        break;
                    case R.id.duty:
                        mainViewPager.setCurrentItem(2);
                        break;
                    case R.id.my:
                        mainViewPager.setCurrentItem(3);
                        break;
                }
            }
        });

    }
}
