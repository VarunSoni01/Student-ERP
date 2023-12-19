package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Acknowledge_Adapter;
import com.college.acc_soft.Adapters.General_InfoAdapter;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class EnrichmentFragment extends Fragment {
    View view;
    RecyclerView general_info_rv;
    Acknowledge_Adapter mAdapter;


    public static final Integer[] images = {
            R.drawable.grievance,
            R.drawable.syllabus,
            R.drawable.assignment
    };

    private static String[] lists = null;

    public static List<General_InfoModel> getData() {
        List<General_InfoModel> data = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            General_InfoModel item = new General_InfoModel(lists[i],images[i] );
            item.setText(lists[i]);
            item.setImage(images[i]);
            data.add(item);
        }

        return data;
    }


    public EnrichmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lists = getActivity().getResources().getStringArray(R.array.enrichment_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_enrichment, container, false);
        general_info_rv = view.findViewById(R.id.enrichment_rv);
        mAdapter = new Acknowledge_Adapter(getContext(),getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        general_info_rv.setLayoutManager(layoutManager);
        general_info_rv.setItemAnimator(new DefaultItemAnimator());
        general_info_rv.setAdapter(mAdapter);


        return view;
    }
}