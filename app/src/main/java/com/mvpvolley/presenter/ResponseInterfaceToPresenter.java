package com.mvpvolley.presenter;

import com.android.volley.toolbox.Volley;

public interface ResponseInterfaceToPresenter {

    void onSuccess(String result);

    void onError(Volley error);
}
