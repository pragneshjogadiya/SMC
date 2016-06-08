package com.example.saurabh.smc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.RowItem;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.graphics.My_ColorGenerator;
import com.example.saurabh.smc.graphics.My_TextDrawable;

import java.util.List;

/**
 * Created by Saurabh on 5/26/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
//    RowItem tempValue1=null;
    List<Object> rowItem;
//    List<RowItem> rowItem1;

    public CustomAdapter(List<Object> rowItem) {
        this.rowItem = rowItem;
//        this.rowItem1 = rowItem1;
    }

    public static class school_list_holder extends RecyclerView.ViewHolder {

        TextView school_name;
        TextView school_address;
        ImageView school_icon;


        school_list_holder(View v) {
            super(v);
            this.school_name = (TextView) v.findViewById(R.id.schoolName);
            this.school_address = (TextView) v.findViewById(R.id.schoolAddress);
            this.school_icon = (ImageView) v.findViewById(R.id.school_icon);
        }
    }

    @Override
    public int getItemCount() {

        return rowItem.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        RecyclerView.ViewHolder school;


                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
                school = new school_list_holder(v1);

        return school;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder schoolViewHolder, int position) {


                school_list_holder school_list = (school_list_holder) schoolViewHolder;
                configureSchoolHolder(school_list, position);
    }

    private void configureSchoolHolder(school_list_holder school_list,int position) {
        RowItem temp = (RowItem) rowItem.get(position);
        if (temp != null) {
            school_list.school_name.setText(temp.getTitle());
            school_list.school_address.setText(temp.getAddress());

            String firstLetter = String.valueOf(temp.getTitle().charAt(0));

            My_ColorGenerator generator = My_ColorGenerator.MATERIAL; // or use DEFAULT
            // generate random color
            int color = generator.getColor(position);
            //int color = generator.getRandomColor();

            My_TextDrawable drawable = My_TextDrawable.builder()
                    .buildRound(firstLetter, color); // radius in px

            school_list.school_icon.setImageDrawable(drawable);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
