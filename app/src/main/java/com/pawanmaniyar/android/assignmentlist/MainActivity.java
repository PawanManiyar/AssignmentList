package com.pawanmaniyar.android.assignmentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.pawanmaniyar.android.assignmentlist.data.Root;
import com.pawanmaniyar.android.assignmentlist.ui.RootAdapter;
import com.pawanmaniyar.android.assignmentlist.viewmodel.RootViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RootViewModel rootViewModel;
    private RootAdapter rootAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootAdapter = new RootAdapter();

        rootViewModel =new ViewModelProvider(this).get(RootViewModel.class);
        rootViewModel.init();
        rootViewModel.searchRoot("100","10","Desc");

        rootViewModel.getRootLiveData().observe(this, new Observer<List<Root>>() {
            @Override
            public void onChanged(List<Root> rootList) {
                if(rootList != null) {
                    rootAdapter.setRootList(rootList);
                }
            }
        });

        recyclerView = findViewById(R.id.rootRecyclerView);
        StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(rootAdapter);

    }
}