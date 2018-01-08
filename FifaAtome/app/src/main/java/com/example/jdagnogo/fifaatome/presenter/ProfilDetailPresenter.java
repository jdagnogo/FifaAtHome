package com.example.jdagnogo.fifaatome.presenter;

import android.util.Log;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.models.realm.UserRealm;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsDetailContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.realm.RealmResults;

public class ProfilDetailPresenter<V extends ProfilsDetailContract> implements BasePresenter<V> {

    private V view;

    @Override
    public void onResume() {
        loadUserInfo();
        //view.fillTitle(userRealm.getFullName());
    }

    private void loadUserInfo() {
        FifaAtome.getDbManager().loadUserById(5).subscribe(new Consumer<User>() {
            @Override
            public void accept(User user) throws Exception {
                Log.e("toto",""+user.toString());
            }
        });

      FifaAtome.getDbManager().saveUser(new User()).subscribe(new Consumer<Boolean>() {
           @Override
           public void accept(Boolean aBoolean) throws Exception {
               if (aBoolean){
                   Log.e("ProfilsDetailPresenter", "saved !!");
               }else {
                   Log.e("ProfilsDetailPresenter", "not saved !!");
               }

           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {
               Log.e("ProfilsDetailPresenter", "error : "+throwable.getMessage());
           }
       });


    }


    @Override
    public void onDetach() {
        view = null;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
