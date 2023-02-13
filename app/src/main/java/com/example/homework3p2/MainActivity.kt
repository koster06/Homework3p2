package com.example.homework3p2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var etName: EditText? = null
    var etSurname: EditText? = null
    var etPhone: EditText? = null
    var etAge: EditText? = null

    var bBTN2: Button? = null
    var bBTN1: Button? = null

    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val nameFilled = etName!!.text.toString()
            val surnameFilled = etSurname!!.text.toString()
            val phoneFilled = etPhone!!.text.toString()
            val ageFilled = etAge!!.text.toString()

            bBTN1?.setEnabled(!nameFilled.isEmpty() && !surnameFilled.isEmpty() && !phoneFilled.isEmpty() && !ageFilled.isEmpty())

            // не внимательно прочитал условие, думал нужно показать кнопку_№2 как активную для удаления строк из EditText полей

            //bBTN2?.setEnabled(!nameFilled.isEmpty() || !surnameFilled.isEmpty() || !phoneFilled.isEmpty() || !ageFilled.isEmpty())

        }
        override fun afterTextChanged(s: Editable) {}
    }
    // для скрытия клавиатуры
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.editTextName)
        etSurname = findViewById(R.id.editTextSurname)
        etPhone = findViewById(R.id.editTextPhone)
        etAge = findViewById(R.id.editTextNumber)
        bBTN1 = findViewById(R.id.button)
        bBTN2 = findViewById(R.id.button2)
        var textView2: TextView = findViewById(R.id.textView2)
        var textView3: TextView = findViewById(R.id.textView3)
        var textView5: TextView = findViewById(R.id.textView5)
        var textView8: TextView = findViewById(R.id.textView8)

        this.etName?.addTextChangedListener(textWatcher)
        this.etSurname?.addTextChangedListener(textWatcher)
        this.etPhone?.addTextChangedListener(textWatcher)
        this.etAge?.addTextChangedListener(textWatcher)

        bBTN1?.setOnClickListener {
            textView2.text = "Name: ${etName?.text}"
            textView3.text = "Surname: ${etSurname?.text}"
            textView5.text = "Phone: ${etPhone?.text}"
            textView8.text = "Age: ${etAge?.text}"
            bBTN2?.isEnabled = true
            it.hideKeyboard() //Бесит клавиатура - из-за нее не видно таблицы
        }

        bBTN2?.setOnClickListener {
            textView2.text = ""
            textView3.text = ""
            textView5.text = ""
            textView8.text = ""
        }

    }
}