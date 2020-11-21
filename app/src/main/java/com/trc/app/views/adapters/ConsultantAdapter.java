package com.trc.app.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.trc.app.R;
import com.trc.app.models.Consultant;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConsultantAdapter extends RecyclerView.Adapter<ConsultantAdapter.MyViewHolder> {

    private FragmentActivity mActivity;
    private ArrayList<Consultant> mArrayList;

    public ConsultantAdapter(FragmentActivity activity, ArrayList<Consultant> arrayList) {
        this.mActivity = activity;
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_consultant, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Consultant model = mArrayList.get(position);

        //holder.imageView.setImageResource(model.getIcon());
        //holder.imageView.setColorFilter(mActivity.getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        holder.name.setText(model.getName());
        holder.designation.setText(model.getDesignation());
        holder.phone.setText(model.getPhone());
        holder.experience.setText(model.getExperience());
        holder.qualification.setText(model.getQualification());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;
        CircleImageView imageView;
        TextView name, designation, phone, experience, qualification;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
            imageView = (CircleImageView) itemView.findViewById(R.id.user_photo);
            name = (TextView) itemView.findViewById(R.id.user_name);
            designation = (TextView) itemView.findViewById(R.id.user_designation);
            phone = (TextView) itemView.findViewById(R.id.user_phone);
            experience = (TextView) itemView.findViewById(R.id.user_experience);
            qualification = (TextView) itemView.findViewById(R.id.user_qualification);
        }
    }
}
