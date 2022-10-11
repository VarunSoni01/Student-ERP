package com.college.acc_soft.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Adapters.Exam_Result_Adapter;
import com.college.acc_soft.Models.Exam_Result_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Question_PaperFragment extends Fragment {
    RecyclerView recyclerView;
    Exam_Result_Adapter adapter;
    List<Exam_Result_Model> list;

    public Question_PaperFragment() {
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
        View view = inflater.inflate(R.layout.fragment_question__paper, container, false);
        recyclerView = view.findViewById(R.id.ques_paper_rv);
        list = new ArrayList<>();
        adapter = new Exam_Result_Adapter(getContext(), preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Exam_Result_Model> preparedata() {
        list.add(new Exam_Result_Model("Theory Of Computation Question Papers 2021"));
        list.add(new Exam_Result_Model("Internet And Web Technologies Question Papers 2021"));
        list.add(new Exam_Result_Model("Data Analytics Question Papers 2021"));
        list.add(new Exam_Result_Model("DBMS Question Papers 2021"));
        list.add(new Exam_Result_Model("Cyber Security Question Papers 2021"));
        list.add(new Exam_Result_Model("Python Question Papers 2021"));

        return list;
    }
}