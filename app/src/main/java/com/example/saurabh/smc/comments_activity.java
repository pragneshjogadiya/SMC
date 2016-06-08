package com.example.saurabh.smc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.saurabh.smc.ListModels.comment_item;
import com.example.saurabh.smc.adapter.CommentsCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 6/8/2016.
 */
public class comments_activity extends AppCompatActivity {
    View view;
    String[] names_of_commentator;
    String[] times_of_comments;
    String[] comments_texts;

    CommentsCustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_comments);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Comments");

        RecyclerView comments_rv = (RecyclerView) findViewById(R.id.comments_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        comments_rv.setLayoutManager(llm);

        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        comments_rv.setLayoutManager(llm1);

        List<Object> comment_list;
        comment_list = new ArrayList<>();

        names_of_commentator = getResources().getStringArray(R.array.name_of_persons);
        times_of_comments = getResources().getStringArray(R.array.time_of_comments);
        comments_texts = getResources().getStringArray(R.array.comment_texts);

        for (int i = 0; i < names_of_commentator.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            comment_item items = new comment_item(names_of_commentator[i],times_of_comments[i],comments_texts[i]);
            comment_list.add(items);
        }

        CommentsCustomAdapter adapter = new CommentsCustomAdapter(comment_list);
        comments_rv.setAdapter(adapter);



//        add.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//
//                adapter.add(new TestModel(ed.getText().toString(),false));
//                ed.setText("");
//                ed.setHint("Add a action");
//
//
//            }
//        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
                onBackPressed();
                finish();
                return true;
            case R.id.action_favorite:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

