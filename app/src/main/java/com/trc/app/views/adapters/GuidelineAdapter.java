package com.trc.app.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.trc.app.R;
import com.trc.app.models.Guideline;

import java.util.ArrayList;

public class GuidelineAdapter extends RecyclerView.Adapter<GuidelineAdapter.MyViewHolder> {

    private FragmentActivity mActivity;
    private ArrayList<Guideline> mArrayList;

    public GuidelineAdapter(FragmentActivity activity, ArrayList<Guideline> arrayList) {
        this.mActivity = activity;
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guideline, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
