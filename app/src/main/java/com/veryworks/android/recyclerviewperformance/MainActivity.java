package com.veryworks.android.recyclerviewperformance;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.veryworks.android.recyclerviewperformance.contract.UserContract;
import com.veryworks.android.recyclerviewperformance.p.UserPresenter;
import com.veryworks.android.recyclerviewperformance.v.UserFragment;

public class MainActivity extends AppCompatActivity{

    public UserContract.Presenter presenter = null;
    public UserFragment view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        process();
    }

    public void process(){
        new AsyncTask<MainActivity,Void,MainActivity>(){

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("Loading...");
                dialog.show();
            }

            @Override
            protected MainActivity doInBackground(MainActivity... params) {
                MainActivity activity = params[0];

                activity.presenter = new UserPresenter();
                activity.view = new UserFragment();
                activity.presenter.attachView(activity.view);
                activity.presenter.loadItems();
                activity.presenter.setDatas();
                return activity;
            }

            @Override
            protected void onPostExecute(MainActivity initializer) {
                init();
                dialog.dismiss();
            }
        }.execute(this);

    }

    public void init(){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.framelayout, view).commit();
    }
}
