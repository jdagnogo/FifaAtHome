package com.example.jdagnogo.fifaatome.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private int id;
    private String firstName;
    private String name;
    private String password;
    private String photo;

}
