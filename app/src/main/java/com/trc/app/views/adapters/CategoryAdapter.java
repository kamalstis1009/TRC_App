package com.trc.app.views.adapters;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.trc.app.R;
import com.trc.app.models.Category;
import com.trc.app.utils.Utility;
import com.trc.app.views.fragments.FragmentAbout;
import com.trc.app.views.fragments.FragmentConsultant;
import com.trc.app.views.fragments.FragmentGuideline;

import java.util.ArrayList;
import java.util.Objects;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private FragmentActivity mActivity;
    private ArrayList<Category> mArrayList;

    public CategoryAdapter(FragmentActivity context, ArrayList<Category> arrayList) {
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
        Category model = mArrayList.get(position);

        holder.imageView.setImageResource(model.getIcon());
        holder.imageView.setColorFilter(mActivity.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        holder.textView.setText(model.getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle bundle = new Bundle();
                bundle.putString("category", title);
                FragmentCategoryWiseProduct mFragment = new FragmentCategoryWiseProduct();
                mFragment.setArguments(bundle);
                Utility.getInstance().onAddFragment(Objects.requireNonNull(mActivity).getSupportFragmentManager(), mFragment);*/

                if (model.getId() == 1) {
                    Utility.getInstance().onAddFragment(Objects.requireNonNull(mActivity).getSupportFragmentManager(), new FragmentAbout());
                } else if (model.getId() == 2) {
                    Utility.getInstance().onAddFragment(Objects.requireNonNull(mActivity).getSupportFragmentManager(), new FragmentGuideline());
                } else if (model.getId() == 3) {
                    Utility.getInstance().onAddFragment(Objects.requireNonNull(mActivity).getSupportFragmentManager(), new FragmentConsultant());
                } else if (model.getId() == 4) {
                    //
                } else if (model.getId() == 5) {
                    //
                } else if (model.getId() == 6) {
                    //
                } else if (model.getId() == 7) {
                    //
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout layout;
        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (RelativeLayout) itemView.findViewById(R.id.category_layout);
            imageView = (ImageView) itemView.findViewById(R.id.category_icon);
            textView = (TextView) itemView.findViewById(R.id.category_title);
        }
    }
}