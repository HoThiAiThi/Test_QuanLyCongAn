package com.example.quanlycongan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class PoliceActivity extends AppCompatActivity implements UpdateRecyclerView{
    private RecyclerView recyclerView, recyclerView2;
    private StaticRvAdapter staticRvAdapter;

    ArrayList<PoliceRVModel> items = new ArrayList<>();
    PoliceRVAdapter dynamicRVAdapter;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        final ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.policevietnam, "Viet Nam"));
        item.add(new StaticRvModel(R.drawable.policekorea, "Korea"));
        item.add(new StaticRvModel(R.drawable.policeengland, "England"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item, PoliceActivity.this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(PoliceActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);


        items = new ArrayList<>();

        recyclerView2 = findViewById(R.id.rv_2);
        dynamicRVAdapter = new PoliceRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(PoliceActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);

    }

    @Override
    public void callback(int position, ArrayList<PoliceRVModel> items) {

        dynamicRVAdapter = new PoliceRVAdapter(items);
        dynamicRVAdapter.notifyDataSetChanged();
        recyclerView2.setAdapter(dynamicRVAdapter);
    }
}