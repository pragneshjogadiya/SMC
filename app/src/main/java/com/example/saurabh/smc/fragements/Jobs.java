package com.example.saurabh.smc.fragements;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saurabh.smc.JobDescriptionAc;
import com.example.saurabh.smc.ListModels.ActionModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.ActionCustomAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Jobs  extends Fragment {

    String[] menutitles;
    RecyclerView rv;
    View view;
    //TypedArray menuIcons;

    ActionCustomAdapter adapter;
    private List<ActionModel> ActionModels;

    public Jobs(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.recycleview_layout, null, false);

        rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);


        menutitles = getResources().getStringArray(R.array.mem_type);
        // menuIcons = getResources().obtainTypedArray(R.array.icons);

        ActionModels = new ArrayList<ActionModel>();




        for (int i = 0; i < menutitles.length; i++) {
            // ActionModel items = new ActionModel(menutitles[i], menuIcons.getResourceId(
            //  i, -1));
            ActionModel items = new ActionModel(menutitles[i],menutitles[i],menutitles[i],menutitles[i],false);

            ActionModels.add(items);
        }

        final ActionCustomAdapter adapter = new ActionCustomAdapter(ActionModels, new ActionCustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ActionModel item) {
                Intent openH = new Intent(getContext(), JobDescriptionAc.class);
                startActivity(openH);
            }
        });
        rv.setAdapter(adapter);




        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);




    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//
////        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
////                .show();
//
//        Intent openH = new Intent(getContext(), JobDescriptionAc.class);
//        startActivity(openH);
//
//    }
}
