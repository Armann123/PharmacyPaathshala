package com.example.pharmpdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText enteremail, enterpassword;

    LinearLayout loginbutton, sighnup,forgot_password;
    FirebaseAuth firebaseauth;
    public static FirebaseUser current_user;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        enteremail = findViewById(R.id.email);
        enterpassword = findViewById(R.id.password);
        loginbutton = findViewById(R.id.btn_login);
        sighnup = findViewById(R.id.btn_signup);
        forgot_password= findViewById(R.id.btn_forgot_pswd);

        firebaseauth = FirebaseAuth.getInstance();
        forgot_password.setOnClickListener(v -> startActivity(new Intent(Login.this, forgotPassword.class)));
        sighnup.setOnClickListener(v -> startActivity(new Intent(Login.this, registrationform.class)));
        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        loginbutton.setOnClickListener(v -> {
            String email_text = enteremail.getText().toString().trim();
            String password_text = enterpassword.getText().toString().trim();
            if (TextUtils.isEmpty(email_text)) {
                enteremail.setError("Enter Your Email");
            } else if (TextUtils.isEmpty(password_text)) {
                enterpassword.setError("Enter your Password");
            } else {
                loginuser(email_text, password_text);
            }

        });
    }

    private void loginuser(String email_text, String password_text) {
        firebaseauth.signInWithEmailAndPassword(email_text, password_text).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

                if (Objects.requireNonNull(firebaseauth.getCurrentUser()).isEmailVerified()) {
                    current_user = firebaseauth.getCurrentUser();
                    SharedPreferences.Editor editor =sharedpreferences.edit();
                    editor.putString("email", email_text);
                    editor.putString("pswd", password_text);
                    editor.putString("user", firebaseauth.getUid());
                    editor.commit();

                    startActivity(new Intent(Login.this, Pharmfileld.class));
                    finish();
                } else {
                    Toast.makeText(Login.this, "Please verify the email", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(Login.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

