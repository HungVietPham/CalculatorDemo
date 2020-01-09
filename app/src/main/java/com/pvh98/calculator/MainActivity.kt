package com.pvh98.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fragmentCalculator = CalculatorFragment()
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainer, fragmentCalculator)
        transaction.commit()
    }
}
