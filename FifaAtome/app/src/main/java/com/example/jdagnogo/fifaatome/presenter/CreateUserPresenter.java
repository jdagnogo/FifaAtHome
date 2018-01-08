package com.example.jdagnogo.fifaatome.presenter;

import android.util.Log;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.ui.contract.CreateUserContract;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CreateUserPresenter<V extends CreateUserContract> implements BasePresenter<V> {
    private V view;
    private User user;
    private Disposable data;


    @Override
    public void onResume() {

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

    public void onPhotoClick(){
        view.hideOrShowAvatarOptions();
    }
    public void onValidateClick(){

    }

    public void setInfoFilled(String pseudo, String firtname, String name) {
        //TODO check if info corret
        user = new User(pseudo,firtname,name);
        saveUser();
    }

    private void saveUser() {
        data =FifaAtome.getDbManager().saveUser(user).subscribe(getConsumer(), getThrowableConsomer());
    }

    private Consumer<Boolean> getConsumer(){
        return aBoolean -> {
            if (aBoolean){
                Log.e("ProfilsDetailPresenter", "saved !!");
                view.successCreatingUser();
            }else {
                Log.e("ProfilsDetailPresenter", "not saved !!");
                view.showErrorCreatingUser();
            }
        };
    }
    private Consumer<Throwable> getThrowableConsomer() {
        return throwable -> {
            Log.e("CreateUserPresenter :", "error : " + throwable.getMessage());
            data.dispose();
        };
    }
}
