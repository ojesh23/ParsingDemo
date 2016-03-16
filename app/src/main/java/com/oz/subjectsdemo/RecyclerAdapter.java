package com.oz.subjectsdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;



/**
 * Created by Ojesh on 3/2/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    public Context context;
    public ArrayList<Subject> list;

    public RecyclerAdapter(Context context, ArrayList<Subject> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Subject sub=list.get(position);
      //  holder.txtId.setText(sub.id);
        holder.txtName.setText(sub.subName);



    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView txtId,txtName;
        public final Context context;
        public MyHolder(View itemView) {
            super(itemView);
            //txtId=(TextView)itemView.findViewById(R.id.classId);
            txtName=(TextView)itemView.findViewById(R.id.subName);
            context=itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Item postion:"+getPosition(),Toast.LENGTH_SHORT).show();
                    Intent intent=null;
                    switch (getPosition()){
                        case 0:
                           intent=new Intent(context, ScienceActivity.class);
                            break;




                    }
                    context.startActivity(intent);
                }
            });
        }
    }

}
