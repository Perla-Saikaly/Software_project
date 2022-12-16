package com.example.software_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private UserDataBase userDataBase;
    private TextView txtLogin;
    private EditText edtUserName, edtEmail, edtPassword;
    private Button btnRegister;
    private EditText confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()) {
                    User user = new User();
                    try {
                        user = new User( edtUserName.getText().toString().trim(), edtEmail.getText().toString().trim(), edtPassword.getText().toString().trim());
                    Toast.makeText(Register.this, user.getUsername()+" "+user.getEmail() + "  "+user.getPassword()+ " has been registered successfully", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    boolean success = userDataBase.insertData(user);
                    if (success)
                        startActivity(new Intent(Register.this, Login.class));
                }
            }
        });
        txtLogin=findViewById(R.id.txtlogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));

            }});

    }

    public void init() {
        userDataBase = new UserDataBase(this);
        edtUserName = findViewById(R.id.edtUserName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtlogin);
        confirmpassword=findViewById(R.id.edtConfirmPassword);
    }

    private boolean check() {
        String name = edtUserName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String confirm= confirmpassword.getText().toString().trim();
        if (name.isEmpty()) {
            edtUserName.setError("Name is required!");
            edtUserName.requestFocus();
            return false;
        }
        if (email.isEmpty()) {
            edtEmail.setError("Email is required!");
            edtEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Please provide a valid email!");
            edtEmail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            edtPassword.setError("Password is required!");
            edtPassword.requestFocus();
            return false;
        }
        if(!password.equals(confirm)){
            confirmpassword.setError("Password not match");
            confirmpassword.requestFocus();
            return false;
        }
        if (confirm.isEmpty()){
            confirmpassword.setError("Please confirm password");
            confirmpassword.requestFocus();
            return false;
        }
        if (password.length() < 8) {
            edtPassword.setError("Password is too short!");
            edtPassword.requestFocus();
            return false;
        }
        return true;
    }
}