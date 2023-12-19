package com.college.acc_soft.Fragments;

import android.hardware.lights.LightsManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Admin_Panel_Adapter;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;


public class Admin_PanelFragment extends Fragment {
    Admin_Panel_Adapter adapter;
    List<General_InfoModel>list;
    RecyclerView recyclerView;

    public static final Integer[] images = {
            R.drawable.assignment
    };

    private static String[] lists = null;

    public Admin_PanelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lists = getActivity().getResources().getStringArray(R.array.admin_panel_labels);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_admin__panel, container, false);
        recyclerView = view.findViewById(R.id.admin_rv);
        list = new ArrayList<>();
        adapter = new Admin_Panel_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private List<General_InfoModel> preparedata() {
        for (int i = 0; i < lists.length; i++) {
            General_InfoModel item = new General_InfoModel(lists[i],images[i] );
            item.setText(lists[i]);
            item.setImage(images[i]);
            list.add(item);
        }

        return list;
    }
}