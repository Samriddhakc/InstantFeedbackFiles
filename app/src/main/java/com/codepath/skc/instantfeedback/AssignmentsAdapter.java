package com.codepath.skc.instantfeedback;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.skc.instantfeedback.Models.Assignment;
import com.codepath.skc.instantfeedback.Models.Course;

import java.util.List;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder> {

    private Context context;
    private List<Assignment> assignments;

    public AssignmentsAdapter(Context context, List<Assignment> assignments){
        this.context=context;
        this.assignments=assignments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_assignments,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Assignment assignment=assignments.get(position);
        holder.bind(assignment);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }


    class ViewHolder extends  RecyclerView.ViewHolder  {
        private TextView etAssignmentName;
        private TextView etDeadline;
        private RatingBar etRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etAssignmentName = itemView.findViewById(R.id.etAssignmentName);
            etDeadline = itemView.findViewById(R.id.etDeadline);
            etRatingBar = itemView.findViewById(R.id.etratingBar);
        }

        public void bind(Assignment assignment) {
            etAssignmentName.setText(assignment.getAssignName());
            etDeadline.setText(assignment.getDeadline());
        }

    }

}