package com.example.saurabh.smc.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.TestModel;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 6/3/2016.
 */
public class TestCustomAdapter extends RecyclerView.Adapter<TestCustomAdapter.QAViewHolder> {


    public interface OnItemClickListener {
        void onItemClick(TestModel item);
    }

    public static class QAViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;
        CheckBox box;
        Button b;

        QAViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardViewz_agenda);
            text = (TextView)itemView.findViewById(R.id.new_agenda);
            box = (CheckBox) itemView.findViewById(R.id.agenda_checkBox);
            b = (Button) itemView.findViewById(R.id.add_button);
        }

        public void bind(final TestModel item, final OnItemClickListener listener) {


            text.setText(item.getTitle());
            box.setChecked(item.getCheck());



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    List<TestModel> qanda;
    OnItemClickListener listener;

    public TestCustomAdapter(List<TestModel> qanda, OnItemClickListener listener){
        this.qanda = qanda;
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return qanda.size();
    }
    @Override
    public QAViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.agenda_item, viewGroup, false);
        QAViewHolder qavh = new QAViewHolder(v);
        return qavh;
    }
    @Override
    public void onBindViewHolder(QAViewHolder qaViewHolder, int i) {

        final int y =i;
        qaViewHolder.bind(qanda.get(i), listener);
        qaViewHolder.b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                remove(qanda.get(y));
            }
        });


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, TestModel data) {
        qanda.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(TestModel data) {
        int position = qanda.indexOf(data);
        qanda.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, qanda.size());
    }
    public void add(TestModel data){
        int j = getItemCount();
        insert(j,data);
    }
}
