package com.mvpvolley.presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mvpvolley.Contact;
import com.mvpvolley.Mvp_Interface;
import com.mvpvolley.Pojo;
import com.mvpvolley.Pojo2;
import com.mvpvolley.model.DataModel;
import com.mvpvolley.view.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presenter implements Mvp_Interface.Presenter, ResponseInterfaceToPresenter {


     Mvp_Interface.View view;
    Context context;
     List<Pojo2> pojoList = new ArrayList<>();
     DataModel model;


    public Presenter( Context context) {
       // this.view = view;
        this.context = context;
      //  this.pojoList = pojoList;
        model = new DataModel(context);

      //  this.view.setPresenter(this);
      //  view = new MainActivity();
    }

    @Override
    public void setView(Mvp_Interface.View view) {

        this.view = view;

    }

    @Override
    public void loadData() {


      //  " https://jsonplaceholder.typicode.com/photos"
        view.startLoading();
        model.loadData(" http://www.techsolpoint.com/api_example/api.json" ,this);
    }


    @Override
    public void onSuccess(String result) {


        Toast.makeText(context, "njnkjkjkjkjkj", Toast.LENGTH_SHORT).show();


        try {
            Gson gson = new Gson();

//            Object Json = new JSONTokener(result).nextValue();
//
//            JSONObject jsonObject = (JSONObject)Json; //new JSONObject(result);

            JSONObject jsonObject = new JSONObject(result);

            JSONArray jsonArray = jsonObject.getJSONArray("list");




                for (int i =0; i < jsonArray.length();i++){

                    JSONObject contacts = jsonArray.getJSONObject(i);


                      Pojo2 pojo2 = gson.fromJson(String.valueOf(contacts),Pojo2.class);

                    pojoList.add(pojo2);


            }

            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();


        } catch (JSONException e) {
            e.printStackTrace();
        }

        // List<Pojo> pojo =  Arrays.asList(gson.fromJson(result,Pojo[].class));

      //  List<Pojo2> pojo2s =  gson.fromJson(result,Pojo2.class);

      //  Pojo pojo1 = gson.fr

      // Pojo  mPojo =     gson.fromJson(result,Pojo.class);

      // pojoList.add(mPojo);



        view.showResult(pojoList);
        view.stopLoading();
    }

    @Override
    public void onError(Volley error) {

        view.showLoadError();
        view.stopLoading();
    }

}
