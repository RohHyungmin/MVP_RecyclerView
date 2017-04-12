package com.veryworks.android.recyclerviewperformance.v;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veryworks.android.recyclerviewperformance.R;

import java.util.List;

/**
 * Created by pc on 4/13/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{
    List<ViewModel> datas;

    public RecyclerAdapter(List<ViewModel> datas){
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ViewModel data = datas.get(position);
        holder.no.setText(data.getId()+"");
        holder.title.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView no;
        TextView title;
        public Holder(View itemView) {
            super(itemView);
            no = (TextView)itemView.findViewById(R.id.txtNo);
            title = (TextView)itemView.findViewById(R.id.txtTitle);
        }
    }
}