package com.example.saurabh.smc.fragements;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.ListModels.MemberModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.MemberCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberFragment  extends Fragment {

    View view;
    String[] member_names;
    String[] member_designations;
    int[] member_mobile_numbers;
    //TypedArray menuIcons;

    MemberCustomAdapter adapter;
    private List<MemberModel> MemberModels;

    public MemberFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.recycler_view_with_fab, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.recycler_view_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewMember fragment= new CreateNewMember();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, fragment,null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("SMC Members");



        member_names = getResources().getStringArray(R.array.name_of_persons);
        member_designations = getResources().getStringArray(R.array.designation_of_persons);
        member_mobile_numbers = getResources().getIntArray(R.array.mobile_numbers_int);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        RecyclerView member_rv = (RecyclerView) view.findViewById(R.id.rv_with_fab);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        member_rv.setLayoutManager(llm);

//        List<Object> school_list;
//        school_list = new ArrayList<>();
        // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
        MemberModels = new ArrayList<MemberModel>();
//        menutitles = getResources().getStringArray(R.array.titles2);
//        address = getResources().getStringArray(R.array.addr);

        for (int i = 0; i < member_names.length; i++) {
            // RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            MemberModel items = new MemberModel(member_names[i],member_designations[i],member_mobile_numbers[i]);

            MemberModels.add(items);
        }

        MemberCustomAdapter adapter = new MemberCustomAdapter(MemberModels);
        member_rv.setAdapter(adapter);

//        adapter = new MemberCustomAdapter(getActivity(), MemberModels);
//        setListAdapter(adapter);
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

