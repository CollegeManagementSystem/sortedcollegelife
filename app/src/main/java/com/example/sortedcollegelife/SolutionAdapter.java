package com.example.sortedcollegelife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SolutionAdapter extends RecyclerView.Adapter<SolutionAdapter.ViewHolder> {

    ArrayList<String>msolution;
    Context mcontext;
    public  SolutionAdapter(Context mcontext, ArrayList<String>msolution){
        this.mcontext=mcontext;
        this.msolution=msolution;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.solution_basic,viewGroup, false);

        return new SolutionAdapter.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.mtext.setText(msolution.get(i));

    }

    @Override
    public int getItemCount() {
        return msolution.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mainview;
        TextView mtext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainview=itemView;
            mtext=itemView.findViewById(R.id.solutiontext);
        }
    }
}
