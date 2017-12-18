package io.github.alexlondon07.cardviewandreciclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alexlondon07 on 12/17/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<String> names;
    private int layout;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<String> names, int layout, OnItemClickListener onItemClickListener) {
        this.names = names;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflamos la vista con nuestro Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;

        public ViewHolder(View v){
            super(v);
            this.textViewName = v.findViewById(R.id.textViewName);
        }

        public void bind(final String name, final OnItemClickListener listener){

            this.textViewName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(String name, int position);
    }
}
