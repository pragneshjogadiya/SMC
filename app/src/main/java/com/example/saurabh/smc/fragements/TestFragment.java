package com.example.saurabh.smc.fragements;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.saurabh.smc.JobDescriptionAc;
import com.example.saurabh.smc.ListModels.TestModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.adapter.TestCustomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {

    View view;
    EditText ed;
    List<TestModel> qa;
    RecyclerView rv;


    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_test, container, false);





         rv = (RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        Button add = (Button) view.findViewById(R.id.add_new_button) ;
        ed = (EditText) view.findViewById(R.id.editText_agenda);

        qa = new ArrayList<>();;

        final TestCustomAdapter adapter = new TestCustomAdapter(qa, new TestCustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TestModel item) {
                Intent openH = new Intent(getContext(), JobDescriptionAc.class);
                startActivity(openH);
            }
        });
        rv.setAdapter(adapter);



        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                adapter.add(new TestModel(ed.getText().toString(),false));


            }
        });




        return view;
    }

}
