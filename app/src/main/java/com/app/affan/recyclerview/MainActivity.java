package com.app.affan.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.affan.recyclerview.adapters.StickyContactsAdapter;
import org.zakariya.stickyheaders.StickyHeaderLayoutManager;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StickyContactsAdapter adapter = new StickyContactsAdapter();
        adapter.setContactList();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.VISIBLE);

    }



}