package com.college.acc_soft.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.college.acc_soft.R;


public class Time_TableFragment extends Fragment {
    View view;
    ImageView timetable;
//    PhotoViewAttacher mAttacher;

    public Time_TableFragment() {
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
        view = inflater.inflate(R.layout.fragment_time__table, container, false);
        timetable = view.findViewById(R.id.time_table_image);
        Drawable bitmap = getResources().getDrawable(R.drawable.time_table);
        timetable.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
//        mAttacher = new PhotoViewAttacher(mImageView);


        return view;
    }
}