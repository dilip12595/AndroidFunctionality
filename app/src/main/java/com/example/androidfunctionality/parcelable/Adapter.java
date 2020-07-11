package com.example.androidfunctionality.parcelable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfunctionality.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {

    private ArrayList<Item> item ;
    private OnItemClickListener listener;

    public Adapter(ArrayList<Item> itemList) {

        this.item = itemList;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_view_item,parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Item currentItem = item.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.subTitle.setText(currentItem.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView subTitle;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            title = itemView.findViewById(R.id.text_view1);
            subTitle = itemView.findViewById(R.id.text_view2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
