package com.example.fragments_practice;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

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

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        if (savedInstanceState == null) {
            loadFragment();
        }
    }

    private void loadFragment() {
        if (getResources().getBoolean(R.bool.isTablet)) {
            loadFragmentForTabletDevices();
            return;
        }

        Log.d(TAG, "normal device fragment setup");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.USER_DATA_KEY,"user name details : john obi");
        fragmentTransaction.add(R.id.fragment_container_view , BookListFragment.class,bundle);
        fragmentTransaction.commit();
    }

    private void loadFragmentForTabletDevices() {
        //todo set up for tablet devices
        Log.d(TAG, "tablet device fragment setup");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.USER_DATA_KEY,"user name details : john obi");
        fragmentTransaction.add(R.id.container1 , BookListFragment.class,bundle);
        fragmentTransaction.add(R.id.container2 , BookDetailsFragment.class,bundle);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu , menu);
        return true;
    }
}