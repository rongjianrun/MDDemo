package com.rjr.mddemo.adapter;

/**
 * Created by Administrator on 2018/5/3.
 */

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
