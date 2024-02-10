package com.example.advanceview.Tablayout.Tablayouts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.advanceview.R;

public class ChatFragment extends Fragment {



    public ChatFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);



//        loadData();
     LinearLayout layout = view.findViewById(R.id.li11111);
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


//    public void loadData() {
//
//        linearLayout11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Chats Fragment!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}