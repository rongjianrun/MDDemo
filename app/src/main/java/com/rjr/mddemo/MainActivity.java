package com.rjr.mddemo;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.MenuItem;
import android.widget.Toast;

import com.rjr.mddemo.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.vp)
    ViewPager vp;

    private Unbinder unbinder;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setEnterTransition(new Explode()); // 设置退场动画
        getWindow().setExitTransition(new Slide()); // 设置进场动画

        unbinder = ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        List<BaseFragment> list = new ArrayList<>();
        list.add(ListFragment.newInstance());
        list.add(MyFragment.newInstance(FragmentType.TYPE_2));
        list.add(MyFragment.newInstance(FragmentType.TYPE_3));
        list.add(MyFragment.newInstance(FragmentType.TYPE_4));
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager(), list));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int itemId = navigation.getMenu().getItem(position).getItemId();
                navigation.setSelectedItemId(itemId);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
