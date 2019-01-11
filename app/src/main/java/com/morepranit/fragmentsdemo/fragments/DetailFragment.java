package com.morepranit.fragmentsdemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.morepranit.fragmentsdemo.R;

public class DetailFragment extends Fragment {
    TextView txtDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        txtDetail = view.findViewById(R.id.txt_detail);

        Bundle bundle = getArguments();
        if (bundle != null) {
            setText(bundle.getString("text_key"));
        }

        return view;
    }

    public void setText(String txt) {
        txtDetail.setText(txt);
    }
}
