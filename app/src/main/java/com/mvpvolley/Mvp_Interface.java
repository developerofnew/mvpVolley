package com.mvpvolley;

import com.android.volley.VolleyError;
import com.mvpvolley.presenter.ResponseInterfaceToPresenter;

import java.util.ArrayList;
import java.util.List;

public interface Mvp_Interface {

    interface Model{



     //   void loadData(String url, ResponseInterfaceToPresenter responseInterfaceToPresenter);

        void setData(String name, String password);


    }


    interface View{

       //send to adapter
        void showResult(List<Pojo2> arrayList);

      //  void setPresenter(Presenter presenter);

        void startLoading();

        void stopLoading();

        void showLoadError();

    }

    interface Presenter{

        void setView(Mvp_Interface.View view);

        //send url & this to model
        void loadData();





    }











}
