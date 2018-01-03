package com.example.jdagnogo.fifaatome.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.example.jdagnogo.fifaatome.FifaAtome;
import com.example.jdagnogo.fifaatome.models.entities.User;
import com.example.jdagnogo.fifaatome.ui.activities.ProfilsDetailActivity;
import com.example.jdagnogo.fifaatome.ui.adapter.UserAdapter;
import com.example.jdagnogo.fifaatome.ui.contract.ProfilsContract;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;

import static com.example.jdagnogo.fifaatome.utils.RecyclerViewUtils.initRecyclerView;

public class ProfilsPresenter<V extends ProfilsContract> implements BasePresenter<V> {
    private V view;
    private UserAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<User> users;

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void init(V view) {

        this.view = view;
        getLastestUserList();
        initAdapter();
    }

    private void getLastestUserList() {
        FifaAtome.getDbManager().loadUsers().subscribe(getOnNextConsomer(), getThrowableConsomer());

    }

    private void initAdapter() {
        recyclerView = view.getRecyclerView();
        initRecyclerView(recyclerView, view.getActivity(), true);
        adapter = new UserAdapter(users);
        recyclerView.setAdapter(adapter);
    }

    public void onFabClick() {
        Intent intent = new Intent(view.getActivity(), ProfilsDetailActivity.class);
        view.getActivity().startActivity(intent);
    }

    private Consumer<ArrayList<User>> getOnNextConsomer() {
        return users -> {
            ProfilsPresenter.this.users = users;
            if (null != adapter) {
                adapter.notifyDataSetChanged();
            }
        };
    }

    private Consumer<Throwable> getThrowableConsomer() {
        return throwable -> {

        };
    }
}
