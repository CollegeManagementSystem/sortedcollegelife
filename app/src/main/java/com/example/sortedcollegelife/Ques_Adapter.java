package com.example.sortedcollegelife;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class Ques_Adapter extends RecyclerView.Adapter<Ques_Adapter
        .ViewHolderSetActiveList> {
    Context mContext;
    ArrayList<String> mydoubt;
    public Ques_Adapter(Context mContext,ArrayList<String>mydoubt) {
        this.mContext = mContext;
        this.mydoubt=mydoubt;
    }

    @NonNull
    @Override
    public ViewHolderSetActiveList onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ques_basic,viewGroup, false);

        return new ViewHolderSetActiveList(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSetActiveList viewHolderSetActiveList, int i) {


        viewHolderSetActiveList.quesedit.setText(mydoubt.get(i));

        viewHolderSetActiveList.setListener(i);
    }

    @Override
    public int getItemCount() {
        return mydoubt.size();
    }


    class ViewHolderSetActiveList extends RecyclerView.ViewHolder
    {
        View mainview;
        ImageView quesImage;
        TextView quesedit;
        ImageButton quesnext;
        public ViewHolderSetActiveList(@NonNull View itemView) {
            super(itemView);
            mainview=itemView;
            quesImage=itemView.findViewById(R.id.quesimage);
            quesedit=itemView.findViewById(R.id.quesedit);
            quesnext=itemView.findViewById(R.id.quesnext);

        }
        public void setListener(final int i)
        {
            //quesedit.setText(s1);
            quesnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent I1=new Intent(mContext,Quesdecesion.class);
                    I1.putExtra("Ques",mydoubt.get(i));
                    mContext.startActivity(I1);
                    Toast.makeText(mContext,"ok",Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}


