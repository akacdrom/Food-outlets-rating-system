package com.rating;

import java.io.*;

public class RegisterUser <T>{
    private T name;
    private T surname;
    private T username;
    private T password;

    /* Constructor*/
    public RegisterUser(T name, T surname, T username, T password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    /* Getters and setters added just for possible future code improvements due to lack of manipulation ability of constructor*/
    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getSurname() {
        return surname;
    }

    public void setSurname(T surname) {
        this.surname = surname;
    }

    public T getUsername() {
        return username;
    }

    public void setUsername(T username) {
        this.username = username;
    }

    public T getPassword() {
        return password;
    }

    public void setPassword(T password) {
        this.password = password;
    }

    /* Method for create and write user credentials to the file.*/
    public void registerToFile()  throws IOException {
        FileWriter myWriter = new FileWriter("src/com/rating/userInfo",true);
        myWriter.write(name+","+surname+","+username+","+password+"\n");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
}
