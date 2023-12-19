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

public class SyllabusFragment extends Fragment {
    RecyclerView recyclerView;
    Exam_Result_Adapter adapter;
    List<Exam_Result_Model>list;

    public SyllabusFragment() {
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
        View view = inflater.inflate(R.layout.fragment_syllabus, container, false);
        recyclerView = view.findViewById(R.id.syllabus_rv);
        list = new ArrayList<>();
        adapter = new Exam_Result_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Exam_Result_Model> preparedata() {
        list.add(new Exam_Result_Model("Theory Of Computation"));
        list.add(new Exam_Result_Model("Internet And Web Technologies"));
        list.add(new Exam_Result_Model("Data Analytics"));
        list.add(new Exam_Result_Model("DBMS"));
        list.add(new Exam_Result_Model("Cyber Security"));
        list.add(new Exam_Result_Model("Python"));

        return list;
    }
}