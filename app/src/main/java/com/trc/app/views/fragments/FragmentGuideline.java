package com.trc.app.views.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trc.app.R;
import com.trc.app.models.Guideline;
import com.trc.app.utils.ConstantKey;
import com.trc.app.views.adapters.GuidelineAdapter;

import java.util.ArrayList;

public class FragmentGuideline extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guideline, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.guideline_recycler_view);
        initRecyclerView(mRecyclerView, ConstantKey.getGuidelines());

        return view;
    }

    private void initRecyclerView(RecyclerView mRecyclerView, ArrayList<Guideline> arrayList) {
        GuidelineAdapter mAdapter = new GuidelineAdapter(getActivity(), arrayList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(5 /*px spacing*/));
        mAdapter.notifyDataSetChanged();
    }
}