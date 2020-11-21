package com.trc.app.views.adapters;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        Guideline model = mArrayList.get(position);

        //holder.imageView.setImageResource(model.getIcon());
        //holder.imageView.setColorFilter(mActivity.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        holder.itemTitle.setText(model.getGuideTitle());
        holder.itemTitle.setText(model.getGuideText());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        ImageView imageView;
        TextView itemTitle, itemDetails, itemDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
            imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            itemDetails = (TextView) itemView.findViewById(R.id.item_details);
            itemDate = (TextView) itemView.findViewById(R.id.item_date);
        }
    }
}
