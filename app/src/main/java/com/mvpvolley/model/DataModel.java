package com.mvpvolley.model;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mvpvolley.Mvp_Interface;
import com.mvpvolley.presenter.ResponseInterfaceToPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;


public class DataModel implements  Mvp_Interface.Model {


   Context context;


    public DataModel( Context context) {

        this.context = context;

    }




    public void loadData(String url, final ResponseInterfaceToPresenter responseInterfaceToPresenter) {


        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                responseInterfaceToPresenter.onSuccess(response);


//                Object json;
//
//                try {
//                    json = new JSONTokener(response).nextValue();
//
//                    JSONObject jsonObject = (JSONObject)json;
//
//                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");
//
//                    for (int i = 0;i < jsonArray.length();i++){
//
//
//                        JSONObject c = jsonArray.getJSONObject(i);
//
//                        String name = c.getString("name");
//                        String email = c.getString("email");
//
//                        JSONObject phone = c.getJSONObject("phone");
//
//                        String mobile = phone.getString("mobile");
//
//                        responseInterfaceToPresenter.onSuccess(mobile);

                      //  Toast.makeText(context, "mjmjjjj"+mobile, Toast.LENGTH_SHORT).show();

                   //     list.add(new Pojo(name,email,mobile));

//                        HashMap<String,String>  contactMap = new HashMap<>();
//
//                        contactMap.put("name",name);
//                        contactMap.put("email",email);
//                        contactMap.put("mobile",mobile);
//
//
//                        list.add(contactMap);
//
//                    }
//
//
//                  //  recyclerView.setAdapter(new MyAdapter(list,getApplicationContext()));
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);


//
//        responseInterfaceToPresenter.onSuccess(response);
//        requestQueue = Volley.newRequestQueue(context);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Toast.makeText(context, "new new new", Toast.LENGTH_SHORT).show();
//
//
//
//             //   responseInterfaceToPresenter.onSucess(response);
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(stringRequest);
    }

    @Override
    public void setData(String name, String password) {

    }
}
