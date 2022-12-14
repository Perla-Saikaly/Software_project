package com.example.software_project;

public class User {

  private int id;
    private String username, email, password;

    public User() { }

    public User(String name, String email, String password) {

        this.username = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User:\n" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
