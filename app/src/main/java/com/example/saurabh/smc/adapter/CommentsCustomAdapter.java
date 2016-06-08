package com.example.saurabh.smc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.comment_item;
import com.example.saurabh.smc.R;
import com.example.saurabh.smc.graphics.My_ColorGenerator;
import com.example.saurabh.smc.graphics.My_TextDrawable;

import java.util.List;

/**
 * Created by user on 6/8/2016.
 */
public class CommentsCustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<Object> CommentItem;

    public CommentsCustomAdapter(List<Object> CommentItem) {
        this.CommentItem = CommentItem;
//        this.rowItem1 = rowItem1;
    }

    public static class comments_holder extends RecyclerView.ViewHolder {

        TextView name_of_commentator;
        TextView time_of_comment;
        TextView comment_text;
        ImageView comment_icon;


        comments_holder(View v) {
            super(v);
            this.name_of_commentator = (TextView) v.findViewById(R.id.comment_name_of_commentator);
            this.time_of_comment = (TextView) v.findViewById(R.id.comment_time_of_comment);
            this.comment_text = (TextView) v.findViewById(R.id.comment_text);
            this.comment_icon = (ImageView) v.findViewById(R.id.comment_icon_of_commentator);
        }
    }

    @Override
    public int getItemCount() {

        return CommentItem.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        RecyclerView.ViewHolder comment;


        View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item,viewGroup,false);
        comment = new comments_holder(v1);

        return comment;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder commentViewHolder, int position) {


        comments_holder comment_list = (comments_holder) commentViewHolder;
        configureCommentHolder(comment_list, position);
    }

    private void configureCommentHolder(comments_holder comment_list,int position) {
        comment_item temp = (comment_item) CommentItem.get(position);
        if (temp != null) {
            comment_list.name_of_commentator.setText(temp.getName_of_commentator());
            comment_list.time_of_comment.setText(temp.getTime_of_comment());
            comment_list.comment_text.setText(temp.getComment_text());

            String firstLetter = String.valueOf(temp.getName_of_commentator().charAt(0));

            My_ColorGenerator generator = My_ColorGenerator.MATERIAL; // or use DEFAULT
            // generate random color
            int color = generator.getColor(position);
            //int color = generator.getRandomColor();

            My_TextDrawable drawable = My_TextDrawable.builder()
                    .buildRound(firstLetter, color); // radius in px

            comment_list.comment_icon.setImageDrawable(drawable);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
