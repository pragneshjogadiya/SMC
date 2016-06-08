package com.example.saurabh.smc.ListModels;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.saurabh.smc.R;

/**
 * Created by user on 6/3/2016.
 */
public class FaqModel_new{
    String upcoming_meeting;


    public FaqModel_new(String upcoming_meeting) {
        this.upcoming_meeting = upcoming_meeting;
    }

    public String getUpcoming_meeting() {
        return upcoming_meeting;
    }

    public void setUpcoming_meeting(String upcoming_meeting) {
        this.upcoming_meeting = upcoming_meeting;
    }
}
