package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Academics_Calender_Adapter;
import com.college.acc_soft.Models.Academics_Calender_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Academic_CalenderFragment extends Fragment {
    RecyclerView recyclerView;
    Academics_Calender_Adapter adapter;
    List<Academics_Calender_Model>list;

    public Academic_CalenderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_academic__calender, container, false);
        recyclerView= view.findViewById(R.id.calender_rv);
        list = new ArrayList<>();
        adapter = new Academics_Calender_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private List<Academics_Calender_Model> preparedata() {
        list.add(new Academics_Calender_Model("5 Oct","Dussehra Holiday"));
        list.add(new Academics_Calender_Model("5 Oct","Dussehra Holiday"));
        list.add(new Academics_Calender_Model("5 Oct","Dussehra Holiday"));
        list.add(new Academics_Calender_Model("5 Oct","Dussehra Holiday"));
        list.add(new Academics_Calender_Model("5 Oct","Dussehra Holiday"));

        return list;
    }
}