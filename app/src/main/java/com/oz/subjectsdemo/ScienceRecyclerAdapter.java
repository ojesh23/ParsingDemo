package com.oz.subjectsdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ojesh on 3/14/2016.
 */
public class ScienceRecyclerAdapter extends RecyclerView.Adapter<ScienceRecyclerAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<Science> list;

    public ScienceRecyclerAdapter(Context context, ArrayList<Science> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.science_row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Science science=list.get(position);
        holder.txtLessonName.setText(science.lessonName);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtLessonName;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtLessonName=(TextView)itemView.findViewById(R.id.lessonName);
        }
    }
}
