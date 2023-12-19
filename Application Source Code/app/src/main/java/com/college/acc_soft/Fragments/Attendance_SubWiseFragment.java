package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Attendance_SubWise_Adapter;
import com.college.acc_soft.Models.Attendance_SubWise_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Attendance_SubWiseFragment extends Fragment {
    RecyclerView recyclerView;
    Attendance_SubWise_Adapter adapter;
    List<Attendance_SubWise_Model> list;

    public Attendance_SubWiseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance__sub_wise, container, false);
        list = new ArrayList<>();
        adapter = new Attendance_SubWise_Adapter(getContext(),preparedata());
        recyclerView = view.findViewById(R.id.attendancesub_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        return view;
    }

    private List<Attendance_SubWise_Model> preparedata() {
        list.add(new Attendance_SubWise_Model("15","5","2","1","Internet And Web Technologies"));
        list.add(new Attendance_SubWise_Model("15","5","2","1","Theory Of Computation"));
        list.add(new Attendance_SubWise_Model("15","5","2","1","DBMS"));
        list.add(new Attendance_SubWise_Model("15","5","2","1","Python"));
        list.add(new Attendance_SubWise_Model("15","5","2","1","Data Analytics"));
        list.add(new Attendance_SubWise_Model("15","5","2","1","Cyber Security"));

        return list;
    }
}