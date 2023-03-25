package com.example.acalculator

import android.util.Log
import android.util.TimeUtils
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.System.currentTimeMillis
import java.sql.Time

object Calculator {

    var display : String = "0"
        private set

    private val _history = mutableListOf<Operation>()

    val history get() = _history.toList()

    fun addSymbol(value: String) {
        if (display == "0") { display  = value }
        else                { display += value }
    }

    fun backSpace(n : Int = 1){
        display = display.dropLast(n)
    }

    fun equals () {
        display = handleOperation()
    }

    fun clear (){
        display = "0"
    }

    fun handleOperation (): String {
        val expression = ExpressionBuilder(  Calculator.display ).build()
        val result = expression.evaluate().toString()
        val operation = Operation (display, result, currentTimeMillis())
        _history.add(operation)
        return result;
    }
}