package com.example.jdagnogo.fifaatome.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.ui.activities.CreateUserActivity;
import com.example.jdagnogo.fifaatome.ui.activities.ProfilsDetailActivity;
import com.example.jdagnogo.fifaatome.ui.adapter.UserAdapter;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsContract;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.example.jdagnogo.fifaatome.utils.RecyclerViewUtils.initRecyclerView;

public class ProfilsPresenter<V extends ProfilsContract> implements BasePresenter<V> {
    private V view;
    private UserAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<User> users;
    private Disposable data;

    @Override
    public void onResume() {
        getLastestUserList();
    }

    @Override
    public void onDetach() {
        this.view = null;
        if (!data.isDisposed())
            data.dispose();
    }

    @Override
    public void onAttach(V view) {

        this.view = view;
        users = new ArrayList<>();
        showLoading();
        initAdapter();
    }

    @Override
    public void showLoading() {
        view.showLoading();
    }

    @Override
    public void hideLoading() {
        view.hideLoading();
    }

    private void getLastestUserList() {
        data = FifaAtome.getDbManager().loadAllUsers().subscribe(getOnNextConsomer(), getThrowableConsomer());
    }

    private void initAdapter() {
        recyclerView = view.getRecyclerView();
        initRecyclerView(recyclerView, view.getActivity(), true);
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);
    }

    public void onFabClick() {
        Intent intent = new Intent(view.getActivity(), CreateUserActivity.class);
        view.getActivity().startActivity(intent);
    }

    private Consumer<ArrayList<User>> getOnNextConsomer() {
        return users -> {
            Log.e("ProfilsPresenter :", "new data : ");
            ProfilsPresenter.this.users.clear();
            ProfilsPresenter.this.users.addAll(users);
            hideLoading();
            if (users.size() == 0) {
               handleEmptyAdapter();
            }
            if (null != adapter) {
                adapter.notifyDataSetChanged();
            }
        };
    }

    private void handleEmptyAdapter() {
        view.handleEmptyAdapter();
    }

    private Consumer<Throwable> getThrowableConsomer() {
        return throwable -> {
            Log.e("ProfilsPresenter :", "error : " + throwable.getMessage());
            data.dispose();
        };
    }
}
