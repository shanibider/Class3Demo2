package com.example.class3demo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {
    List<Student> data;

    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        //Receive data from Model [for data.size()]
        data = Model.instance().getAllStudents();

        RecyclerView list = findViewById(R.id.studentrecycler_list);
        list.setHasFixedSize(true);

        //Layout manage
        list.setLayoutManager(new LinearLayoutManager(this));
        //Adapter
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(), data);
        //Bind the adapter to the list
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            //Logic- what happen on line get clicked
            public void onItemClick(int pos) {
                Log.d("TAG", "Row was clicked" + pos);
            }
            });
    }

}


