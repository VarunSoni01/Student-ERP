package com.college.acc_soft.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Adapters.General_InfoAdapter;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.Models.Nav_list_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class General_InfoFragment extends Fragment{
    View view;
    RecyclerView general_info_rv;
    General_InfoAdapter mAdapter;

    public static final Integer[] images = {
            R.drawable.academic_calender,
            R.drawable.your_profile,
            R.drawable.examination_paper,
            R.drawable.question_paper,
            R.drawable.news__notice,
            R.drawable.syllabus,
            R.drawable.hostel,
            R.drawable.grievance,
            R.drawable.form_approval
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

    public General_InfoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lists = getActivity().getResources().getStringArray(R.array.general_info_labels);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_general__info, container, false);
        general_info_rv = view.findViewById(R.id.general_info_rv);
        mAdapter = new General_InfoAdapter(getContext(),getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        general_info_rv.setLayoutManager(layoutManager);
        general_info_rv.setItemAnimator(new DefaultItemAnimator());
        general_info_rv.setAdapter(mAdapter);


        return view;
    }

}