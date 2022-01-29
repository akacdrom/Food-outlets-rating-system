package com.rating;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class LoginUser {

    /* Method for read from file user's input for the login from the file, and check is there any match.*/
    public static void LogIn() throws Exception{
        while (true) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Checking...");

        /* Take the file to the object*/
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/rating/userInfo"));
        String line;

        /* Print all line until end of the file*/
        while((line = bufferedReader.readLine()) != null) {

            /* Split the line from file to the array */
            String [] splitted = line.split(",");

            /* Take the username and check is matches*/
            if (Objects.equals(splitted[2], username)){

                /* Take the password and check is matches*/
                if (Objects.equals(splitted[3], password)){
                    System.out.println("Logged in");

                    /* Break the loop*/
                    return;
                }
            }
        }
        /* Start the loop again*/
        System.out.println("Wrong credentials, Try again!");
        }
    }
}
