package com.example.saurabh.smc.ListModels;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.saurabh.smc.R;

/**
 * Created by Saurabh on 6/2/2016.
 */
public class FaqModel{

        String faq_meeting_name;
        String faq_meeting_agenda;
        String date;
        String month;


       public FaqModel(String faq_meeting_name,String faq_meeting_agenda,String date, String month) {
           this.faq_meeting_name = faq_meeting_name;
           this.faq_meeting_agenda = faq_meeting_agenda;
           this.date = date;
           this.month = month;
        }

    public String getFaq_meeting_name(){
        return faq_meeting_name;
    }
    public String getFaq_meeting_agenda(){
        return faq_meeting_agenda;
    }
    public String getDate(){
        return date;
    }
    public String getMonth(){
        return month;
    }

    public void setFaq_meeting_name(String faq_meeting_name){
        this.faq_meeting_name = faq_meeting_name;
    }
    public void setFaq_meeting_agenda(String faq_meeting_agenda){
        this.faq_meeting_agenda = faq_meeting_agenda;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setMonth(String month){
        this.month = month;
    }




}
