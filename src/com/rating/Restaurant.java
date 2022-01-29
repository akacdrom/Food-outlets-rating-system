package com.rating;

import java.io.*;
import java.util.*;

public class Restaurant {

    private String name;
    private String price;
    private String hours;
    private String rating;
    private String filePath;

    /* Constructor for add new outlet*/
    public Restaurant(String name, String price, String hours, String filePath){
        this.name = name;
        //this.rating = rating;
        this.price = price;
        this.hours = hours;
        this.filePath = filePath;
    }

    /* Constructor for add new rating to the selected outlet*/
    public Restaurant(String name, String rating, String filePath){
        this.name = name;
        this.rating = rating;
        this.filePath = filePath;
    }

    /* Constructor for printing the selected outlet with rating calculations*/
    public Restaurant(String filePath){
        this.filePath = filePath;
    }


    public static String getCity(String outletType){

        File directoryPath = new File("src/com/rating/");
        FilenameFilter fileFilter = (dir, name) -> name.contains("_") && name.contains(outletType);

        //List of all the text files
        String[] cityList = directoryPath.list(fileFilter);

        /* Set Collection used for non-duplicate list for available cities*/
        Set<String> cities = new HashSet<>();

        assert cityList != null;
        for(String cityName : cityList) {
            String [] split = cityName.split("_");
            cities.add(split[1]);
        }

        int i = 1;
        System.out.println("LIST OF CITIES WHERE OUTLETS ARE AVAILABLE");
        for (String city : cities) {
            System.out.println(i+"->"+city);
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type your city name from list: ");

        String city = scanner.nextLine();
        return city;
    }
    /* Method for print selected outlet with the rating calculations*/
    public void printRestaurant() throws IOException {

        //Open create buffered object
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        System.out.println("LIST OF OUTLETS IN SELECTED CITY: ");
        while((line = bufferedReader.readLine()) != null) {
            String [] splitted = line.split(",");
            if (!Objects.equals(splitted[1], "N/A")){
                String [] rateSplitted = splitted[1].split("_");
                double sumOfRatings = 0;
                for (String s : rateSplitted) {
                    sumOfRatings += Double.parseDouble(s);
                }
                double rating = sumOfRatings/rateSplitted.length;
                splitted[1] = String.format("%.2f",rating);
            }
            System.out.println("Name: "+splitted[0]+" | "+"Rating: "+splitted[1]+"/10 | "+"Price: "+splitted[2]+" | "+"Hours: "+splitted[3]);
        }
    }

    /* Method for giving rating to the selected outlet*/
    public void giveRating() throws IOException {
        String tempFile = "src/com/rating/ratingTmp";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        FileWriter myWriter = new FileWriter(tempFile);
        while((line = bufferedReader.readLine()) != null) {
            String [] splitted = line.split(",");

            if (!Objects.equals(splitted[0], name)){
                myWriter.write(line+"\n");
            }
            else {
                if (Objects.equals(splitted[1],"N/A")){
                    splitted[1] = rating;
                }
                else {
                    splitted[1] = splitted[1] + "_" + rating;
                }
                myWriter.write(splitted[0]+","+splitted[1]+","+splitted[2]+","+splitted[3]+"\n");
            }
        }
        myWriter.close();
        // Delete old file and Rename new file as old file
        File oldTempFile =new File(tempFile);
        File newFile =new File(filePath);
        newFile.delete();
        oldTempFile.renameTo(newFile);
    }

    /* Create outlet*/
    public void addRestaurant() throws IOException {
        FileWriter myWriter = new FileWriter(filePath,true);
        myWriter.write(name+","+"N/A"+","+price+","+hours+"\n");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    }
}

