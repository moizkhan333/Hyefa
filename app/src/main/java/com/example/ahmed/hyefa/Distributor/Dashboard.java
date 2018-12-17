package com.example.ahmed.hyefa.Distributor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ahmed.hyefa.Employee.Emp_Announcement_Manager;
import com.example.ahmed.hyefa.Employee.Task_Detail_Employee;
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
        View view = inflater.inflate(R.layout.frag_employee_dashboard, container, false);


        LinearLayout tskdet = (LinearLayout) view.findViewById(R.id.taskdetails);
        tskdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Task_Detail_Distributor.class);
                startActivity(in);
            }
        });


        LinearLayout ann = (LinearLayout) view.findViewById(R.id.announcement);
        ann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Dist_Announcement_Manager.class);
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