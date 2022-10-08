package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Attendance_Status_Adapter;
import com.college.acc_soft.Models.Attendance_Status_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Attendance_StatusFragment extends Fragment {
    RecyclerView recyclerView;
    Attendance_Status_Adapter adapter;
    List<Attendance_Status_Model>list;

    public Attendance_StatusFragment() {
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
        View view = inflater.inflate(R.layout.fragment_attendance__status, container, false);
        recyclerView = view.findViewById(R.id.attendance_rv);
        list = new ArrayList<>();
        adapter = new Attendance_Status_Adapter(getContext(),preparedata());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private List<Attendance_Status_Model> preparedata() {
        list.add(new Attendance_Status_Model("Theory of Computation","P","01","07/10/2022"));
        list.add(new Attendance_Status_Model("Internet And Web Technologies","NA","02","07/10/2022"));
        list.add(new Attendance_Status_Model("Cyber Security","A","03","07/10/2022"));
        list.add(new Attendance_Status_Model("Data Analytics","L","04","07/10/2022"));
        list.add(new Attendance_Status_Model("DBMS","A","05","07/10/2022"));
        list.add(new Attendance_Status_Model("Python","P","06","07/10/2022"));



        return list;
    }
}