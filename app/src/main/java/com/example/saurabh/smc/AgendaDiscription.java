package com.example.saurabh.smc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabh.smc.ListModels.TestModel;
import com.example.saurabh.smc.adapter.TestCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 6/6/2016.
 */
public class AgendaDiscription extends AppCompatActivity {
    String stitle = "Type here";
    EditText title;
    EditText ed;
    List<TestModel> actions;
    public static final String ARG_FROM_Agenda = "arg";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_discription);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_agenda_dis);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Agenda Description");
        if(getIntent().getExtras() != null) {
            stitle = getIntent().getExtras().getString("arg");
        }


        title = (EditText) findViewById(R.id.agenda_disc_titleeditText);
        title.setText(stitle);

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        Button add = (Button) findViewById(R.id.add_new_button) ;
        ed = (EditText) findViewById(R.id.editText_agenda);
        ed.setHint("Add an action");

        actions = new ArrayList<>();;

        final TestCustomAdapter adapter = new TestCustomAdapter(actions, new TestCustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TestModel item) {
                Intent openH = new Intent(AgendaDiscription.this , ActionDiscription.class);
                openH.putExtra("arg", item.getTitle());
                startActivity(openH);
            }
        });
        rv.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                adapter.add(new TestModel(ed.getText().toString(),false));
                ed.setText("");
                ed.setHint("Add an action");


            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.doneaction, menu);
        return true;
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
    public void showComment(View view){
        Intent openH = new Intent(AgendaDiscription.this , comments_activity.class);

        startActivity(openH);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
