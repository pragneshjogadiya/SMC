package com.example.saurabh.smc.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.ListModels.FaqModel;
import com.example.saurabh.smc.ListModels.FaqModel_new;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.FAQCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQ extends Fragment {

    View view;
    String[] questions;
    String[] answers;
    String[] dates;
    String[] months;
    String[] Upcoming_meetings;
    public FAQ() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.recycleview_layout, container, false);


        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        List<Object> qa;
        qa = new ArrayList<>();
        // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
        questions = getResources().getStringArray(R.array.meeting_number);
        answers = getResources().getStringArray(R.array.agendas);
        dates = getResources().getStringArray(R.array.meeting_dates);
        months = getResources().getStringArray(R.array.meeting_months);
        Upcoming_meetings = getResources().getStringArray(R.array.upcoming_meeting);
        FaqModel_new items1 = new FaqModel_new(Upcoming_meetings[0]);
        qa.add(items1);

        for (int i = 0; i < questions.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            FaqModel items = new FaqModel(questions[i], answers[i],dates[i],months[i]);

            qa.add(items);
            if(i==1){
                FaqModel_new items2 = new FaqModel_new(Upcoming_meetings[1]);
                qa.add(items2);
            }
        }

//        qa.add(new FaqModel("Single line questions", "Single line answer"));
//        qa.add(new FaqModel("How many lines can a question may have?", "It can have any number of lines like 2 lines to 10 lines"));
//        qa.add(new FaqModel("How many lines does answer have and is view compatible with it?", "Answer also can be many liner and view is compatible with it."));


        FAQCustomAdapter adapter = new FAQCustomAdapter(qa);
        rv.setAdapter(adapter);

        return view;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("FAQs");

    }

}
