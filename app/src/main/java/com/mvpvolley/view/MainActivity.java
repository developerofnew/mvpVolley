package com.mvpvolley.view;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mvpvolley.AdapterRecycler;
import com.mvpvolley.Mvp_Interface;
import com.mvpvolley.Pojo;
import com.mvpvolley.Pojo2;
import com.mvpvolley.R;
import com.mvpvolley.model.VolleySingleton;
import com.mvpvolley.presenter.Presenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Mvp_Interface.View {

    Mvp_Interface.Presenter presenter;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    Parcelable savedRecyclerLayoutState;
    static final String BUNDLE_RECYCLER_LAYOUT = "recycler_layout";

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        presenter = new Presenter(this);

        presenter.setView(this);

        presenter.loadData();
    }


//    @Override
//    public void setPresenter(Mvp_Interface.Presenter presenter) {
//
//        if(presenter !=  null){
//
//            this.presenter = presenter;
//        }
//    }
    @Override
    protected void onResume() {
        super.onResume();

      //  getJson();






//        String url = "https://jsonplaceholder.typicode.com/photos";


    }



    @Override
    public void showResult(List<Pojo2> arrayList) {



        recyclerView =  findViewById(R.id.recycler);

//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setAdapter(new AdapterRecycler(this,arrayList));


        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        AdapterRecycler adapter = new AdapterRecycler(this,arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

     //   mListState = outState.getParcelable()

      //  outState.putParcelable(BUNDLE_RECYCLER_LAYOUT,mLayoutManager.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //restore recycler at same position
        if(savedInstanceState != null){

            savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT);
        }
    }



    @Override
    public void startLoading() {


      //  Toast.makeText(this, "check", Toast.LENGTH_LONG).show();
    }

    @Override
    public void stopLoading() {



    }

    @Override
    public void showLoadError() {

    }




}
