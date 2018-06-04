package com.example.jdagnogo.fifaatome.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.R;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.ui.adapter.PhotoAdapter;
import com.example.jdagnogo.fifaatome.ui.contract.CreateUserContract;
import com.example.jdagnogo.fifaatome.utils.FlashBarUtils;
import com.example.jdagnogo.fifaatome.utils.ImageUtils;
import com.example.jdagnogo.fifaatome.utils.StringUtils;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.example.jdagnogo.fifaatome.utils.RecyclerViewUtils.initRecyclerViewAsGrid;

public class CreateUserPresenter<V extends CreateUserContract> implements BasePresenter<V>, PhotoAdapter.ItemClickListener {
    private V view;
    private User user;
    private Disposable data;
    private PhotoAdapter adapter;
    private RecyclerView recyclerView;
    private Dialog openDialog;
    private ArrayList<String> photos;
    private String currentPhoto = "ic_pele";


    @Override
    public void onResume() {

    }

    @Override
    public void onDetach() {
        view = null;
        if (data != null && !data.isDisposed()) {
            data.dispose();
        }
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
        user = new User();
        user.setPhoto(currentPhoto);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    public void onPhotoClick() {
        view.hideOrShowAvatarOptions();
    }

    public void onAvatarClick() {
        // load all pictures
        ArrayList<String> allpictures;
        createDialog(view.getActivity());
    }

    public void onPictureClick() {
    }

    public void onValidateClick() {
        saveUser();
    }

    public void setInfoFilled(String pseudo, String firtname, String name) {
        //TODO check if info corret
        user.setPseudo(pseudo);
        user.setFirstName(firtname);
        user.setName(name);
    }

    private void saveUser() {
        if (checkIfEverythingOk()){
            data = FifaAtome.getDbManager().saveUser(user).subscribe(getConsumer(), getThrowableConsomer());
            view.getActivity().finish();
        }

    }
private boolean checkIfEverythingOk(){
        if (StringUtils.isStringNotEmpty(user.getFirstName())
                && StringUtils.isStringNotEmpty(user.getPseudo())
                && StringUtils.isStringNotEmpty(user.getName())){
            return true;
        }else {
            FlashBarUtils.createFlashBarError(view.getActivity(),
                    FifaAtome.getContext().getString(R.string.missing_info));
            return false;
        }

}
    private Consumer<Boolean> getConsumer() {
        return aBoolean -> {
            if (aBoolean) {
                Log.e("ProfilsDetailPresenter", "saved !!");
                view.successCreatingUser();
            } else {
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

    public void createDialog(Activity activity) {
        openDialog = new Dialog(activity);
        openDialog.setContentView(R.layout.avatar_dialog_view);

        TextView cancel = openDialog.findViewById(R.id.cancel);
        Disposable disposable = RxView.clicks(cancel).subscribe(changeUserPhotoConsumer());
        photos = ImageUtils.loadAllphotos();
        initAdapter();


        openDialog.setOnDismissListener(dialog -> {
            if (!disposable.isDisposed())
                disposable.dispose();

        });
        openDialog.show();

    }


    private void initAdapter() {
        recyclerView = openDialog.findViewById(R.id.recycler);
        initRecyclerViewAsGrid(recyclerView, openDialog.getOwnerActivity(), 3);
        adapter = new PhotoAdapter(photos, currentPhoto);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private Consumer changeUserPhotoConsumer() {
        return aVoid -> {
            openDialog.cancel();
        };
    }

    @Override
    public void onItemClick(View view, int position) {
        currentPhoto = adapter.getItem(position);
        user.setPhoto(currentPhoto);
        this.view.changePhoto(currentPhoto);
        openDialog.dismiss();
    }
}
