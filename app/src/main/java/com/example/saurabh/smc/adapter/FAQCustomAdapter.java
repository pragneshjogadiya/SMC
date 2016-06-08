package com.example.saurabh.smc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.FaqModel;
import com.example.saurabh.smc.ListModels.FaqModel_new;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 6/2/2016.
 */
public class FAQCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int user =0,image=1;

    List<Object> qanda;

    public static class QAViewHolder extends RecyclerView.ViewHolder {

        TextView faq_meeting_name;
        TextView faq_meeting_agenda;
        TextView date;
        TextView month;

        QAViewHolder(View v) {
            super(v);
            this.faq_meeting_name = (TextView) v.findViewById(R.id.FAQ_meeting_number);
            this.faq_meeting_agenda = (TextView) v.findViewById(R.id.FAQ_meeting_agenda);
            this.date = (TextView) v.findViewById(R.id.FAQ_meeting_date);
            this.month = (TextView) v.findViewById(R.id.FAQ_meeting_month);
        }
    }
    public static class QAViewHolder_new extends RecyclerView.ViewHolder {

        TextView upcoming_meeting;

        QAViewHolder_new(View v) {
            super(v);
            this.upcoming_meeting = (TextView) v.findViewById(R.id.upcoming_meetings);
        }
    }
    public FAQCustomAdapter(List<Object> qanda){
        this.qanda = qanda;
    }

    @Override
    public int getItemCount() {
        return qanda.size();
    }

    public int getItemViewType(int position){
        if(qanda.get(position) instanceof FaqModel){
            return user;
        }

        if(qanda.get(position) instanceof FaqModel_new){
            return image;
        }

        return -1;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        RecyclerView.ViewHolder qavh ;

        switch (i){
            case user:
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.faq_item,viewGroup,false);
                qavh = new QAViewHolder(v1);
                break;
            case image:
                View v2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.faq_item_2,viewGroup,false);
                qavh = new QAViewHolder_new(v2);
                break;
            default:
                View v3 = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                qavh = new QAViewHolder(v3);
                break;
        }
        return qavh;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder qaViewHolder, int position) {

        switch (qaViewHolder.getItemViewType()) {
            case user:
                QAViewHolder fm1 = (QAViewHolder) qaViewHolder;
                configureQAViewHolder1(fm1, position);
                break;

            case image:
                QAViewHolder_new fm2 = (QAViewHolder_new) qaViewHolder;
                configureQAViewHolder2(fm2, position);
                break;

            default:
                QAViewHolder fm3 = (QAViewHolder) qaViewHolder;
                configureDefaultViewHolder(fm3, position);
                break;
        }
    }

    private void configureQAViewHolder1(QAViewHolder fm1,int position) {
        FaqModel faq = (FaqModel) qanda.get(position);
        if (faq != null) {
            fm1.faq_meeting_name.setText(faq.getFaq_meeting_name());
            fm1.faq_meeting_agenda.setText(faq.getFaq_meeting_agenda());
            fm1.date.setText(faq.getDate());
            fm1.month.setText(faq.getMonth());

        }
    }

    private void configureQAViewHolder2(QAViewHolder_new fm2,int position) {
        FaqModel_new faqNew = (FaqModel_new) qanda.get(position);
        if (faqNew != null) {
            fm2.upcoming_meeting.setText(faqNew.getUpcoming_meeting());

        }
    }

    private void configureDefaultViewHolder(QAViewHolder fm3,int position) {
        FaqModel faq3 = (FaqModel) qanda.get(position);
        if (faq3 != null) {
            fm3.faq_meeting_name.setText(faq3.getFaq_meeting_name());

        }
    }

//        qaViewHolder.Q.setText(qanda.get(i).getQ());
//        qaViewHolder.A.setText("In the agenda"+qanda.get(i).getA());
//        String temp = qanda.get(i).getDate();
//        if(temp.length() == 1){
////            String temp = "0" + temp.getMeetingDate();
////            holder.meetingDate.setText(temp);
//            qaViewHolder.date.setText("0"+qanda.get(i).getDate());
//        }
//        else {
//            qaViewHolder.date.setText(qanda.get(i).getDate());
//        }
//
//        qaViewHolder.month.setText(qanda.get(i).getMonth());



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
