package com.college.acc_soft.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.college.acc_soft.R;

public class PayFeesFragment extends Fragment {

    View view;
    TextView link;

    public PayFeesFragment() {
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
        view = inflater.inflate(R.layout.fragment_pay_fees, container, false);
        link = view.findViewById(R.id.payment_link);
        link.setMovementMethod(LinkMovementMethod.getInstance());


        return view;
    }
}