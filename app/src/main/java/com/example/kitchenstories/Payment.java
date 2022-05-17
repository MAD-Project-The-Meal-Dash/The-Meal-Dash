package com.example.kitchenstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    EditText num1,num2;
    Button addpay,confirm;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        confirm=findViewById(R.id.payConfirmmlc1);

        num1 =findViewById(R.id.payMLCpprice);
        num2 =findViewById(R.id.payMLCpquantity);
        addpay =findViewById(R.id.payMLCTotal);
        answer=findViewById(R.id.tvAnswerP);

        addpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(num1.getText().toString());
                int number2=Integer.parseInt(num2.getText().toString());
                int multiplication =number1*number2;
                answer.setText("Rs: "+ String.valueOf(multiplication));
            }
        });
        confirm.setOnClickListener(v -> {
            Intent intent = new Intent(Payment.this , FavouriteActivity.class);
            startActivity(intent);
        });
    }
}