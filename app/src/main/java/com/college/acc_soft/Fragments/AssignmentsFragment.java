package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Assignment_Adapter;
import com.college.acc_soft.Adapters.General_InfoAdapter;
import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsFragment extends Fragment {

    View view;
    Assignment_Adapter adapter;
    List<Assignment_Model>list;
    RecyclerView recyclerView;

    public AssignmentsFragment() {
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
        view = inflater.inflate(R.layout.fragment_assignments, container, false);
        list = new ArrayList<>();

        recyclerView = view.findViewById(R.id.assignment_rv);
        adapter = new Assignment_Adapter(getContext(),data());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Assignment_Model> data() {
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 1","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 2","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 3","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 4","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 5","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 6","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 7","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 8","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 9","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));
        list.add(new Assignment_Model("Theory Of Computation","Assignment No. 10","Assignment By - Arpit Sir","21/09/2022","25/09/2022"));

        return list;
    }
}