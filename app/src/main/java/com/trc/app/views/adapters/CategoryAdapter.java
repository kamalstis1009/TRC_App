package com.trc.app.views.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.trc.app.R;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private FragmentActivity mActivity;
    private ArrayList<String> mArrayList;

    public CategoryAdapter(FragmentActivity context, ArrayList<String> arrayList) {
        this.mActivity = context;
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = mArrayList.get(position);
        holder.textView.setText(title);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                bundle.putString("category", title);
                FragmentCategoryWiseProduct mFragment = new FragmentCategoryWiseProduct();
                mFragment.setArguments(bundle);
                Utility.getInstance().onAddFragment(Objects.requireNonNull(mActivity).getSupportFragmentManager(), mFragment);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.category_layout);
            textView = (TextView) itemView.findViewById(R.id.category_title);
        }
    }
}