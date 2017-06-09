package com.pullein.circle.home;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xugang on 2017/6/9.
 */

public class AdapterWrapper<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BASE_ITEM_TYPE_HEADER = 10000 << 4;
    private static final int BASE_ITEM_TYPE_FOOTER = 20000 << 4;

    private SparseArrayCompat<View> mHeaderView = new SparseArrayCompat<>();
    private SparseArrayCompat<View> mFootView = new SparseArrayCompat<>();

    private RecyclerView.Adapter mInnerAdapter;

    public AdapterWrapper(RecyclerView.Adapter mInnerAdapter) {
        this.mInnerAdapter = mInnerAdapter;
    }

    private boolean isHeaderViewPos(int position) {
        return position < getHeaderCount();
    }

    private boolean isFooterViewPos(int position) {
        return position >= getHeaderCount() + getRealItemCount();
    }

    public void addHeaderView(View view) {
        mHeaderView.put(mHeaderView.size() + BASE_ITEM_TYPE_HEADER, view);
    }

    public void addFootView(View view) {
        mFootView.put(mFootView.size() + BASE_ITEM_TYPE_FOOTER, view);
    }

    private int getRealItemCount() {
        return 0;
    }

    private int getHeaderCount() {
        return mHeaderView.size();
    }

    private int getFootCount() {
        return mFootView.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
