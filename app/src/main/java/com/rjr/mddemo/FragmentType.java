package com.rjr.mddemo;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Administrator on 2018/5/3.
 */

@IntDef({FragmentType.TYPE_1, FragmentType.TYPE_2, FragmentType.TYPE_3, FragmentType.TYPE_4})
@Retention(RetentionPolicy.SOURCE)
public @interface FragmentType {

    int TYPE_1 = 0;
    int TYPE_2 = 1;
    int TYPE_3 = 2;
    int TYPE_4 = 3;
}
