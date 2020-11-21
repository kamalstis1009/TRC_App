package com.trc.app.views.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trc.app.R;
import com.trc.app.models.Consultant;
import com.trc.app.utils.ConstantKey;
import com.trc.app.utils.GridSpacingItemDecoration;
import com.trc.app.views.adapters.ConsultantAdapter;

import java.util.ArrayList;

public class FragmentConsultant extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_consultant, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Consultant");

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.consultant_recycler_view);
        initRecyclerView(mRecyclerView, ConstantKey.getConsultants());

        return view;
    }

    private void initRecyclerView(RecyclerView mRecyclerView, ArrayList<Consultant> arrayList) {
        ConsultantAdapter mAdapter = new ConsultantAdapter(getActivity(), arrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2 /*spanCount*/, 5 /*px spacing*/, false /*includeEdge*/));
        mAdapter.notifyDataSetChanged();
    }
}