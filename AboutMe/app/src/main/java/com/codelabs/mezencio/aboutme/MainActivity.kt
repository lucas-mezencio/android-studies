package com.codelabs.mezencio.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNickname: EditText
    private lateinit var nicknameTextView: TextView
    private lateinit var doneBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNickname = findViewById(R.id.et_nickname)
        nicknameTextView = findViewById(R.id.tv_nickname)
        doneBtn = findViewById(R.id.btn_done)

        doneBtn.setOnClickListener {
            addNickname(it)
        }

        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        nicknameTextView.text = editTextNickname.text
        nicknameTextView.visibility = View.VISIBLE
        editTextNickname.visibility = View.GONE
        view.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        view.visibility = View.GONE
        editTextNickname.visibility = View.VISIBLE
        doneBtn.visibility = View.VISIBLE

        editTextNickname.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editTextNickname, 0)
    }
}