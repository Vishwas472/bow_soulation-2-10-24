package com.example.advanceview.Tablayout.Tablayouts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.advanceview.R;


public class SatausFragment extends Fragment {
    LinearLayout layout;



    public SatausFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_sataus, container, false);
        LinearLayout layout = view.findViewById(R.id.l222);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClickInFragment(view);
            }


        }); return view;

    }

    private void buttonClickInFragment(View view) {
        if (getActivity() instanceof OnButtonClickListener) {
            ((OnButtonClickListener) getActivity()).onButtonClicked(view);
        }


    }

}
