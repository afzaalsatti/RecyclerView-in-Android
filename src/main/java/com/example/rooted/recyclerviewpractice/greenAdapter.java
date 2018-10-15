package com.example.rooted.recyclerviewpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class greenAdapter extends RecyclerView.Adapter<greenAdapter.holder>{
    int count=5;
private Context mcontext;
    List lines;
    List number;
    public greenAdapter(Context c,List number,List lines) {
mcontext=c;
this.lines=lines;
this.number=number;
       // this.count=count;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View view =inflater.inflate(R.layout.geenadapterpattern,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.t1.setText(""+number.get(position));
        holder.t2.setText(""+lines.get(position));

    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public class holder extends RecyclerView.ViewHolder
    {
TextView t1,t2;

        public holder(@NonNull View itemView) {

            super(itemView);
            t1=itemView.findViewById(R.id.Partysizenumber);
            t2=itemView.findViewById(R.id.Partypartname);


        }
    }
}
