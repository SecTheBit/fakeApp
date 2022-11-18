package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button create_account;
        EditText username=findViewById(R.id.username_edittext);
        EditText password=findViewById(R.id.password_edittext);
        create_account=findViewById(R.id.create_account_button);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(password.getText().toString())){
                         String user_createaccount=username.getText().toString();
                         String password_createaccount=password.getText().toString();
                         SharedPreferences ssp= getSharedPreferences("mypref",MODE_PRIVATE);
                         SharedPreferences.Editor ed=ssp.edit();
                         ed.putString("name",user_createaccount);
                         ed.putString("password",password_createaccount);
                         ed.apply();
                         Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Signup.this, "Field is Empty ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}