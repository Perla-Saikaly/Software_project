package com.example.software_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class NewPhoneFragment extends Fragment {
    RecyclerView NewPhoneRecView;
    ArrayList newPhoneImages, newPhoneName, newPhoneStatus, newPhonePrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_phone, container, false);


        newPhoneImages = new ArrayList();
        newPhoneName= new ArrayList();
       newPhoneStatus = new ArrayList();
        newPhonePrice = new ArrayList();

        for (int i = 0; i < com.example.software_project.NewPhoneDataBase.newPhoneNames.length; i++) {
            newPhoneImages.add(com.example.software_project.NewPhoneDataBase.newPhoneImages);
            newPhoneName.add(com.example.software_project.NewPhoneDataBase.newPhoneNames);
            newPhoneStatus.add(com.example.software_project.NewPhoneDataBase.newPhoneStatus);
            newPhonePrice.add(com.example.software_project.NewPhoneDataBase.newPhonePrice);
        }


        NewPhoneRecView = view.findViewById(R.id.NewphoneRecView);
        NewPhoneRecViewAdapter NewBookAdapter = new NewPhoneRecViewAdapter(getContext(), newPhoneImages, newPhoneName, newPhoneStatus, newPhonePrice);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        NewPhoneRecView.setLayoutManager(linearLayoutManager);
        NewPhoneRecView.setAdapter(NewBookAdapter);


        return view;
    }
}