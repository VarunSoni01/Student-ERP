package com.college.acc_soft.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.college.acc_soft.Adapters.Assignment_Adapter;
import com.college.acc_soft.Models.Assignment_Model;
import com.college.acc_soft.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsFragment extends Fragment {

    View view;
    Assignment_Adapter adapter;
    List<Assignment_Model> list;
    RecyclerView recyclerView;
    FirebaseFirestore firestore;
    FirebaseDatabase database;
    DatabaseReference reference;

    public AssignmentsFragment() {
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
        view = inflater.inflate(R.layout.fragment_assignments, container, false);
        list = new ArrayList<>();
        firestore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Assignment");
        recyclerView = view.findViewById(R.id.assignment_rv);
        adapter = new Assignment_Adapter(getContext(), list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

//        firestore.

        Firestore();

//        DataBase();

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void DataBase() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(getContext(), "Working", Toast.LENGTH_SHORT).show();
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Toast.makeText(getContext(), "Recheck", Toast.LENGTH_SHORT).show();
                        list.clear();
                        for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                            list.add(snapshot.getValue(Assignment_Model.class));
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "" + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Firestore() {
        firestore.collection("Assignment").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (DocumentChange dc : value.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        list.add(new Assignment_Model(dc.getDocument().getString("subject"), dc.getDocument().getString("link"), dc.getDocument().getString("ass_no"), dc.getDocument().getString("by"), dc.getDocument().getString("pub_date"), dc.getDocument().getString("up_date")));
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

}