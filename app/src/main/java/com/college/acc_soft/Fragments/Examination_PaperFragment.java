package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Exam_Result_Adapter;
import com.college.acc_soft.Models.Exam_Result_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;


public class Examination_PaperFragment extends Fragment {
    RecyclerView recyclerView;
    Exam_Result_Adapter adapter;
    List<Exam_Result_Model> list;

    public Examination_PaperFragment() {
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
        View view = inflater.inflate(R.layout.fragment_examination__paper, container, false);
        recyclerView = view.findViewById(R.id.examination_paper_rv);
        list = new ArrayList<>();
        adapter = new Exam_Result_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Exam_Result_Model> preparedata() {
        list.add(new Exam_Result_Model("Theory Of Computation RGPV 2021"));
        list.add(new Exam_Result_Model("Internet And Web Technologies 2022 MST - 1"));
        list.add(new Exam_Result_Model("Data Analytics 2022 MST -2"));
        list.add(new Exam_Result_Model("DBMS 2021 RGPV"));
        list.add(new Exam_Result_Model("Cyber Security 2020 Workshop"));
        list.add(new Exam_Result_Model("Python Not Determined"));

        return list;
    }

}