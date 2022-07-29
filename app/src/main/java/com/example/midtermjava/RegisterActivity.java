package com.example.midtermjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText userNameRegText = findViewById(R.id.editTextWelUsername);
        EditText passWordRegText = findViewById(R.id.editTextWelPass);
        Button regButton = findViewById(R.id.registerWelButton);

        regButton.setBackgroundResource(R.drawable.round_button);
        Intent intent = getIntent();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userNameRegText.getText().toString();
                String password = passWordRegText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                bundle.putString("password", password);

                Intent i = new Intent(RegisterActivity.this , MainActivity.class);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

    }
}
