package com.example.dell.logapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout musername;
    private TextInputLayout mpassword;
    private Button mbutton;
    private Toolbar toolbar;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("LOGIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(findViewById(R.id.container), "back pressed",Snackbar.LENGTH_SHORT).show();
                return false;
            }
        });


        musername = findViewById(R.id.main_til_username);
        musername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity before", charSequence.toString());
                validateUsername(mpassword.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity onText", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("MainActivity after", editable.toString());
                validateUsername(editable.toString());
            }
        });

        mpassword = findViewById(R.id.main_til_password);
        mpassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity before", charSequence.toString());
                validatePassword(mpassword.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("MainActivity onText", charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("MainActivity after", editable.toString());
                validatePassword(editable.toString());
            }
        });
        mbutton = findViewById(R.id.main_btn);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"SUCCESS",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void validateUsername(String username){
       if (TextUtils.isEmpty(username)){
           musername.setError("Input Username");
           mbutton.setEnabled(false);
           mbutton.setBackgroundColor(Color.GRAY);
       }else{
           musername.setError(null);
           mbutton.setEnabled(true);
           mbutton.setBackgroundColor(Color.GREEN);
       }
    }

    public void validatePassword(String password){
        if (TextUtils.isEmpty(password)){
            mpassword.setError("Input Password");
            mbutton.setEnabled(false);
            mbutton.setBackgroundColor(Color.GRAY);
        }else {
            mpassword.setError(null);
            mbutton.setEnabled(true);
            mbutton.setBackgroundColor(Color.GREEN);
        }
    }

}
