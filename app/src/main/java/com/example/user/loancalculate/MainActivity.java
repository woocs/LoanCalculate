package com.example.user.loancalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrice, editTextDownPayment, editTextInterestRate, editTextRepayment, editTextSalary;

    public static final String LOAN_STATUS = "status";
    public static final String LOAN_REPAYMENT = "repayment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
    }

    public void claculateRepayment(View view)
    {
        Intent intent = new Intent (this, Result.class);

        double repayment=0;

        double price, downpayment, interestRate, RePayment, salary, totalInterest, totalLoan, MonthPayment;

        price = Double.parseDouble(editTextPrice.toString());
        downpayment = Double.parseDouble(editTextDownPayment.toString());
        interestRate = Double.parseDouble(editTextInterestRate.toString());
        RePayment = Double.parseDouble(editTextRepayment.toString());
        salary = Double.parseDouble(editTextSalary.toString());
        double rate = interestRate/100;
        totalInterest = (price-downpayment)*rate*(RePayment/12);
        totalLoan = (price-downpayment) + totalInterest;
        MonthPayment = totalLoan/RePayment;
        

        intent.putExtra(LOAN_STATUS, "Approve");
        intent.putExtra(LOAN_REPAYMENT, repayment);
        startActivity(intent);
    }
}
