//package com.example.saurabh.smc.fragements;
//
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.ListFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import com.example.saurabh.smc.ListModels.ActionModel;
//import com.example.saurabh.smc.R;
//import com.example.saurabh.smc.adapter.ActionCustomAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class WrapperFragment extends Fragment {
//    String [] menutitles;
//    private List<ActionModel> ActionModels;
//    ActionCustomAdapter adapter;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        Jobs list = new Jobs();
//        menutitles = getResources().getStringArray(R.array.mem_type);
//        // menuIcons = getResources().obtainTypedArray(R.array.icons);
//
//        ActionModels = new ArrayList<ActionModel>();
//
//
//        for (int i = 0; i < menutitles.length; i++) {
//            // ActionModel items = new ActionModel(menutitles[i], menuIcons.getResourceId(
//            //  i, -1));
//            ActionModel items = new ActionModel(menutitles[i],menutitles[i],menutitles[i],menutitles[i],false);
//
//            ActionModels.add(items);
//        }
//
//        adapter = new ActionCustomAdapter(getActivity(), ActionModels);
//
//        list.setListAdapter(adapter);
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override public void onItemClick(AdapterView<?> l, View v, int position, long id) {
//                // Create details fragment based on clicked item's position
//                Fragment details = new JobDiscription();
//                getChildFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container, details)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
//
//        getChildFragmentManager()
//                .beginTransaction()
//                .add(R.id.container, list)
//                .commit();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // There has to be a view with id `container` inside `wrapper.xml`
//        return inflater.inflate(R.layout.fragment_wrapper, container, false);
//    }
//
////    public class MyListFragment extends ListFragment {
////
////        private AdapterView.OnItemClickListener listener;
////
////        public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
////            this.listener = l;
////        }
////
////        @Override
////        public void onListItemClick(ListView l, View v, int position, long id) {
////            if(listener != null) {
////                listener.onItemClick(l, v, position, id);
////            }
////        }
////    }
//    public static class Jobs  extends ListFragment {
//
//        String[] menutitles;
//        View view;
//        //TypedArray menuIcons;
//
//        ActionCustomAdapter adapter;
//        private List<ActionModel> ActionModels;
//
//        public Jobs(){
//
//
//        }
//        private AdapterView.OnItemClickListener listener;
//
//        public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
//            this.listener = l;
//        }
//
//        @Override
//        public void onListItemClick(ListView l, View v, int position, long id) {
//            if(listener != null) {
//                listener.onItemClick(l, v, position, id);
//            }
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//
//            view = inflater.inflate(R.layout.list_fragment, null, false);
//
////        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                NewActionFragment fragment= new NewActionFragment();
////                getFragmentManager().beginTransaction()
////                        .replace(R.id.frame_container, fragment,null)
////                        .addToBackStack(null)
////                        .commit();
////            }
////        });
//
//            return view;
//        }
//
////        @Override
////        public void onActivityCreated(Bundle savedInstanceState) {
////
////            super.onActivityCreated(savedInstanceState);
////            getActivity().setTitle("Jobs");
////
////            menutitles = getResources().getStringArray(R.array.mem_type);
////            // menuIcons = getResources().obtainTypedArray(R.array.icons);
////
////            ActionModels = new ArrayList<ActionModel>();
////
////
////            for (int i = 0; i < menutitles.length; i++) {
////                // ActionModel items = new ActionModel(menutitles[i], menuIcons.getResourceId(
////                //  i, -1));
////                ActionModel items = new ActionModel(menutitles[i],menutitles[i],menutitles[i],menutitles[i],false);
////
////                ActionModels.add(items);
////            }
////
////            adapter = new ActionCustomAdapter(getActivity(), ActionModels);
////            setListAdapter(adapter);
////            //getListView().setOnItemClickListener(this);
////
////        }
//
////        @Override
////        public void onItemClick(AdapterView<?> parent, View view, int position,
////                                long id) {
////
//////        Toast.makeText(getActivity(), menutitles[position], Toast.LENGTH_SHORT)
//////                .show();
////
////            JobDiscription fragment= new JobDiscription();
////            getFragmentManager().beginTransaction()
////                    .replace(R.id.viewpager, fragment,null)
////                    .addToBackStack(null)
////                    .commit();
////
////        }
//    }
//
//}
