package com.trc.app.views.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trc.app.R;
import com.trc.app.utils.Utility;

import java.util.Objects;

public class FragmentApplicationForm extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_form, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Application Form");

        ((Button) view.findViewById(R.id.user_submit_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.getInstance().onAddFragment(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), new FragmentHome());
            }
        });

        return view;
    }
}