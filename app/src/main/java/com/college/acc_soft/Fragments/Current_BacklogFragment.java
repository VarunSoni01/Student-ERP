package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Current_Backlog_Adapter;
import com.college.acc_soft.Models.Current_Backlog_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Current_BacklogFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    Current_Backlog_Adapter adapter;
    List<Current_Backlog_Model>list;

    public Current_BacklogFragment() {
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
        view = inflater.inflate(R.layout.fragment_current__backlog, container, false);
        recyclerView = view.findViewById(R.id.curren_backlog_rv);
        list = new ArrayList<>();
        adapter = new Current_Backlog_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Current_Backlog_Model> preparedata() {
        list.add(new Current_Backlog_Model("Theory of Computation","V Sem"));
        list.add(new Current_Backlog_Model("Mathematics III","IV Sem"));
        list.add(new Current_Backlog_Model("Mathematics II","II Sem"));
        list.add(new Current_Backlog_Model("Mathematics I","I Sem"));
        list.add(new Current_Backlog_Model("Computer Organization And Architecture","IV Sem"));
        list.add(new Current_Backlog_Model("CHEMISTRY","I Sem"));

        return list;
    }


}