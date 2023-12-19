package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.General_InfoAdapter;
import com.college.acc_soft.Adapters.Library_Adapter;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    View view;
    RecyclerView library_rv;
    Library_Adapter mAdapter;

    public static final Integer[] images = {
            R.drawable.form_approval,
            R.drawable.ledger,
            R.drawable.examination_paper,
            R.drawable.question_paper,
            R.drawable.syllabus
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


    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lists = getActivity().getResources().getStringArray(R.array.library_labels);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_library, container, false);
        library_rv = view.findViewById(R.id.library_rv);
        mAdapter = new Library_Adapter(getContext(),getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        library_rv.setLayoutManager(layoutManager);
        library_rv.setItemAnimator(new DefaultItemAnimator());
        library_rv.setAdapter(mAdapter);

        return view;
    }
}