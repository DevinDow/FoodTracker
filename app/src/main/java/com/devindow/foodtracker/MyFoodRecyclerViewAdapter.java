package com.devindow.foodtracker;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Food}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFoodRecyclerViewAdapter extends RecyclerView.Adapter<MyFoodRecyclerViewAdapter.ViewHolder> {

    private final SortedList<Food> mValues;

    public MyFoodRecyclerViewAdapter(SortedList<Food> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDaysView.setText(mValues.get(position).getDaysString());
        holder.mContentView.setText(mValues.get(position).name);
        holder.mFridgeView.setText(String.format("%d", mValues.get(position).quantityFridge));
        holder.mFreezerView.setText(String.format("%d", mValues.get(position).quantityFreezer));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mDaysView;
        public final TextView mContentView;
        public final TextView mFridgeView;
        public final TextView mFreezerView;
        public Food mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mDaysView = (TextView) view.findViewById(R.id.days);
            mContentView = (TextView) view.findViewById(R.id.content);
            mFridgeView = (TextView) view.findViewById(R.id.fridge);
            mFreezerView = (TextView) view.findViewById(R.id.freezer);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}