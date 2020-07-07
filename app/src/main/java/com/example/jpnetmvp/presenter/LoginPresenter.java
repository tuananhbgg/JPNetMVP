package com.example.jpnetmvp.presenter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;

import com.example.jpnetmvp.CheckNetWork;
import com.example.jpnetmvp.R;
import com.example.jpnetmvp.model.LoginResponseModel;
import com.example.jpnetmvp.model.UserModel;
import com.example.jpnetmvp.service.DemoService;
import com.example.jpnetmvp.service.IDemoService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LoginPresenter {
    private String SAVE_SERVER_TOKEN = "SaveServerToken";
    private String SERVER_TOKEN = "serverToken";
    private ILoginActivity iLoginView;
    private Retrofit retrofit;
    public CompositeDisposable compositeDisposable;
    private CheckNetWork checkNetWork;
    private Context context;
    private Dialog processBarDialog;
    private SharedPreferences sharedPreferences;


    public LoginPresenter(ILoginActivity iLoginView, Context context) {
        this.iLoginView = iLoginView;
        this.context = context;
        compositeDisposable = new CompositeDisposable();
    }

    public void login(String userName, String password) {
        sharedPreferences = context.getSharedPreferences(SAVE_SERVER_TOKEN, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        checkNetWork = new CheckNetWork();
        boolean isConnect = checkNetWork.checkNetWorkAvailable(context);
        if (isConnect) {
            showProcessbar();
            retrofit = new DemoService().getInstant();
            String temp = "";
            if (!userName.equals("")) {
                temp = userName.substring(0, 1);
            }
            if (!userName.equals("") && temp.equals(0 + "")) {
                String us = userName.substring(1);
                userName = "+84" + us;
            }
            compositeDisposable.add(retrofit.create(IDemoService.class)
                    .login(new UserModel(userName, "", "", password, 1))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<LoginResponseModel>() {
                        @Override
                        public void accept(LoginResponseModel loginResponseModel){
                            if (loginResponseModel.getStatus() == 0) {
                                editor.putString(SERVER_TOKEN, loginResponseModel.getBody().getServerToken());
                                editor.commit();
                                iLoginView.loginSuccesful();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        processBarDialog.dismiss();
                                    }
                                },350);
                            } else {
                                iLoginView.loginFail(loginResponseModel.getMessage());
                                processBarDialog.dismiss();
                            }
                        }
                    }));
//            iDemoService.login(new UserModel(userName, "", "", password, 1)).enqueue(new Callback<LoginResponseModel>() {
//                @Override
//                public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
//                    if (response.body().getStatus() == 0) {
//                        editor.putString(SERVER_TOKEN, response.body().getBody().getServerToken());
//                        editor.commit();
//                        iLoginView.loginSuccesful();
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                processBarDialog.dismiss();
//                            }
//                        }, 500);
//                    } else {
//                        iLoginView.loginFail(response.body().getMessage());
//                        processBarDialog.dismiss();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginResponseModel> call, Throwable t) {
//                    processBarDialog.dismiss();
//                }
//            });
        } else {
            iLoginView.loginFail("Vui lòng kết nối Internet");
        }
    }

    private void showProcessbar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View layoutDialog = LayoutInflater.from(context).inflate(R.layout.processbar_dialog, null);
        builder.setView(layoutDialog);
        processBarDialog = builder.create();
        Window window = processBarDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        processBarDialog.show();
        processBarDialog.setCancelable(false);
    }
}
