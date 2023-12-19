package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Student_Ledger_Adapter;
import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.Models.Student_Ledger_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Student_LedgerFragment extends Fragment {

    View view;
    List<Student_Ledger_Model>list;
    Student_Ledger_Adapter adapter;
    RecyclerView recyclerView;

    public Student_LedgerFragment() {
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
        view =  inflater.inflate(R.layout.fragment_student__ledger, container, false);
        recyclerView = view.findViewById(R.id.student_ledger_rv);
        list = new ArrayList<>();
        adapter = new Student_Ledger_Adapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Student_Ledger_Model> preparedata() {
        list.add(new Student_Ledger_Model("10000","Credited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Debited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Debited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Credited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Debited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Credited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Credite","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));
        list.add(new Student_Ledger_Model("10000","Debited","Fee Rec.:798 Dt.11-May-2022 V.No.: 798","22/09/2022"));

        return list;
    }
}