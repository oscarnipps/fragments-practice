package com.example.fragments_practice;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragments_practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Log.d(TAG, "activity onCreate");

            mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.USER_DATA_KEY,"user name details : john obi");
            fragmentTransaction.add(R.id.fragment_container_view , BookListFragment.class,bundle);
            fragmentTransaction.commit();
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "activity onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "activity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "activity onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "activity onDestroy");
    }
}