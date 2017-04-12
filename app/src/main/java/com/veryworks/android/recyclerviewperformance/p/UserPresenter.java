package com.veryworks.android.recyclerviewperformance.p;

import android.content.Context;
import android.util.Log;

import com.veryworks.android.recyclerviewperformance.contract.UserContract;
import com.veryworks.android.recyclerviewperformance.m.UserModel;
import com.veryworks.android.recyclerviewperformance.v.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 1/22/2017.
 */

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;
    private List<UserModel> users = new ArrayList<>();
    private List<ViewModel> datas = new ArrayList<>();

    public UserPresenter() {

    }

    @Override
    public void attachView(UserContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadItems() {
        // url : https://api.github.com/users
        // view.setMessage("Main Activity!!!");
        // Loading
        users.clear();
        for(int i=0;i<10000;i++){
            UserModel user = new UserModel();
            user.setId(i);
            user.setAvatar_url("image Uri"+i);
            user.setUrl("url_"+i);
            Log.i("LOADER","test================="+i);
            users.add(user);
        }
        // Setting
        datas.clear();
        for(UserModel user : users){
            ViewModel data = new ViewModel();
            data.setId(user.getId());
            data.setImage(user.getAvatar_url());
            data.setTitle(user.getUrl());
            datas.add(data);
        }
    }

    @Override
    public void setDatas(){
        view.setData(datas);
    }

    @Override
    public void refreshList() {

    }

    @Override
    public void loadActivity(Context context) {

    }
}
