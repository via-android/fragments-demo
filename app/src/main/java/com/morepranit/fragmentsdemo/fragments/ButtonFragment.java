package com.morepranit.fragmentsdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.morepranit.fragmentsdemo.R;

public class ButtonFragment extends Fragment {
    OnButtonClickListener onButtonClickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);

        Button btnClick = view.findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClickListener.onButtonClick(view, "hello");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof OnButtonClickListener) {
            onButtonClickListener = (OnButtonClickListener) context;
        } else {
            throw new ClassCastException("Activity must implement ButtonFragment.OnButtonClickListener");
        }
        super.onAttach(context);
    }

    public interface OnButtonClickListener {
        void onButtonClick(View view, String txt);
    }
}
