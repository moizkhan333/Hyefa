package com.example.ahmed.hyefa.Manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ahmed.hyefa.R;


/**
 * Created by Ahmed on 11/23/2018.
 */

public class Dashboard extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.frag_manager_dashboard, container, false);

        LinearLayout emplay = (LinearLayout) view.findViewById(R.id.employee);
        emplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Employee.class);
                startActivity(in);
            }
        });

        LinearLayout dislay = (LinearLayout) view.findViewById(R.id.distributor);
        dislay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Distributor.class);
                startActivity(in);
            }
        });

        LinearLayout tskdet = (LinearLayout) view.findViewById(R.id.taskdetails);
        tskdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), TaskDetail.class);
                startActivity(in);
            }
        });


        LinearLayout ann = (LinearLayout) view.findViewById(R.id.announcement);
        ann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Announcement.class);
                startActivity(in);
            }
        });


        return view;


        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Dashboard");
    }
}