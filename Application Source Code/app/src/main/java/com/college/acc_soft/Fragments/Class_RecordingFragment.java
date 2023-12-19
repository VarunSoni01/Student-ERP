package com.college.acc_soft.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Class_Recording_Adapter;
import com.college.acc_soft.Models.Class_Recording_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;


public class Class_RecordingFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    Class_Recording_Adapter adapter;
    List<Class_Recording_Model> list;

    public Class_RecordingFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_class__recording, container, false);
        recyclerView = view.findViewById(R.id.class_recording_rv);
        list = new ArrayList<>();
        adapter = new Class_Recording_Adapter(getContext(),preparedate());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        return view;
    }

    private List<Class_Recording_Model> preparedate() {
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));
        list.add(new Class_Recording_Model("Internet Web Technologie","Internet","07/10/2022"));

        return list;
    }
}