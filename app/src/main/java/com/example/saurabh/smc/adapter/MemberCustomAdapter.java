package com.example.saurabh.smc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.MemberModel;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.graphics.My_ColorGenerator;
import com.example.saurabh.smc.graphics.My_TextDrawable;

import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//    MemberModel tempValues=null;

    List<MemberModel> MemberItems;

    public MemberCustomAdapter(List<MemberModel> MemberItems) {
        this.MemberItems = MemberItems;
    }

    public static class member_list_holder extends RecyclerView.ViewHolder {

        TextView member_name;
        TextView member_designation;
        TextView member_mobile;
        ImageView member_icon;

        member_list_holder(View v) {
            super(v);
            this.member_name = (TextView) v.findViewById(R.id.member_name);
            this.member_designation = (TextView) v.findViewById(R.id.member_designation);
            this.member_mobile = (TextView) v.findViewById(R.id.member_mobile);
            this.member_icon = (ImageView)v.findViewById(R.id.member_icon);
        }
    }

    @Override
    public int getItemCount() {

        return MemberItems.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        RecyclerView.ViewHolder member;


        View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member_list_item, viewGroup, false);
        member = new member_list_holder(v1);

        return member;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder memberViewHolder, int position) {


        member_list_holder member_list = (member_list_holder) memberViewHolder;
        configureMemberHolder(member_list, position);
    }

    private void configureMemberHolder(member_list_holder member_list,int position) {
        MemberModel temp = (MemberModel) MemberItems.get(position);
        if (temp != null) {
            String temp_string = Integer.toString(temp.getMember_list_mobile());
            member_list.member_name.setText(temp.getMember_list_name());
            member_list.member_designation.setText(temp.getMember_list_designation());
            member_list.member_mobile.setText(temp_string);

            String firstLetter = String.valueOf(temp.getMember_list_name().charAt(0));

            My_ColorGenerator generator = My_ColorGenerator.MATERIAL; // or use DEFAULT
            // generate random color
            int color = generator.getColor(position);
            //int color = generator.getRandomColor();

            My_TextDrawable drawable = My_TextDrawable.builder()
                    .buildRound(firstLetter, color); // radius in px

            member_list.member_icon.setImageDrawable(drawable);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}


//            String firstLetter = String.valueOf(tempValues.getName().charAt(0));
//
//            ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
//            // generate random color
//            int color = generator.getColor(getItem(position));
//            //int color = generator.getRandomColor();
//
//            TextDrawable drawable = TextDrawable.builder()
//                    .buildRound(firstLetter, color); // radius in px
//
//            holder.icon.setImageDrawable(drawable);
