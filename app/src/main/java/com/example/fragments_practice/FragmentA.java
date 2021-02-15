package com.example.fragments_practice;

import android.content.Context;
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
        Log.d(TAG, "onCreateView called");
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_a_layout ,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "fragment onViewCreated called");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "fragment onAttach called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "fragment onCreate called");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "fragment onViewStateRestored called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "fragment onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "fragment onResume called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "fragment onSaveInstanceState called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "fragment onPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "fragment onStop called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "fragment onDestroyView called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "fragment onDestroy called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "fragment onDetach called");
    }
}
