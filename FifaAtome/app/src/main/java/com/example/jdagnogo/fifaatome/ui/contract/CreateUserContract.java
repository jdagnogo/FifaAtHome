package com.example.jdagnogo.fifaatome.ui.contract;

public interface CreateUserContract extends BaseContract {

    void showErrorCreatingUser();

    void successCreatingUser();

    void changePhoto(String photo);
}
