package com.college.acc_soft.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.college.acc_soft.Adapters.Nav_Adapter;
import com.college.acc_soft.MainActivity;
import com.college.acc_soft.Models.Nav_list_Model;
import com.college.acc_soft.R;

import java.util.ArrayList;
import java.util.List;


public class Nav_Drawer_Fragment extends Fragment {

    RecyclerView rv;
    ActionBarDrawerToggle toggle;
    Nav_Adapter adapter;
    DrawerLayout drawerLayout;
    View containerview;
    private FragmentDrawerListner fragmentDrawerListner;

    public static final Integer[] images = {
            R.drawable.general_info,
            R.drawable.pay_fee,
            R.drawable.academics_logo,
            R.drawable.library_logo,
            R.drawable.placement,
            R.drawable.enrichment,
            R.drawable.profile_male_png,
            R.drawable.logout
    };

    private static String[] lists = null;


    public static List<Nav_list_Model> getData() {
        List<Nav_list_Model> data = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            Nav_list_Model navItem = new Nav_list_Model();
            navItem.setName(lists[i]);
            navItem.setImage(images[i]);
            data.add(navItem);
        }

        return data;
    }

    public Nav_Drawer_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        lists = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);

    }

    @Override
    public void onResume() {

        super.onResume();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_drawer, container, false);

        try {
            WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            int width = metrics.widthPixels;
            int height = metrics.heightPixels;
            if (width == 480 && height == 800) {

            }
        } catch (Exception e) {

        }


        rv = view.findViewById(R.id.nav_drawer_rv);
        drawerLayout = view.findViewById(R.id.drawer_layout);

        adapter = new Nav_Adapter(getActivity(), getData());
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));


        rv.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                fragmentDrawerListner.onDrawerItemSelected(view, position);
                drawerLayout.closeDrawer(containerview);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return view;
    }


    public void setDrawerListener(MainActivity listener) {
        this.fragmentDrawerListner = (FragmentDrawerListner) listener;
    }

    public interface FragmentDrawerListner {


        public default void onDrawerItemSelected(View view, int position) {
        }
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLay) {
        containerview = getActivity().findViewById(fragmentId);
        drawerLayout = drawerLay;
        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        toggle.setDrawerIndicatorEnabled(false);
        //  toolbar.getBackground().setAlpha(0);

        drawerLayout.setDrawerListener(toggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
                //  toolbar.setNavigationIcon(R.drawable.ic_menu);

            }
        });

    }

}