package com.example.jdagnogo.fifaatome.ui.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.models.enums.CircleMenuItemEnum;
import com.example.jdagnogo.fifaatome.presenter.BasePresenter;
import com.example.jdagnogo.fifaatome.presenter.CreateUserPresenter;
import com.example.jdagnogo.fifaatome.ui.contract.CreateUserContract;
import com.example.jdagnogo.fifaatome.utils.ImageUtils;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class CreateUserActivity extends BaseActivity implements CreateUserContract {
    //TODO rotation : icepick
    @BindView(R.id.validate)
    TextView validate;

    @BindView(R.id.image_container)
    RelativeLayout imageContainer;

    @BindView(R.id.avatar)
    LinearLayout avatar;

    @BindView(R.id.picture)
    LinearLayout picture;

    @BindView(R.id.choose_image_option)
    LinearLayout chooseImageOption;
    @BindView(R.id.pseudo_ed)
    EditText pseudoEd;

    @BindView(R.id.firstname_ed)
    EditText firstnameEd;

    @BindView(R.id.name_ed)
    EditText nameEd;

    @BindView(R.id.profile_image)
    CircleImageView profileImage;

    private CreateUserPresenter createUserPresenter;

    @Override
    public RxActivity getActivity() {
        return this;
    }

    @Override
    public void showLoading() {
        //nothing

    }

    @Override
    public void hideLoading() {
        //nothing
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
        createUserPresenter = (CreateUserPresenter) presenter;
        return presenter;
    }

    @OnClick(R.id.image_container)
    void onImageClick() {
        createUserPresenter.onPhotoClick();
    }

    @OnClick(R.id.avatar)
    void onAvatarClick() {
        createUserPresenter.onAvatarClick();
    }


    @OnClick(R.id.picture)
    void onPictureClick() {
        createUserPresenter.onPictureClick();
    }

    @OnClick(R.id.validate)
    void onValidateClick() {
        createUserPresenter.setInfoFilled(pseudoEd.getText().toString(),
                firstnameEd.getText().toString(),
                nameEd.getText().toString());
        createUserPresenter.onValidateClick();
    }

    @Override
    public void hideOrShowAvatarOptions() {
        if (chooseImageOption.isShown()) {
            chooseImageOption.setVisibility(View.GONE);
        } else {
            chooseImageOption.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showErrorCreatingUser() {

    }

    @Override
    public void successCreatingUser() {

    }

    @Override
    public void changePhoto(String photo) {
        profileImage.setImageDrawable(ImageUtils.getProfileDrawableFromName(photo));
    }
}
