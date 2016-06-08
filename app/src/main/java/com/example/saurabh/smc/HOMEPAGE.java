package com.example.saurabh.smc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.saurabh.smc.fragements.ActionFragment;
import com.example.saurabh.smc.fragements.FAQ;
import com.example.saurabh.smc.fragements.MemberFragment;
import com.example.saurabh.smc.fragements.MyListFragment;
import com.example.saurabh.smc.fragements.TestFragment;
import com.example.saurabh.smc.fragements.homepage_tabs;
import com.example.saurabh.smc.fragements.meeting;

public class HOMEPAGE extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean logout_press = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Meeting Management App");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        homepage_tabs fragment = new homepage_tabs();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

        android.support.v4.app.FragmentTransaction fragmentTransaction =
                this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.nav_homepage) {
           homepage_tabs fragment = new homepage_tabs();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();
        } else if (id == R.id.nav_actions) {
           ActionFragment fragment = new ActionFragment();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();



        } else if (id == R.id.nav_meeting) {
           setTitle("Meetings");
           meeting fragment = new meeting();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();

        } else if (id == R.id.nav_myschools) {
           MyListFragment fragment = new MyListFragment();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();

        } else if (id == R.id.nav_FAQ) {

           FAQ fragment = new FAQ();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();

        } else if (id == R.id.nav_settings) {

           TestFragment fragment = new TestFragment();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();

        } else if (id == R.id.nav_smc_mem) {

           MemberFragment fragment = new MemberFragment();
           /* Bundle b=new Bundle();
            b.putInt("id",0);
            fragment.setArguments(b);
            //fragment.setArguments();*/

           android.support.v4.app.FragmentTransaction fragmentTransaction =
                   this.getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.frame_container,fragment);
           fragmentTransaction.commit();

       }
       else if (id == R.id.nav_logout) {
           logout_press = true;
           Intent openH = new Intent(this, LOGIN.class);
           startActivityForResult(openH,0);
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(logout_press == true){
            finish();
        }

    }
}
