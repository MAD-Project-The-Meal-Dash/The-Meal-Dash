package com.Calculations;

public class ECalc {
    public double calculateTotal(int hours, int voucher , double rate , int charge){
        return hours * rate * charge - voucher;
    }
}
