package com.example.android1_lesson8;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    List<Element> elements;
    RecyclerView recyclerView;
    Adapter adapter;
    MainActivity activity;

    public FragmentList() {
        elements = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_fragment_list, container, false);

        activity = new MainActivity();

        recyclerView = v.findViewById(R.id.recycler);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(manager);

        Button add = v.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        final Button element = v.findViewById(R.id.element);
        element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (elements.isEmpty()) {
                    return;
                }
                showElement(elements.get(0));
            }
        });
        return v;
    }

    public void add() {
        MainActivity activity = (MainActivity) getActivity();
        activity.showAddFragment();
    }

    public void saveElement(Element element) {
        elements.add(element);
        adapter.addSomeText(element.text);
        adapter.notifyDataSetChanged();
    }

    public void showElement(Element element) {
        MainActivity activity = (MainActivity) getActivity();
        activity.showShowFragment(element);
    }
}