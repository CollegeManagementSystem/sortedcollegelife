package com.example.sortedcollegelife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class mainchatadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mcontext;
    ArrayList<LiveChatData>mdata;
    public mainchatadapter(Context mcontext,ArrayList<LiveChatData> mdata){
        this.mcontext=mcontext;
        this.mdata=mdata;
    }
    @Override
    public int getItemViewType(int position) {
        return mdata.get(position).getSedRec();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==1){
            return new MessageSandViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.mainchatsend,viewGroup,false));
        }
        else{
            return new MessageReceiveViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.mainchatreceive,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof MessageSandViewHolder)
        {
            ((MessageSandViewHolder) viewHolder).mTextSend.setText(mdata.get(i).getData());
        }
        if(viewHolder instanceof MessageReceiveViewHolder)
        {
            ((MessageReceiveViewHolder) viewHolder).mTextRec.setText(mdata.get(i).getData());
        }
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
    class MessageSandViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextSend;
        MessageSandViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextSend=itemView.findViewById(R.id.mainchatsendlayout);
        }
    }
    class MessageReceiveViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextRec;
        MessageReceiveViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextRec=itemView.findViewById(R.id.mainchatreceivelayout);
        }
    }
}
   /*

    }


    class MessageSandViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextSend;
        MessageSandViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextSend=itemView.findViewById(R.id.mainchatsendlayout);
        }
    }
    class MessageReceiveViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextRec;
        MessageReceiveViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextRec=itemView.findViewById(R.id.mainchatreceivelayout;
        }
    }
    public class ViewHolderSetActivelist extends RecyclerView.ViewHolder {
        TextView mtext,mtext1;
        View mainview;
        public ViewHolderSetActivelist(@NonNull View itemView) {
            super(itemView);
            mainview=itemView;
            mtext=itemView.findViewById(R.id.mainchatsendlayout);
            mtext1=itemView.findViewById(R.id.mainchatreceivelayout);
        }

        public void setlisteren(int i) {

        }
    }
}
*/