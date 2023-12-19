package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Knowledge_Center_Adapter;
import com.college.acc_soft.Models.Knowledge_Center_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Knowledge_CenterFragment extends Fragment {
    RecyclerView recyclerView;
    Knowledge_Center_Adapter adapter;
    List<Knowledge_Center_Model>list;

    public Knowledge_CenterFragment() {
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
        View view = inflater.inflate(R.layout.fragment_knowledge__center, container, false);
        recyclerView = view.findViewById(R.id.knowledge_rv);
        list = new ArrayList<>();
        adapter = new Knowledge_Center_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



        return view;
    }

    private List<Knowledge_Center_Model> preparedata() {
        list.add(new Knowledge_Center_Model("Study Materials","Google Drive consists of PPTs, ebooks, sample papers, etc. Link is shared below","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Linux 2","Linux Practical","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Linux","Linux Viva Questions","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Internet and Web Technologies","Study Material","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Study Materials","Google Drive consists of PPTs, ebooks, sample papers, etc. Link is shared below","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Internet and Web Technologies","Study Material","29-Sep-202"));
        list.add(new Knowledge_Center_Model("Study Materials","Google Drive consists of PPTs, ebooks, sample papers, etc. Link is shared below","29-Sep-202"));


        return list;
    }
}