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

public class Exam_ResultFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<Exam_Result_Model>list;
    Exam_Result_Adapter adapter;

    public Exam_ResultFragment() {
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
        view = inflater.inflate(R.layout.fragment_exam__result, container, false);
        recyclerView = view.findViewById(R.id.exam_result_rv);
        list = new ArrayList<>();
        adapter = new Exam_Result_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Exam_Result_Model> preparedata() {
        list.add(new Exam_Result_Model("I Semester"));
        list.add(new Exam_Result_Model("II Semester"));
        list.add(new Exam_Result_Model("III Semester"));
        list.add(new Exam_Result_Model("IV Semester"));
        list.add(new Exam_Result_Model("V Semester"));
        list.add(new Exam_Result_Model("VI Semester"));
        list.add(new Exam_Result_Model("VII Semester"));
        list.add(new Exam_Result_Model("VIII Semester"));

        return list;
    }
}