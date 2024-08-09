package com.example.fragmentactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameHolder> {

    ArrayList<Name>names;
    OnItemClickListener listener;

    public NameAdapter(ArrayList<Name> names,OnItemClickListener listener) {
        this.listener=listener;
        this.names = names;
    }

    @NonNull
    @Override
    public NameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_layout,parent,false);
        return new NameHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameHolder holder, int position) {
     Name name=names.get(position);
     holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        Name name;
        public NameHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.custom_tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name);
                }
            });
        }
        void bind(Name name){
            this.name=name;
            tv_name.setText(name.getName());
        }
    }
}
