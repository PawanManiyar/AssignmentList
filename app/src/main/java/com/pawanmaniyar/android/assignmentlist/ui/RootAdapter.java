package com.pawanmaniyar.android.assignmentlist.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pawanmaniyar.android.assignmentlist.R;
import com.pawanmaniyar.android.assignmentlist.data.Root;

import java.util.ArrayList;
import java.util.List;

public class RootAdapter extends RecyclerView.Adapter<RootAdapter.MyHolderView> {

    private List<Root> rootList = new ArrayList<>();
    @NonNull
    @Override
    public RootAdapter.MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.root_item, parent,false);
        return new MyHolderView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RootAdapter.MyHolderView holder, int position) {
        Root root = rootList.get(position);

        Glide.with(holder.imgRoot)
                .load(root.getUrl())
                .into(holder.imgRoot);
    }

    @Override
    public int getItemCount() {
        return rootList.size();
    }

    public void setRootList(List<Root> rootList) {
        this.rootList = rootList;
        notifyDataSetChanged();
    }

    class MyHolderView extends RecyclerView.ViewHolder {
        private ImageView imgRoot;

        public MyHolderView(@NonNull View view) {
            super(view);

            imgRoot = view.findViewById(R.id.imageRoot);
        }
    }
}
