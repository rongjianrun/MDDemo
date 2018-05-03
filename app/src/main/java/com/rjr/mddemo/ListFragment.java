package com.rjr.mddemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.rjr.mddemo.adapter.ListAdapter;

import java.util.Collections;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/3.
 */

public class ListFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    private Activity mActivity;
    private ListAdapter adapter;

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void init() {
        rv.setLayoutManager(new GridLayoutManager(mActivity, 2));
        adapter = new ListAdapter(mActivity);
        rv.setAdapter(adapter);
        new ItemTouchHelper(new ItemTouchCallback()).attachToRecyclerView(rv);
    }

    class ItemTouchCallback extends ItemTouchHelper.Callback {

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END;
            int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.onItemDismiss(viewHolder.getAdapterPosition());
        }
    }
}
