package com.example.quanlycongan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PoliceRVAdapter extends RecyclerView.Adapter<PoliceRVAdapter.PoliceRvHolder>{
    public ArrayList<PoliceRVModel> policeRVModels;
    private  OnItemClickListner mListner;


    public interface  OnItemClickListner{
        void  onItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner mListner){
        this.mListner = mListner;
    }

    public PoliceRVAdapter(ArrayList<PoliceRVModel> policeRVModels){
        this.policeRVModels = policeRVModels;
    }

    public class PoliceRvHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        //ConstraintLayout constraintLayout;

        public PoliceRvHolder(@NonNull View itemView, final OnItemClickListner mListner) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView1 = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.capbac);
            textView3 = itemView.findViewById(R.id.noicongtac);
            textView4 = itemView.findViewById(R.id.quocgia);
            //constraintLayout = itemView.findViewById(R.id.constraintlayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListner!=null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public PoliceRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.police_rv_item_layout,parent,false);
        PoliceRvHolder dynamicRvHolder = new PoliceRvHolder(view, mListner);
        return dynamicRvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PoliceRvHolder holder, int position) {
        PoliceRVModel currentItem = policeRVModels.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCapbac());
        holder.textView3.setText(currentItem.getNoicongtac());
    }

    @Override
    public int getItemCount() {
        return policeRVModels.size();
    }
}
