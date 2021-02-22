package com.example.fragments_practice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments_practice.databinding.BookListItemBinding;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookListViewHolder> {

    private Context mContext;
    private List<Book> mItems;
    private BookListItemBinding mBinding;
    private BookListenerInterface mListener;

    public BookListAdapter(Context mContext, List<Book> mItems, BookListenerInterface mListener) {
        this.mContext = mContext;
        this.mItems = mItems;
        this.mListener = mListener;
    }

    public interface BookListenerInterface{
        void onBookItemClicked(Book book , int position);
        void onBookFavoriteClicked(Book book , int position);
    }

    @NonNull
    @Override
    public BookListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.book_list_item, parent, false);
        return new BookListViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListViewHolder holder, int position) {
        holder.itemBinding.title.setText(mItems.get(position).getTitle());

        holder.itemBinding.author.setText(mItems.get(position).getAuthor());

        holder.itemBinding.publishedDate.setText(mItems.get(position).getPublishedDate());

        holder.itemBinding.favorite.setImageDrawable(getIsFavoriteDrawable(mItems.get(position).isFavourite()));
    }

    private Drawable getIsFavoriteDrawable(boolean isFavorite) {
        if (isFavorite) {
           return ResourcesCompat.getDrawable(mContext.getResources(),R.drawable.ic_favorite_on,null);
        }
        return ResourcesCompat.getDrawable(mContext.getResources(),R.drawable.ic_favorite_off,null);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setItems(List<Book> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void updateFavoriteItem(int position) {
        notifyItemChanged(position);
    }

    public class BookListViewHolder extends RecyclerView.ViewHolder {
        private BookListItemBinding itemBinding;



        public BookListViewHolder(@NonNull BookListItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;

            itemBinding.favorite.setOnClickListener(v ->
                    mListener.onBookFavoriteClicked(mItems.get(getAdapterPosition()),getAdapterPosition()));

            itemBinding.bookItemContainer.setOnClickListener(v ->
                    mListener.onBookItemClicked(mItems.get(getAdapterPosition()),getAdapterPosition()));
        }
    }
}
