package com.Calculations;

public class RevCalc {

    public double calculateTotalReview ( int month, int revPerMonth, double revRate){
        return revPerMonth * revRate * month;
    }
}
