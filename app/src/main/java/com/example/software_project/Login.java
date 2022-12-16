package com.example.software_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class Login extends AppCompatActivity {


    private UserDataBase UserDataBase;
    private TextView txtRegister, txtContinue;
    private EditText edtEmail, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        txtRegister=findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check()) {

                    startActivity(new Intent(Login.this, Test.class));
                }
            }
        });
        txtContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, homepage.class));
            }
        });


//        User user = UserDataBase.search(edtEmail.getText().toString().trim());
//        Intent intent = new Intent(Login.this, Settings.class);
//        intent.putExtra("username", user.getUsername());
//        intent.putExtra("email", user.getEmail());
//        intent.putExtra("password", user.getPassword());



    }


    public void init() {
        UserDataBase = new UserDataBase(this);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        txtContinue= findViewById(R.id.txtContinue);
    }

//    public void check() {
//        List<User> users = UserDataBase.getUsers();
//
//        for (int i = 0; i < users.size(); i++) {
//            if (edtEmail.getText().toString().equals(users.get(i).getEmail())
//                    && edtPassword.getText().toString().equals(users.get(i).getPassword())) {
//                startActivity(new Intent(Login.this, Test.class));
//            }
//            else if (!edtEmail.getText().toString().equals(users.get(i).getEmail())){
//                edtEmail.setError("Account Not Registered!");
//                edtEmail.requestFocus();
//            }
//            else if(edtEmail.getText().toString().equals(users.get(i).getEmail())
//                    && !edtPassword.getText().toString().equals(users.get(i).getPassword())) {
//
//                edtPassword.setError("Incorrect Password!");
//                edtPassword.requestFocus();
//            }
//
//
//        }
//
//
//    }

    public boolean check() {
        List<User> users = UserDataBase.getUsers();
        boolean validemail = true;
        boolean validpassword = true;

        if(edtEmail.getText().toString().equals("Admin@gmail.com") && edtPassword.getText().toString().equals("admin")) {
            Toast.makeText(this, "Welcome admin", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Adminhomepage.class));
            return true;
        }

        for (int i = 0; i < users.size(); i++) {
            if (edtEmail.getText().toString().equals(users.get(i).getEmail())
                    && edtPassword.getText().toString().equals(users.get(i).getPassword())) {
                return true;
            } else if (!edtEmail.getText().toString().equals(users.get(i).getEmail())) {
                validemail = false;

            } else if (edtEmail.getText().toString().equals(users.get(i).getEmail())
                    && !edtPassword.getText().toString().equals(users.get(i).getPassword())) {
                validpassword = false;

            }
        }
        if (validemail == false) {
            edtEmail.setError("Email not registered");
            edtEmail.requestFocus();
            return false;
        } else if (validemail==true && validpassword == false) {
            edtPassword.setError("Incorrect Password!");
            edtPassword.requestFocus();
            return false;
        }

        return true;

    }
}