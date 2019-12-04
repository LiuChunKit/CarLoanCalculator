package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val viewLoan = findViewById<TextView>(R.id.textViewLoan)
        val viewInterest = findViewById<TextView>(R.id.textViewInterest)
        val viewMonthRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val calBtn = findViewById<Button>(R.id.buttonCalculate)
        val resetBtn = findViewById<Button>(R.id.buttonReset)

        calBtn.setOnClickListener() {
            val a = carPrice.text.toString()
            val b = downPayment.text.toString()
            val c = loanPeriod.text.toString()
            val d = interestRate.text.toString()

            val cp = a.toInt()
            val dp = b.toInt()
            val lp = c.toInt()
            val ir = d.toFloat()

            //calculate car loan
            val carLoan = cp - dp
            viewLoan.text = carLoan.toString()

            //calculate interest
            val interestDivTen = ir / 10
            val interest = carLoan * interestDivTen * lp
            viewInterest.text = interest.toString()

            //calculate monthly repayment
            val monthRepayment = ((carLoan + interest) / lp / 12)
            viewMonthRepayment.text = monthRepayment.toString()

        }

        resetBtn.setOnClickListener(){
            carPrice.setText("")
            downPayment.setText("")
            loanPeriod.setText("")
            interestRate.setText("")

            viewLoan.text = "Loan : "
            viewInterest.text = "Interest : "
            viewMonthRepayment.text = "Monthly Repayment : "

        }
    }
}