package com.example.jdagnogo.fifaatome.models.entities;

import com.example.jdagnogo.fifaatome.models.realm.UserRealm;

public class User {
    private int id;
    private String pseudo;
    private String firstName;
    private String name;
    private String password;
    private String photo;

    public User() {
    }

    public User(UserRealm userRealm){
        this.id = userRealm.getId();
        this.setPseudo(userRealm.getPseudo());
        this.firstName = userRealm.getFirstName();
        this.name = userRealm.getName();
        this.password = userRealm.getPassword();
        this.photo = userRealm.getPhoto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
