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

import com.example.fragments_practice.databinding.FragmentBookDetailsBinding;

public class BookDetailsFragment extends Fragment {


    private static final String TAG = BookDetailsFragment.class.getSimpleName();
    private FragmentBookDetailsBinding mBinding;
    private Book mBook;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "fragment BooKDetails onCreateView called");
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_details, container, false);
        Log.d(TAG, "book item in onCreateView is : " + mBook);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "fragment BooKDetails onCreate called");

        //the result call back is called when the fragment is in the STARTED state ( onResume is called )
        getParentFragmentManager().setFragmentResultListener(Const.BOOK_DETAILS_RESULT_KEY, this, (requestKey, result) -> {
            mBook = result.getParcelable(Const.BOOK_ITEM_PARCELABLE_KEY);
            Log.d(TAG, "book item retrieved with value : " + mBook);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "fragment BooKDetails onStart called");
        Log.d(TAG, "current lifecycle state " + getLifecycle().getCurrentState());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "fragment BooKDetails onPause called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "book item in onResume is : " + mBook);
        Log.d(TAG, "fragment BooKDetails onResume called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "fragment BooKDetails onSaveInstanceState called");
    }
}
