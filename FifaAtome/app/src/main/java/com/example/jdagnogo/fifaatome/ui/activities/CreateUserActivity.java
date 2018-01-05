package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.CreateUserPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.CreateUserContract;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateUserActivity extends BaseActivity implements CreateUserContract{

    @BindView(R.id.validate)
    TextView validate;

    @BindView(R.id.image_container)
    RelativeLayout imageContainer;

    @BindView(R.id.choose_image_option)
    LinearLayout chooseImageOption;


    private CreateUserPresenter createUserPresenter;
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showLoading() {
        //photo

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_create_user;
    }

    @Override
    protected void initPresenter() {
        presenter.onAttach(this);

    }

    @Override
    protected BasePresenter setPresenter() {
        presenter = new CreateUserPresenter();
        createUserPresenter = (CreateUserPresenter)presenter;
        return presenter;
    }
    @OnClick(R.id.image_container)
    void onImageClick(){
        createUserPresenter.onPhotoClick();
    }
    @Override
    public void hideOrShowAvatarOptions() {
        if (chooseImageOption.isShown()){
            chooseImageOption.setVisibility(View.GONE);
        }else {
            chooseImageOption.setVisibility(View.VISIBLE);
        }
    }
}