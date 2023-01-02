package com.example.class3demo2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

public class StudentsListFragment extends Fragment {
    List<Student> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);

        //Receive data from Model [for data.size()]
        data = Model.instance().getAllStudents();

        RecyclerView list = view.findViewById(R.id.studentlistfrag_list);
        list.setHasFixedSize(true);

        //Layout manage
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        //Adapter
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(), data);
        list.setAdapter(adapter);                       //Bind the adapter to the list

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            //Logic- what happen on line get clicked
            public void onItemClick(int pos) {
                Log.d("TAG", "Row was clicked" + pos);
            }
        });
        return view;
    }
}