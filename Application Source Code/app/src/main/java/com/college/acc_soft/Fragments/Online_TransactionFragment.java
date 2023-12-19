package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.college.acc_soft.Adapters.Online_Transaction_Adapter;
import com.college.acc_soft.Models.Online_Transaction_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Online_TransactionFragment extends Fragment {

    View view;
    Online_Transaction_Adapter online_transaction_adapter;
    RecyclerView recyclerView;
    List<Online_Transaction_Model>list;

    public Online_TransactionFragment() {
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
        view = inflater.inflate(R.layout.fragment_online__transaction, container, false);
        recyclerView = view.findViewById(R.id.online_trans_rv);
        list = new ArrayList<>();
        online_transaction_adapter = new Online_Transaction_Adapter(getContext(),preparedate());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(online_transaction_adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    private List<Online_Transaction_Model> preparedate() {
        list.add(new Online_Transaction_Model("10000","Successfull","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Pending","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Failed","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Successfull","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Pending","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Successfull","29/07/2022"));
        list.add(new Online_Transaction_Model("10000","Failed","29/07/2022"));

        return list;
    }
}