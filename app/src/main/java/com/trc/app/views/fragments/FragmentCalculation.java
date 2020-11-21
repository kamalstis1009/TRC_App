package com.trc.app.views.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trc.app.R;

public class FragmentCalculation extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculation, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Calculation");

        return view;
    }
}