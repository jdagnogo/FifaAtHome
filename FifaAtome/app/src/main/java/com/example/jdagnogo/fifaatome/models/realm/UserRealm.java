package com.example.jdagnogo.fifaatome.models.realm;

import com.example.jdagnogo.fifaatome.models.entities.User;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserRealm extends RealmObject {

    private int id;
    @PrimaryKey
    private String pseudo;
    private String firstName;
    private String name;
    private String password;
    private String photo;

    public UserRealm() {
    }

    public UserRealm(User user){
        this.id = user.getId();
        this.password = user.getPassword();
        this.photo = user.getPhoto();
        this.firstName= user.getFirstName();
        this.name = user.getName();
        this.pseudo =user.getPseudo();
    }
    public String getFullName() {
        return String.format("%s %s",firstName,name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
