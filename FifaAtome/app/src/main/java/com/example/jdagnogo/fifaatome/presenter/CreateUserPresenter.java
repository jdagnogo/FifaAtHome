package com.example.jdagnogo.fifaatome.presenter;

import com.example.jdagnogo.fifaatome.ui.contract.CreateUserContract;

public class CreateUserPresenter<V extends CreateUserContract> implements BasePresenter<V> {
    private V view;


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
}
