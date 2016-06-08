package com.example.saurabh.smc.fragements;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.ViewPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class homepage_tabs extends Fragment {

    View view;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    AppBarLayout appBarLayout;

    private int[] tabIcons = {
            R.drawable.ic_event_note_white_36dp,
            R.drawable.ic_notifications_active_white_36dp,
            R.drawable.ic_public_white_36dp,
            R.drawable.ic_forum_white_36dp
    };

    public homepage_tabs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_homepage_tabs, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();


        // activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) inflater.inflate(R.layout.tablay, null);
        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.appbar);
        appBarLayout.addView(tabLayout, new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();



        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Meeting Management App");
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new meeting(), "JOBS");
        adapter.addFragment(new Jobs(), "FEEDS");
        adapter.addFragment(new Jobs(), "DISCUSSIONS");
        adapter.addFragment(new Jobs(), "DISCUSSIONS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDetach() {
        appBarLayout.removeView(tabLayout);
        super.onDetach();
    }

}
