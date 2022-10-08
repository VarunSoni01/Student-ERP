package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Fees_ReceiptsAdapter;
import com.college.acc_soft.Models.Fees_ReceiptsModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Fees_ReceiptsFragment extends Fragment {

    View view;
    List<Fees_ReceiptsModel>list;
    Fees_ReceiptsAdapter adapter;
    RecyclerView recyclerView;

    public Fees_ReceiptsFragment() {
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
        view = inflater.inflate(R.layout.fragment_fees__receipts, container, false);
        recyclerView = view.findViewById(R.id.fees_receipt_rv);
        list = new ArrayList<>();
        adapter = new Fees_ReceiptsAdapter(getContext(),preparedata());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Fees_ReceiptsModel> preparedata() {
        list.add(new Fees_ReceiptsModel("10000","Successfull","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Pending","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Failed","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Successfull","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Failed","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Pending","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Failed","123456","22/09/2022"));
        list.add(new Fees_ReceiptsModel("10000","Successfull","123456","22/09/2022"));


        return list;
    }
}