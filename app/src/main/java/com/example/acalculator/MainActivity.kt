package com.example.acalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.acalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    /*
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
     */

    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        /*
            should be improved: how to access button text?
            tried it.getText.toString()
            tried (button)it.getText.toString()
         */
        binding.button1.setOnClickListener { addSymbol("1") }
        binding.button2.setOnClickListener { addSymbol("2") }
        binding.button3.setOnClickListener { addSymbol("3") }
        binding.button4.setOnClickListener { addSymbol("4") }
        binding.button5.setOnClickListener { addSymbol("5") }
        binding.button6.setOnClickListener { addSymbol("6") }
        binding.button7.setOnClickListener { addSymbol("7") }
        binding.button8.setOnClickListener { addSymbol("8") }
        binding.button9.setOnClickListener { addSymbol("9") }
        binding.button0.setOnClickListener { addSymbol("0") }
        
        binding.buttonAddition.setOnClickListener { addSymbol("+") }
        binding.buttonDivide.setOnClickListener { addSymbol("/") }
        binding.buttonMultiply.setOnClickListener { addSymbol("*") }
        binding.buttonSubtraction.setOnClickListener { addSymbol("-") }

        binding.buttonClear.setOnClickListener {clear() }
        binding.buttonBack.setOnClickListener { backspace() }
        binding.buttonEquals.setOnClickListener{ equals() }

    }

    fun addSymbol (value: String){
        Log.i(TAG, "Click no botão " + value)
        Calculator.addSymbol(value)
        binding.textVisor.text = Calculator.display
    }

    fun backspace ( n : Int = 1){
        Log.i(TAG, "Remover o último dígito")
        Calculator.backSpace()
    }

    fun clear ( initValue : String = "0"){
        Log.i(TAG, "A limpar valores")
        Calculator.clear()
        binding.textVisor.text = Calculator.display
    }

    fun equals () {
        Log.i(TAG, "Calcular...")
        Calculator.equals()
        binding.textVisor.text = Calculator.display
        Log.i(TAG, "O resultado da expressão é ${Calculator.display}")
        Log.i(TAG, Calculator.history.toString())
    }
}