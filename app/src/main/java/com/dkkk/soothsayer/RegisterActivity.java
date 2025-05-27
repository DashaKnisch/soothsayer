package com.dkkk.soothsayer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etPassword;
    Button btnRegister;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        dbHelper = new DBHelper(this);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String password = etPassword.getText().toString();

            if (!name.isEmpty() && !password.isEmpty()) {
                boolean inserted = dbHelper.insertUser(name, password);
                if (inserted) {
                    Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Пользователь уже существует", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
