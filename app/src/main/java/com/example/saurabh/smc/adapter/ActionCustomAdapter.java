package com.example.saurabh.smc.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.ActionModel;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */


public class ActionCustomAdapter extends RecyclerView.Adapter<ActionCustomAdapter.ActionViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ActionModel item);
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView type;
        TextView owner;
        TextView date;
        View status;

        ActionViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_action_item);
            title = (TextView) itemView.findViewById(R.id.job_title_tv);
            date = (TextView) itemView.findViewById(R.id.job_due_tv);
            type = (TextView) itemView.findViewById(R.id.job_type_tv);
            owner = (TextView) itemView.findViewById(R.id.action_owner_tv);
            status = (View) itemView.findViewById(R.id.action_status_view);
        }

        public void bind(final ActionModel item, final OnItemClickListener listener) {
             
            title.setText( item.getTitle() );
            type.setText( item.gettype() );
            date.setText( item.getdate() );
           owner.setText( item.getowner() );
            if(item.getstatus()){
                status.getBackground().setColorFilter(Color.parseColor("#6fdc6f"), PorterDuff.Mode.DARKEN);
                status.setBackgroundColor(0xff6fdc6f);
            }else{

                status.getBackground().setColorFilter(Color.parseColor("#ff4c4c"), PorterDuff.Mode.DARKEN);
                status.setBackgroundColor(0xffff4c4c);
            }



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    List<ActionModel> Actionitems;
    OnItemClickListener listener;

    public ActionCustomAdapter(List<ActionModel> Actionitems, OnItemClickListener listener){
        this.Actionitems = Actionitems;
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return Actionitems.size();
    }
    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.action_list_item, viewGroup, false);
        ActionViewHolder Actionvh = new ActionViewHolder(v);
        return Actionvh;
    }
    @Override
    public void onBindViewHolder(ActionViewHolder ActionViewHolder, int i) {

        final int y =i;
        ActionViewHolder.bind(Actionitems.get(i), listener);



    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, ActionModel data) {
        Actionitems.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(ActionModel data) {
        int position = Actionitems.indexOf(data);
        Actionitems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, Actionitems.size());
    }
    public void add(ActionModel data){
        int j = getItemCount();
        insert(j,data);
    }
}

//public class ActionCustomAdapter extends BaseAdapter {
//
//    Context context;
//    ActionModel tempValues=null;
//    List<ActionModel> ActionItems;
//
//    public ActionCustomAdapter(Context context, List<ActionModel> ActionItems) {
//        this.context = context;
//        this.ActionItems = ActionItems;
//
//    }
//
//    @Override
//    public int getCount() {
//
//        return ActionItems.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//
//        return ActionItems.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//
//        return ActionItems.indexOf(getItem(position));
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
////        if (convertView == null) {
////            LayoutInflater mInflater = (LayoutInflater) context
////                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
////            convertView = mInflater.inflate(R.layout.list_item, null);
////        }
////
////        //ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
////        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
////
////        ActionItems row_pos = ActionItems.get(position);
////        // setting the image resource and title
////        //imgIcon.setImageResource(row_pos.getIcon());
////        txtTitle.setText(row_pos.getTitle());
//        View vi = convertView;
//        ActionViewHolder holder;
//
//        if(convertView==null){
//
//            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
//            LayoutInflater mInflater = (LayoutInflater) context
//                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            vi = mInflater.inflate(R.layout.action_list_item, null);
//
//
//            /****** View Holder Object to contain tabitem.xml file elements ******/
//
//            holder = new ActionViewHolder();
//            holder.title = (TextView) vi.findViewById(R.id.job_title_tv);
//            holder.date = (TextView) vi.findViewById(R.id.job_due_tv);
//            holder.type = (TextView) vi.findViewById(R.id.job_type_tv);
//            holder.owner = (TextView) vi.findViewById(R.id.action_owner_tv);
//            holder.status = (View) vi.findViewById(R.id.action_status_view);
//
//            // holder.text1=(TextView)vi.findViewById(R.id.text1);
//            //holder.image=(ImageView)vi.findViewById(R.id.image);
//
//            /************  Set holder with LayoutInflater ************/
//            vi.setTag( holder );
//        }
//        else
//            holder=(ActionViewHolder)vi.getTag();
//
//        if(ActionItems.size()<=0)
//        {
//            holder.title.setText("No Data");
//
//        }
//        else
//        {
//            /***** Get each Model object from Arraylist ********/
//            tempValues=null;
//            tempValues = ( ActionModel ) ActionItems.get( position );
//
//            /************  Set Model values in Holder elements ***********/
//
//            holder.title.setText( tempValues.getTitle() );
//            holder.type.setText( tempValues.gettype() );
//            holder.date.setText( tempValues.getdate() );
//            holder.owner.setText( tempValues.getowner() );
//            if(tempValues.getstatus()){
//                holder.status.getBackground().setColorFilter(Color.parseColor("#6fdc6f"), PorterDuff.Mode.DARKEN);
//                holder.status.setBackgroundColor(0xff6fdc6f);
//            }else{
//
//                holder.status.getBackground().setColorFilter(Color.parseColor("#ff4c4c"), PorterDuff.Mode.DARKEN);
//                holder.status.setBackgroundColor(0xffff4c4c);
//            }
//            // holder.text1.setText( tempValues.getUrl() );
//            //holder.image.setImageResource(
//            //      res.getIdentifier(
//            //            "com.androidexample.customlistview:drawable/"+tempValues.getImage()
//            //          ,null,null));
//
//            /******** Set Item Click Listner for LayoutInflater for each row *******/
//
//
//        }
//        return vi;
//
//
//
//    }
//}
//class ActionViewHolder{
//
//    public TextView title;
//    public TextView type;
//    public TextView owner;
//    public TextView date;
//    public View status;
//
//    //public TextView text1;
//    //public TextView textWide;
//    // public ImageView image;
//
//}