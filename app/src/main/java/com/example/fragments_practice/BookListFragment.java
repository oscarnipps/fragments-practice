package com.example.fragments_practice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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

        mBinding.bookListToolbar.inflateMenu(R.menu.menu_book_list);

        mBinding.bookListToolbar.setOverflowIcon(ResourcesCompat.getDrawable(getResources(),R.drawable.ic_delete,null));

        mBinding.bookListToolbar.setOnMenuItemClickListener(item -> {

            switch (item.getItemId()) {
                case R.id.delete:
                    Toast.makeText(requireContext(), "delete items", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.sync:
                    Toast.makeText(requireContext(), "sync items", Toast.LENGTH_SHORT).show();
                    return true;

                default:
                    return false;
            }

        });



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
        setHasOptionsMenu(true);
        Log.d(TAG, "fragment BookList onCreate called");
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
    public void onStop() {
        super.onStop();
        Log.d(TAG, "fragment BookList onStop called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "fragment BookList onPause called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "fragment BookList onResume called");
    }

    @Override
    public void onBookItemClicked(Book book, int position) {
        Toast.makeText(requireContext(), book.getTitle() , Toast.LENGTH_SHORT).show();
        FragmentTransaction fragmentTransaction =  getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, new BookDetailsFragment());
        fragmentTransaction.setReorderingAllowed(true);
        Bundle result = new Bundle();
        result.putParcelable(Const.BOOK_ITEM_PARCELABLE_KEY,book);
        getParentFragmentManager().setFragmentResult(Const.BOOK_DETAILS_RESULT_KEY,result);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBookFavoriteClicked(Book book, int position) {
        Toast.makeText(requireContext(), book.getTitle() + " added to favourites", Toast.LENGTH_SHORT).show();
        book.setFavourite(book.isFavourite() ? false : true);
        mAdapter.updateFavoriteItem(position);
    }
}
