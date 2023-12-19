package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.News_Notice_Adapter;
import com.college.acc_soft.Models.News_Notice_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class News_NoticeFragment extends Fragment {
    View view;
    News_Notice_Adapter adapter;
    List<News_Notice_Model>list;
    RecyclerView recyclerView;

    public News_NoticeFragment() {
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
        view = inflater.inflate(R.layout.fragment_news__notice, container, false);
        list = new ArrayList<>();
        adapter = new News_Notice_Adapter(getContext(),preparedata());
        recyclerView = view.findViewById(R.id.news_notice_rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private List<News_Notice_Model> preparedata() {
        list.add(new News_Notice_Model("FEES","Kindly note that the late fee shall be applicable on partial payment @25 per day","25/09/2022"));
        list.add(new News_Notice_Model("Scholarship Last Date","Scholarship Last Date","25/09/2022"));
        list.add(new News_Notice_Model("Scholarship Notice 2022-23","Scholarship Notice 2022-23","25/09/2022"));
        list.add(new News_Notice_Model("NOTICE","Swavalambi bharat abhiyan","25/09/2022"));
        list.add(new News_Notice_Model("Notice for No Academics on 23.08.2022 due to Heavy Rain","Notice for No Academics on 23.08.2022 due to Heavy Rain","25/09/2022"));
        list.add(new News_Notice_Model("Notice for College Attendance 2022-23","Notice for College Attendance 2022-23","25/09/2022"));
        list.add(new News_Notice_Model("Attendance","90% Attendance","25/09/2022"));
        list.add(new News_Notice_Model("FEES","Kindly note that the late fee shall be applicable on partial payment @25 per day","25/09/2022"));
        list.add(new News_Notice_Model("Scholarship Last Date","Scholarship Last Date","25/09/2022"));
        list.add(new News_Notice_Model("Scholarship Notice 2022-23","Scholarship Notice 2022-23","25/09/2022"));
        list.add(new News_Notice_Model("NOTICE","Swavalambi bharat abhiyan","25/09/2022"));
        list.add(new News_Notice_Model("Notice for No Academics on 23.08.2022 due to Heavy Rain","Notice for No Academics on 23.08.2022 due to Heavy Rain","25/09/2022"));
        list.add(new News_Notice_Model("Notice for College Attendance 2022-23","Notice for College Attendance 2022-23","25/09/2022"));
        list.add(new News_Notice_Model("Attendance","90% Attendance","25/09/2022"));
        return list;
    }
}