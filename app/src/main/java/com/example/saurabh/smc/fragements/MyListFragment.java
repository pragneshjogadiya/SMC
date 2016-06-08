package com.example.saurabh.smc.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.ListModels.RowItem;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

//import com.example.saurabh.smc.ListModels.Meeting_Items;

/**
 * Created by Saurabh on 5/26/2016.
 */
public class MyListFragment  extends Fragment{

    View view;
    String[] menutitles;
    String[] address;
    //TypedArray menuIcons;

    CustomAdapter adapter;;
//    private List<RowItem> rowItems1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycleview_layout, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle("My Schools");
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        List<Object> school_list;
        school_list = new ArrayList<>();
        // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
        menutitles = getResources().getStringArray(R.array.titles2);
        address = getResources().getStringArray(R.array.addr);

        for (int i = 0; i < menutitles.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            RowItem items = new RowItem(menutitles[i],address[i]);

            school_list.add(items);
        }

//        qa.add(new FaqModel("Single line questions", "Single line answer"));
//        qa.add(new FaqModel("How many lines can a question may have?", "It can have any number of lines like 2 lines to 10 lines"));
//        qa.add(new FaqModel("How many lines does answer have and is view compatible with it?", "Answer also can be many liner and view is compatible with it."));


        CustomAdapter adapter = new CustomAdapter(school_list);
        rv.setAdapter(adapter);
//        getListView().setOnItemClickListener(this);

    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//
//        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
//                .show();
//
//    }
}
