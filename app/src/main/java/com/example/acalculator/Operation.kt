package com.example.acalculator

class Operation ( var _expression : String, var _result : String , var _opTime : Long ){

    override fun toString () : String {
        return _expression + " | " + _result + " | " + _opTime
    }
}