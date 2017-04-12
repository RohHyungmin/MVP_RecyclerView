package com.veryworks.android.recyclerviewperformance.v;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.veryworks.android.recyclerviewperformance.R;
import com.veryworks.android.recyclerviewperformance.contract.UserContract;

import java.util.List;

public class UserFragment extends Fragment implements UserContract.View, View.OnClickListener{

    UserContract.Presenter presenter;
    View mainView = null;
    RecyclerView listView = null;
    RecyclerAdapter adapter = null;
    List<ViewModel> datas = null;

    public UserFragment() {
        // Required empty public constructor
    }

    public void setPresenter(UserContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_task, container, false);
        listView = (RecyclerView) mainView.findViewById(R.id.listView);
        return mainView;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new RecyclerAdapter(datas);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setData(List<ViewModel> list) {
        datas = list;
    }

    @Override
    public void setMessage(String msg) {
        // nothing
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
