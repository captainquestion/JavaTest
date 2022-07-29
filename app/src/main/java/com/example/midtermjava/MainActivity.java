package com.example.midtermjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.window.SplashScreen;

import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        EditText userNameText = findViewById(R.id.editTextUsername);
        EditText passWordText = findViewById(R.id.editTextPassword);
        Switch switchAct = findViewById(R.id.switch1);
        Button buttonReg = findViewById(R.id.buttonRegister);
        Button buttonLog = findViewById(R.id.buttonLogin);


        switchAct.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    buttonLog.setVisibility(View.INVISIBLE);
                    buttonReg.setVisibility(View.INVISIBLE);
                }
                else{
                    buttonLog.setVisibility(View.VISIBLE);
                    buttonReg.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    Log.d("sa,","sa");
                    Intent i = getIntent();
                    Bundle bundle = getIntent().getExtras();
                    String usernameReg = bundle.getString("username");
                    String passwordReg = bundle.getString("password");
                    String usernameEnt = userNameText.getText().toString();
                    String passwordEnt = passWordText.getText().toString();

                    if (usernameReg == null || passwordReg == null){
                        Toast.makeText(getApplicationContext(), "HATA ! ", Toast.LENGTH_LONG).show();
                        Log.d("HATA", "HATA");
                    }

                    if(usernameEnt.equals(usernameReg) && passwordEnt.equals(passwordReg)){
                        Intent intent2 = new Intent(MainActivity.this, WelcomeActivity.class);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("username", usernameEnt);
                        bundle2.putString("password", passwordEnt);
                        intent2.putExtras(bundle2);
                        startActivity(intent2);
                    }else if (!usernameEnt.equals(usernameReg) && passwordEnt.equals(passwordReg)){
                        Toast.makeText(getApplicationContext(), "Incorrect Username!", Toast.LENGTH_LONG).show();

                    }else if (usernameEnt.equals(usernameReg) && !passwordEnt.equals(passwordReg)){
                        Toast.makeText(getApplicationContext(), "Incorrect Password!", Toast.LENGTH_LONG).show();

                    }else{

                        Toast.makeText(getApplicationContext(), "Incorrect Credentials!", Toast.LENGTH_LONG).show();

                    }




            }
        });
    }
}