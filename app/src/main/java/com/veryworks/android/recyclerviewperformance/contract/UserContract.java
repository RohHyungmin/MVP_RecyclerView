package com.veryworks.android.recyclerviewperformance.contract;

import android.content.Context;

import com.veryworks.android.recyclerviewperformance.v.ViewModel;

import java.util.List;

public interface UserContract {

    interface View {
        void setData(List<ViewModel> list);
        void setMessage(String msg);
        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void attachView(View view);
        void setDatas();
        void detachView();
        void loadItems();
        void refreshList();
        void loadActivity(Context context);
    }
}
