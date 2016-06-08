package com.example.saurabh.smc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//
//import com.example.saurabh.smc.ListModels.FaqModel;
//import com.example.saurabh.smc.ListModels.FaqModel_new;

import com.example.saurabh.smc.Create_Meeting;
import com.example.saurabh.smc.ListModels.Meeting_Items;
import com.example.saurabh.smc.ListModels.TestModel;
import com.example.saurabh.smc.ListModels.meeting_Item_status;
import com.example.saurabh.smc.R;

import java.util.List;


/**
 * Created by user on 5/27/2016.
 */
public class MeetingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

//    Context context;
    private final int status =0,meetings=1;
//    Meeting_Items tempValues=null;
//    public int num;
    //    RowItem tempValue1=null;
    List<Object> meetingItems;
    OnItemClickListener meeting_listener;
//    List<RowItem> rowItem1;

    public interface OnItemClickListener {
        void onItemClick(Meeting_Items item);
    }

//    public MeetingAdapter(List<Object> meetingItems) {
//        this.meetingItems = meetingItems;
////        this.rowItem1 = rowItem1;
//
//    }
    public MeetingAdapter(List<Object> meetingItems, OnItemClickListener meeting_listener){
        this.meetingItems = meetingItems;
        this.meeting_listener = meeting_listener;
    }

    public static class Meeting_Status_Holder extends RecyclerView.ViewHolder {

        TextView meeting_status;

        Meeting_Status_Holder(View v) {
            super(v);
            this.meeting_status = (TextView) v.findViewById(R.id.meetings_status);
        }
    }


    public static class Meeting_Holder extends RecyclerView.ViewHolder {

        TextView meeting_number_title;
        TextView meeting_agenda;
        TextView meeting_date;
        TextView meeting_month;

        Meeting_Holder(View v) {
            super(v);
            this.meeting_number_title = (TextView) v.findViewById(R.id.meeting_number);
            this.meeting_agenda = (TextView) v.findViewById(R.id.meeting_agenda);
            this.meeting_date = (TextView) v.findViewById(R.id.meeting_date);
            this.meeting_month = (TextView) v.findViewById(R.id.meeting_month);
        }

        public void bind1(final Meeting_Items item, final OnItemClickListener meeting_listener) {


            meeting_number_title.setText(item.getMeeting_number());
            meeting_agenda.setText(item.getAgenda());
            meeting_date.setText(item.getMeetingDate());
            meeting_month.setText(item.getMeetingMonth());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    meeting_listener.onItemClick(item);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return meetingItems.size();
    }

    public int getItemViewType(int position){
        if(meetingItems.get(position) instanceof meeting_Item_status){
            return status;
        }

        if(meetingItems.get(position) instanceof Meeting_Items){
            return meetings;
        }

        return -1;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        RecyclerView.ViewHolder meeting_holder ;

        switch (position){
            case status:
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meeting_status,viewGroup,false);
                meeting_holder = new Meeting_Status_Holder(v1);
                break;
            case meetings:
                View v2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_meeting,viewGroup,false);
                meeting_holder = new Meeting_Holder(v2);
                break;
            default:
                View v3 = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                meeting_holder = new Meeting_Status_Holder(v3);
                break;
        }
        return meeting_holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder meeting_ViewHolder, int position) {

        final int temp = position;

        switch (meeting_ViewHolder.getItemViewType()) {
            case status:
                Meeting_Status_Holder fm1 = (Meeting_Status_Holder) meeting_ViewHolder;
                configureMeetingViewHolder1(fm1, position);
                break;

            case meetings:
                Meeting_Holder fm2 = (Meeting_Holder) meeting_ViewHolder;
                configureMeetingViewHolder2(fm2, position);
                Meeting_Items nmi = (Meeting_Items) meetingItems.get(position);
                fm2.bind1(nmi, meeting_listener);
//                qaViewHolder.b.setOnClickListener(new View.OnClickListener(){
//                    public void onClick(View v){
//                        Intent openH = new Intent(getContext(), Create_Meeting.class);
//                        startActivity(openH);
//                    }
//                });

                break;

            default:
                Meeting_Status_Holder fm3 = (Meeting_Status_Holder) meeting_ViewHolder;
                configureDefaultMeetingViewHolder(fm3, position);
                break;
        }
    }

    private void configureMeetingViewHolder1(Meeting_Status_Holder fm1,int position) {
        meeting_Item_status temp = (meeting_Item_status) meetingItems.get(position);
        if (temp != null) {
            fm1.meeting_status.setText(temp.getMeeting_status());
        }
    }

    private void configureMeetingViewHolder2(Meeting_Holder fm2,int position) {
        Meeting_Items temp1 = (Meeting_Items) meetingItems.get(position);
        if (temp1 != null) {
            fm2.meeting_number_title.setText(temp1.getMeeting_number());
            fm2.meeting_agenda.setText(temp1.getAgenda());
            if(temp1.getMeetingDate().length() == 1){
                String temp4 = "0" + temp1.getMeetingDate();
                fm2.meeting_date.setText(temp4);
                }
//            fm2.meeting_date.setText(temp1.getMeetingDate());

            fm2.meeting_date.setText(temp1.getMeetingDate());
            fm2.meeting_month.setText(temp1.getMeetingMonth());

        }
    }

    private void configureDefaultMeetingViewHolder(Meeting_Status_Holder fm3,int position) {
        meeting_Item_status temp3 = (meeting_Item_status) meetingItems.get(position);
        if (temp3 != null) {
            fm3.meeting_status.setText(temp3.getMeeting_status());

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
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
////      es in Holder elements ***********/
//            if(holder.meetingNumber!= null){
//                holder.meetingNumber.setText( tempValues.getMeeting_number() );}
//
//                holder.agenda.setText("In the agenda: "+tempValues.getAgenda());
//
////                new StringBuilder().append(day).append("/")
//                if(tempValues.getMeetingDate().length() == 1){
//                    String temp = "0" + tempValues.getMeetingDate();
//                    holder.meetingDate.setText(temp);
//                }
//                    holder.meetingDate.setText(tempValues.getMeetingDate());
//                }
//
//                holder.meetingMonth.setText(tempValues.getMeetingMonth());
////