package com.example.fragmentactivity;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NameFragment extends Fragment {
    private  String name;
    private OnFragmentClickListener listener;
    public static final String ARG_NAME="name";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentClickListener)
        listener= (OnFragmentClickListener) context;
        else
            throw new ClassCastException("Your Activity dose not implements OnFragmentClickListener");
    }

    @Override
   public void onDetach(){
        super.onDetach();
        listener=null;
    }

    public NameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NameFragment newInstance(String param1, String param2) {
        NameFragment fragment = new NameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
        name= bundle.getString(ARG_NAME);
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_name, container, false);
       RecyclerView rv=v.findViewById(R.id.main_rv);
        ArrayList<Name> names=new ArrayList<>();
        names.add(new Name("Ahmed"));
        names.add(new Name("Mohammed"));
        names.add(new Name("John"));
        names.add(new Name("Ayman"));

        NameAdapter adapter=new NameAdapter(names, new OnItemClickListener() {
            @Override
            public void onItemClick(Name name) {
           listener.OnFragmentInteraction(name);
            }
        });
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public interface OnFragmentClickListener{
        void OnFragmentInteraction(Name name);
    }
}