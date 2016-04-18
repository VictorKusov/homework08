package ru.list.victor_90.study.myapplication.rest.models;

public class RegisterRequest {

    private String email;
    private String login;
    private String password;
    private String name;

    public RegisterRequest(String email, String login, String password, String name) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
