package com.example.quanlycongan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder>{

    private ArrayList<StaticRvModel> items;
    int row_index = -1;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean selected = true;

    public StaticRvAdapter(ArrayList<StaticRvModel> items, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.items = items;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Lien ket xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return  staticRVViewHolder;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
        StaticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        if (check){

            ArrayList<PoliceRVModel> items =  new ArrayList<PoliceRVModel>();
            items.add(new PoliceRVModel("Bế Văn Thành",R.drawable.policevietnam,"Đại tá","Đà Nẵng","VietNam",0));
            items.add(new PoliceRVModel("Nguyễn Văn Cảnh",R.drawable.policevietnam,"Thiếu tá","TPHCM","VietNam",0));
            items.add(new PoliceRVModel("Đặng Thùy Trâm",R.drawable.policevietnam,"Trung tá","Hà Nội","VietNam",0));
            items.add(new PoliceRVModel("Đặng Ngọc Sơn",R.drawable.policevietnam,"Đại úy","Đà Nẵng","VietNam",0));
            items.add(new PoliceRVModel("Phạm Minh Chính",R.drawable.policevietnam,"Thượng tá","Huế","VietNam",0));
            items.add(new PoliceRVModel("Trần Ngọc Việt",R.drawable.policevietnam,"Đại tá","Đà Nẵng","VietNam",0));

            updateRecyclerView.callback(position, items);

            check   = false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();

                if (position==0){
                    ArrayList<PoliceRVModel> items =  new ArrayList<PoliceRVModel>();
                    items.add(new PoliceRVModel("Bế Văn Thành",R.drawable.policevietnam,"Đại tá","Đà Nẵng","VietNam",0));
                    items.add(new PoliceRVModel("Nguyễn Văn Cảnh",R.drawable.policevietnam,"Thiếu tá","TPHCM","VietNam",0));
                    items.add(new PoliceRVModel("Đặng Thùy Trâm",R.drawable.policevietnam,"Trung tá","Hà Nội","VietNam",0));
                    items.add(new PoliceRVModel("Đặng Ngọc Sơn",R.drawable.policevietnam,"Captain","Đà Nẵng","VietNam",0));
                    items.add(new PoliceRVModel("Phạm Minh Chính",R.drawable.policevietnam,"Thượng tá","Huế","VietNam",0));
                    items.add(new PoliceRVModel("Trần Ngọc Việt",R.drawable.policevietnam,"Đại tá","Đà Nẵng","VietNam",0));
                    updateRecyclerView.callback(position, items);

                }

                else if (position==1){
                    ArrayList<PoliceRVModel> items =  new ArrayList<PoliceRVModel>();
                    items.add(new PoliceRVModel("Min-jun",R.drawable.policevietnam,"Colonel","Seoul","Korea",1));
                    items.add(new PoliceRVModel("Seo-jun",R.drawable.policevietnam,"Lieutenant Colonel","Gangwon","Korea",1));
                    items.add(new PoliceRVModel("Ha-joon",R.drawable.policevietnam,"Captain","Busan","Korea",1));
                    items.add(new PoliceRVModel("Do-yun",R.drawable.policevietnam," Brigadier general","Gyeonggi","Korea",1));
                    items.add(new PoliceRVModel("Joo-won",R.drawable.policevietnam," Brigadier general","Gimcheon","Korea",1));
                    items.add(new PoliceRVModel("Ye-jun",R.drawable.policevietnam,"Colonel","Gunsan","Korea",1));
                    updateRecyclerView.callback(position, items);
                }

                else if (position==2){
                    ArrayList<PoliceRVModel> items =  new ArrayList<PoliceRVModel>();
                    items.add(new PoliceRVModel("Alan",R.drawable.policevietnam,"Colonel","London","England",2));
                    items.add(new PoliceRVModel("Alexander",R.drawable.policevietnam,"Colonelá","Birmingham","England",2));
                    items.add(new PoliceRVModel("Charles",R.drawable.policevietnam,"Colonel","Glasgow","England",2));
                    items.add(new PoliceRVModel("Marcus",R.drawable.policevietnam,"Lieutenant Colonel","Edinburgh","England",2));
                    items.add(new PoliceRVModel("William",R.drawable.policevietnam,"Colonel","Kingston upon Hull","England",2));
                    items.add(new PoliceRVModel("Vincent",R.drawable.policevietnam,"Lieutenant Colonel","Bradford","England",2));

                    updateRecyclerView.callback(position, items);
                }
            }
        });
//
        if (selected){
            if (position==0)
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            selected = false;
        }
        else {
            if (row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            }
            else{
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
            }
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
