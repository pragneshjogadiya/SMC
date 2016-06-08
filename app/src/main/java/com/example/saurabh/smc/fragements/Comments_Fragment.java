package com.example.saurabh.smc.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.ListModels.comment_item;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.CommentsCustomAdapter;
import com.example.saurabh.smc.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/8/2016.
 */
public class Comments_Fragment extends Fragment {

    View view;
    String[] names_of_commentator;
    String[] times_of_comments;
    String[] comments_texts;

    CommentsCustomAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.comments, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


        RecyclerView comments_rv = (RecyclerView) view.findViewById(R.id.comments_rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        comments_rv.setLayoutManager(llm);

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
    }
}