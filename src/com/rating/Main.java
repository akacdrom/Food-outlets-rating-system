package com.rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /** Path to the files*/
    private static final String restaurantPath = "src/com/rating/Restaurant";
    private static final String bistroPath = "src/com/rating/Bistro";
    private static final String takeAwayPath = "src/com/rating/Take-Away";

    public static void main(String[] args) throws Exception {

        userChoice();

    }
    /* Method for user menu*/
    public static void userChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Register User");
        System.out.println("2- Register Restaurant");
        System.out.println("3- Register Bistro");
        System.out.println("4- Register Take-Away");
        System.out.println("5- Rate Restaurant");
        System.out.println("6- Rate Bistro");
        System.out.println("7- Rate Take-Away");
        System.out.print("Enter a number from menu: ");

        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int userInput = scanner.nextInt();

        /*User's request returning the wished method*/
        switch (userInput) {
            case 1 -> setUser();
            case 2 -> createRestaurant();
            case 3 -> createBistro();
            case 4 -> createTakeAway();
            case 5 -> rateRestaurant();
            case 6 -> rateBistro();
            case 7 -> rateTakeAway();
            default -> throw new IllegalStateException("Unexpected value: " + userInput);
        }
    }

    /* Next 3 methods for print the registered  selected outlet type*/
    public static void rateRestaurant() throws Exception {
        /*Get city name from user*/
        String getCity = Restaurant.getCity("Restaurant");

        Restaurant printRestaurant = new Restaurant(restaurantPath+"_"+getCity);
        printRestaurant.printRestaurant();

        String [] getRating = String.join(",", setRating()).split(",");
        Restaurant giveRating = new Restaurant(getRating[0],getRating[1],restaurantPath+"_"+getCity);
        giveRating.giveRating();
    }
    public static void rateBistro() throws Exception {
        String getCity = Restaurant.getCity("Bistro");
        Bistro printBistro = new Bistro(bistroPath+"_"+getCity);
        printBistro.printRestaurant();

        String [] getRating = String.join(",", setRating()).split(",");
        Bistro giveRating = new Bistro(getRating[0],getRating[1],bistroPath+"_"+getCity);
        giveRating.giveRating();
    }
    public static void rateTakeAway() throws Exception {
        String getCity = Restaurant.getCity("Take-Away");
        TakeAway printRestaurant = new TakeAway(takeAwayPath+"_"+getCity);
        printRestaurant.printRestaurant();

        String [] getRating = String.join(",", setRating()).split(",");
        TakeAway giveRating = new TakeAway(getRating[0],getRating[1],takeAwayPath+"_"+getCity);
        giveRating.giveRating();
    }

    /* Method for create new user*/
    public static void setUser() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = myObj.nextLine();

        System.out.print("Enter surname: ");
        String surname = myObj.nextLine();

        System.out.print("Enter username: ");
        String userName = myObj.nextLine();

        System.out.print("Enter password: ");
        String userPassword = myObj.nextLine();

        /* I used constructor for assign values*/
        RegisterUser<String> registerUser = new RegisterUser<>(name,surname,userName,userPassword);

        System.out.println("USER IS CREATED");

        /* Getting back values form getter and setter to see it's working to manipulation for possible future project improvements*/
        System.out.println("NAME: "+registerUser.getName()+", "+"SURNAME: "+ registerUser.getSurname()+", "+ "USERNAME: "+registerUser.getUsername()+", "+ "PASSWORD: "+ registerUser.getPassword());

        registerUser.registerToFile();
    }

    /* Set and return variables taking from user for the registration of new outlet*/
    /* Collection interface "List" is used*/
    public static List<String> setRestaurant() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter name of outlet: ");
        String restaurantName = myObj.nextLine();

        System.out.print("Enter price range: ");
        String restaurantPriceRange = myObj.nextLine();

        System.out.print("Enter hours: ");
        String restaurantHours = myObj.nextLine();

        System.out.print("Enter City: ");
        String city = myObj.nextLine();

        List<String> list = new ArrayList<>();
        list.add(restaurantName);
        list.add(restaurantPriceRange);
        list.add(restaurantHours);
        list.add(city);

        return list;
    }

    /* Next 3 method for create selected outlet*/
    public static void createRestaurant() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        Restaurant restaurant = new Restaurant(getRest[0],getRest[1],getRest[2],restaurantPath+"_"+getRest[3]);
        restaurant.addRestaurant();
    }

    public static void createBistro() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        Bistro bistro = new Bistro(getRest[0],getRest[1],getRest[2],bistroPath+"_"+getRest[3]);
        bistro.addRestaurant();
    }
    public static void createTakeAway() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        TakeAway takeAway = new TakeAway(getRest[0],getRest[1],getRest[2],takeAwayPath+"_"+getRest[3]);
        takeAway.addRestaurant();
    }

    /* Get variables for necessary to give rating to the outlet*/
    /* Collection interface "List" is used*/
    public static List<String> setRating() throws Exception {
        System.out.println("YOU HAVE TO LOGIN BEFORE RATE");
        LoginUser.LogIn();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of outlet: ");
        String name = scanner.nextLine();

        System.out.print("Enter your rating over 10: ");
        String rating = scanner.nextLine();

        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(rating);

        return list;
    }
}
