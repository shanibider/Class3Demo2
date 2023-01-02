package com.example.class3demo2;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.class3demo2.model.Student;

import java.util.List;

//VIEWHOLDER CLASS
class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView nameTv;
    TextView idTv;
    CheckBox cb;
    List <Student> data;
    //CTOR (his job is to save pointers to data)
    public StudentViewHolder(@NonNull View itemView, StudentRecyclerAdapter.OnItemClickListener listener, List <Student> data) {
        super(itemView);
        this.data = data;
        nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
        idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
        cb = itemView.findViewById(R.id.studentlistrow_cb);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = (int) cb.getTag();
                Student st = data.get(pos);
                st.cb = cb.isChecked();
            }
        });

        //Callback for every line
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                listener.onItemClick(pos);
            }
        });
    }


    public void bind(Student st, int pos) {
        nameTv.setText(st.name);
        idTv.setText(st.id);
        cb.setChecked(st.cb);
        cb.setTag(pos);
    }

}




//ADAPTER CLASS (receive the view holder i created earlier) - prepare the list תא
public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    OnItemClickListener listener;           //this listener should move to viewholders
    //interface
    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    LayoutInflater inflater;
    List<Student> data;

    //CTOR
    public StudentRecyclerAdapter(LayoutInflater inflater, List<Student> data) {
        this.inflater = inflater;
        this.data = data;
    }


    void setOnItemClickListener(OnItemClickListener listener) {    this.listener = listener;   }
    @NonNull
    @Override
    //Create view for every line
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate=receive xml and create a view
        View view = inflater.inflate(R.layout.student_list_row, parent, false);     //Creating view
        return new StudentViewHolder(view, listener, data);       //return viewHolder (to wrap view)
    }

    @Override
    //Bind data to line
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student st = data.get(position);
        holder.bind(st, position);
    }

    @Override
    //How much items in list
    public int getItemCount() {
        return data.size();
    }
}




