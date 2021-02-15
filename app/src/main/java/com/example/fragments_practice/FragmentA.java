package com.example.fragments_practice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fragments_practice.databinding.FragmentALayoutBinding;

public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();
    private FragmentALayoutBinding mBinding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView called");
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_a_layout ,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated called");
    }
}
