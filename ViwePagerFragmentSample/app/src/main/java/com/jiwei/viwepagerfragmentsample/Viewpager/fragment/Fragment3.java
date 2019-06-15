package com.jiwei.viwepagerfragmentsample.Viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiwei.viwepagerfragmentsample.R;
import com.tencent.mmkv.MMKV;

/**
 * Created by 18099 on 2019/6/14.
 */

public class Fragment3 extends Fragment {
    String TAG = "Fragment3";
    MMKV mmkv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment3,
                container, false);
        mmkv = MMKV.defaultMMKV();
        Log.e(TAG,mmkv.getString("fragment3",""));
        return view;
    }
}
