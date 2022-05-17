package com.example.kitchenstories;

import com.Calculations.ECalc;
import com.Calculations.MCalc;
import  com.Calculations.RevCalc;
import com.Calculations.PCalc;


 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


 

 
public class AllTests{
    private ECalc expertCalculation;
    private MCalc Calculatesummary;
    private RevCalc reviewCalculation;
    private PCalc CalculatePaytotal;


    @BeforeEach
    public void setup(){
       expertCalculation = new ECalc();
       Calculatesummary = new MCalc();
       reviewCalculation = new RevCalc();
       CalculatePaytotal = new PCalc();
    }
    @Test
    public void subTotal() throws NullPointerException{
        double result = expertCalculation.calculateTotal(5 , 100 , 0.5 , 500);
        assertEquals(1150.0 , result);
    }
    @Test
    public void subRecipeSummary() throws NullPointerException {
        double result = Calculatesummary.Calculatesummary(5, 2, 600.0);
        assertEquals(6000.0, result);
    }
  
   @Test
   public void subReviewTotal() throws NullPointerException{
        double result =  reviewCalculation.calculateTotalReview(2,200,0.7);
        assertEquals(280.0, result);
    }
   @Test
    public void TotalPayment() throws NullPointerException {
        double answer = CalculatePaytotal.CalculatePaytotal(250, 2);
        assertEquals(500, answer);
    }
}

 
