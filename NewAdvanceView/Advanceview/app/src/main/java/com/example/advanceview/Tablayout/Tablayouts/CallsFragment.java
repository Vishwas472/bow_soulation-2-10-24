package com.example.advanceview.Tablayout.Tablayouts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.advanceview.R;

public class CallsFragment extends Fragment {
    LinearLayout callsfragment;


    public CallsFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_calls, container, false);


//        loadData();
        LinearLayout layout = view.findViewById(R.id.calss);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickInFragment(view);
            }
        });
        return view;
    }

    private void buttonClickInFragment(View view) {
        if (getActivity() instanceof OnButtonClickListener) {
            ((OnButtonClickListener) getActivity()).onButtonClicked(view);
        }


    }

}