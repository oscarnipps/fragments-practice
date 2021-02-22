package com.example.fragments_practice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments_practice.databinding.FragmentBookListBinding;

import java.util.List;

public class BookListFragment extends Fragment implements BookListAdapter.BookListenerInterface {

    private static final String TAG = BookListFragment.class.getSimpleName();
    private FragmentBookListBinding mBinding;
    private List<Book> mItems;
    private RecyclerView mRecyclerView;
    private BookListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "fragment BookList onCreateView called");
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_list, container, false);
        initializeRecyclerView();
        return mBinding.getRoot();
    }

    private void initializeRecyclerView() {
        mAdapter = new BookListAdapter(requireContext(), BookRepo.getBookList(), this);
        mRecyclerView = mBinding.recyclerview;
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "fragment BookList onStart called");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "fragment BookList onSaveInstanceState called");
    }


    @Override
    public void onBookItemClicked(Book book, int position) {
        Toast.makeText(requireContext(), book.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBookFavoriteClicked(Book book, int position) {
        Toast.makeText(requireContext(), book.getTitle() + " added to favourites", Toast.LENGTH_SHORT).show();
        book.setFavourite(book.isFavourite());
        mAdapter.updateFavoriteItem(position);
    }
}
