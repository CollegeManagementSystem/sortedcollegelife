package com.example.sortedcollegelife;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class ContactAdapter  extends RecyclerView.Adapter<ContactAdapter.ViewHolderSetActivelist> {

    Context mcontext;
    ArrayList<String>contacts;
    public ContactAdapter(Context mcontent,ArrayList<String>contacts){
        this.contacts=contacts;
        this.mcontext=mcontent;
    }

    @NonNull
    @Override
    public ViewHolderSetActivelist onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewitem= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.contact_basic,viewGroup,false);
        return new ViewHolderSetActivelist(viewitem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSetActivelist viewHolderSetActivelist, int i) {
            viewHolderSetActivelist.mcontactnumber.setText(contacts.get(i).toString());
            viewHolderSetActivelist.setlistener(i);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolderSetActivelist extends RecyclerView.ViewHolder {
        View mainview;
        TextView mcontactnumber;
        public ViewHolderSetActivelist(@NonNull View itemView) {
            super(itemView);
            mainview=itemView;
            mcontactnumber=itemView.findViewById(R.id.contactedit);

        }

        public void setlistener(int i) {
            mcontactnumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext,mcontactnumber.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent I1=new Intent(mcontext,MainChat.class);
                    I1.putExtra("chatphonenumber",mcontactnumber.getText().toString());
                    mcontext.startActivity(I1);
                }
            });
        }
    }
}
