package com.example.android1_lesson8;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentShow extends Fragment {

    TextView title;
    Element element;

    public FragmentShow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_show, container, false);
        title = v.findViewById(R.id.element_title);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (element != null) {
            title.setText(element.text);
        } else {
            title.setText("No element");
        }
    }

    public void showElement(Element element) {
        this.element = element;
    }
}
