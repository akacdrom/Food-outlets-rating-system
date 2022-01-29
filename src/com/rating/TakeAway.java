package com.rating;

public class TakeAway extends Restaurant{

    /* Class TakeAway is extended by Restaurant
    *  No overrides or additional enhancements have been made yet for this class*/
    public TakeAway(String name, String price, String hours, String filePath) {
        super(name, price, hours, filePath);
    }
    public TakeAway(String name, String rating, String filePath) {
        super(name, rating, filePath);
    }

    public TakeAway(String filePath) {
        super(filePath);
    }
}
