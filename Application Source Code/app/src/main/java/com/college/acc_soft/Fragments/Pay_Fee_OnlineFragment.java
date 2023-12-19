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
import com.college.acc_soft.Adapters.Pay_Fee_OnlineAdapter;
import com.college.acc_soft.Models.General_InfoModel;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;

public class Pay_Fee_OnlineFragment extends Fragment {

    View view;
    RecyclerView fee_info_rv;
    Pay_Fee_OnlineAdapter mAdapter;

    public static final Integer[] images = {
            R.drawable.online_payment,
            R.drawable.fees_receipt,
            R.drawable.ledger,
            R.drawable.online_payment,
            R.drawable.pay_fee,
            R.drawable.hostel,
            R.drawable.ledger
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

    public Pay_Fee_OnlineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lists = getActivity().getResources().getStringArray(R.array.fee_info_labels);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pay__fee__online, container, false);
        fee_info_rv = view.findViewById(R.id.fee_info_rv);
        mAdapter = new Pay_Fee_OnlineAdapter(getContext(),getData());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        fee_info_rv.setLayoutManager(layoutManager);
        fee_info_rv.setItemAnimator(new DefaultItemAnimator());
        fee_info_rv.setAdapter(mAdapter);

        return view;
    }
}