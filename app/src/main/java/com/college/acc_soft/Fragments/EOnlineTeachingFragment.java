package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.E_Online_Teaching_Adapter;
import com.college.acc_soft.Adapters.Fees_ReceiptsAdapter;
import com.college.acc_soft.Models.E_Online_Teaching_Model;
import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;


public class EOnlineTeachingFragment extends Fragment {

    View view;
    List<E_Online_Teaching_Model> list;
    E_Online_Teaching_Adapter adapter;
    RecyclerView recyclerView;

    public EOnlineTeachingFragment() {
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
        view =  inflater.inflate(R.layout.fragment_e_online_teaching, container, false);
        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.online_teaching_rv);
        adapter = new E_Online_Teaching_Adapter(getContext(),preparelist());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



        return view;
    }

    private List<E_Online_Teaching_Model> preparelist() {
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));
        list.add(new E_Online_Teaching_Model("Internet and Web Technologies","05:00 PM to 06:00 PM","05/10/2022"));

        return list;
    }
}