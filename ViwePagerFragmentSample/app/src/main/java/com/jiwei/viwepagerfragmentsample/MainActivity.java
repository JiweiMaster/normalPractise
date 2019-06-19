package com.jiwei.viwepagerfragmentsample;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.jiwei.viwepagerfragmentsample.BottomNavigator.BottomNavigationViewHelper;
import com.jiwei.viwepagerfragmentsample.Viewpager.MainFragmentPagerAdapter;
import com.jiwei.viwepagerfragmentsample.jni.JniUtils;
import com.tencent.mmkv.MMKV;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
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
        mainViewPager.setOffscreenPageLimit(0);
        try {
            Log.e(TAG,"类名=>"+ViewPager.class.getName());
            Class clazz = Class.forName(ViewPager.class.getName());
            Field field = clazz.getDeclaredField("DEFAULT_OFFSCREEN_PAGES");
            field.setAccessible(true);
            field.set(mainViewPager,0);
            Log.e(TAG,"DEFAULT_OFFSCREEN_PAGES=>"+field.get(mainViewPager).toString());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG,e.toString());
        }
        mainViewPager.setCurrentItem(0);

        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainFragmentPagerAdapter);

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

//        Toast.makeText(this,""+Hello(),Toast.LENGTH_SHORT).show();
        Log.e(TAG,"jni=>"+ JniUtils.Hello());
    }


}
