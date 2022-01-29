package com.rating;

public class Bistro extends Restaurant{

    /* Class Bistro is extended by Restaurant
     *  No overrides or additional enhancements have been made yet for this class*/
    public Bistro(String name, String price, String hours, String filePath) {
        super(name, price, hours,filePath);
    }
    public Bistro(String name, String rating, String filePath) {
        super(name, rating, filePath);
    }

    public Bistro(String filePath) {
        super(filePath);
    }
}
