package com.example.saurabh.smc;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.saurabh.smc.ListModels.TestModel;
import com.example.saurabh.smc.adapter.TestCustomAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Create_Meeting extends AppCompatActivity {

//    private DatePicker datePicker;
    public static final String ARG_FROM_CREATE = "arg";
    private Calendar calendar;
    private TextView dateView;
//    private TextView dateView1;
    private TextView timeView;
    private int year, month, day, minute, hour;

    EditText ed;
    List<TestModel> ageanda;
    RecyclerView rv;
//    public static Button newdate;
//    boolean buttonpress = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__meeting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cre_meeting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Create Meeting");
//        dateView = (Button) findViewById(R.id.button1);
//        dateView1 = (Button) findViewById(R.id.pick_date);
        dateView = (TextView) findViewById(R.id.create_meeting_date_set);
        timeView = (TextView) findViewById(R.id.create_meeting_time_set);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
//        hour = calendar.get(Calendar.AM_PM);
        showDate(year, month + 1, day);
        showTime(hour, minute);


        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        Button add = (Button) findViewById(R.id.add_new_button) ;
        ed = (EditText) findViewById(R.id.editText_agenda);
        ed.setHint("Add an agenda");

        ageanda = new ArrayList<>();;

        final TestCustomAdapter adapter = new TestCustomAdapter(ageanda, new TestCustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TestModel item) {
                Intent openH = new Intent(Create_Meeting.this , AgendaDiscription.class);
                openH.putExtra("arg", item.getTitle());
                startActivity(openH);
            }
        });
        rv.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                adapter.add(new TestModel(ed.getText().toString(),false));
                ed.setText("");
                ed.setHint("Add an agenda");


            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
        //.show();
    }
    @SuppressWarnings("deprecation")
    public void setTime(View view) {
        showDialog(0);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        else if (id == 0) {
            return new TimePickerDialog(this, myTimeListener, hour, minute, true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        //        @Override
//        public void onTimeSet(TimePicker ar0, int ar1, int ar2){
//            showTime(ar1,ar2);
//        }
        public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
            showTime(arg1, arg2);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
//        dateView1.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }

    private void showTime(int hour, int minute) {
        String aMpM = "AM";
        if (hour > 11) {
            aMpM = "PM";
        }
        if (hour > 12) {
            hour = hour - 12;
        }
        if (hour >= 0 && hour < 10) {
            if (minute >= 0 && minute < 10) {
                timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                timeView.setText(new StringBuilder().append("0").append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        } else {
            if (minute >= 0 && minute < 10) {
                timeView.setText(new StringBuilder().append(hour).append(":")
                        .append("0").append(minute).append(" ").append(aMpM));
            } else {
                timeView.setText(new StringBuilder().append(hour).append(":")
                        .append(minute).append(" ").append(aMpM));
            }
        }
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
                return true;
            case R.id.action_favorite:

                return true;



        }



//        if (id == R.id.action_favorite) {
//            return true;
//        }
//        else if(id == android.R.id.home){
//            onBackPressed();
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
