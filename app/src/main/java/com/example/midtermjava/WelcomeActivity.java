package com.example.midtermjava;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView textView1 = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        textView1.setText("Welcome " + username);
        Toast.makeText(getApplicationContext(),"Welcome " + username + "/" + password, Toast.LENGTH_LONG).show();

        textView1.setTextSize(20);
    }
}
