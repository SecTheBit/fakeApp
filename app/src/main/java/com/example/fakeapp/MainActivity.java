package com.example.fakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button=findViewById(R.id.create_account_button);
        EditText username=findViewById(R.id.username_edittext);
        EditText password=findViewById(R.id.password_edittext);
        Button submit=findViewById(R.id.submitbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_signup= new Intent(view.getContext(),Signup.class);
                startActivity(intent_signup);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login_users=username.getText().toString();
                String login_passwords=password.getText().toString();
                if(login_users!=null && login_passwords!=null){
                    SharedPreferences ssp = getSharedPreferences("mypref",MODE_PRIVATE);
                    String name_check=ssp.getString("name","");
                    String password_check=ssp.getString("password","");
                    if(name_check.equals(login_users) && password_check.equals(login_passwords)){
                        Intent intent_login=new Intent(view.getContext(),dashboard.class);
                        startActivity(intent_login);
                    }
                    else{
                        Log.d(login_passwords,"login_user");
                        Log.d(password_check,"name_check");
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
    }

}