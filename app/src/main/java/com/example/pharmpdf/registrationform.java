package com.example.pharmpdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class registrationform extends AppCompatActivity {
    EditText name, password, address, email;

    CheckBox ch_t_and_c;
    LinearLayout register;
    FirebaseAuth firebaseauth;
    FirebaseDatabase firebase;
    FirebaseUser firebaseuser;
    DatabaseReference databaseReference;
    private User user;

    Boolean TC_CHECKED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);
        connectxml();

        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference("users");
        firebaseauth = FirebaseAuth.getInstance();

        firebaseuser = firebaseauth.getCurrentUser();


        ch_t_and_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    TC_CHECKED = true;
                }else {
                    TC_CHECKED = false;
                }
            }
        });

        register.setOnClickListener(v -> {

            String email_text = email.getText().toString().trim();
            String password_text = password.getText().toString().trim();
            String name_text = name.getText().toString().trim();


            if (email_text.isEmpty()) {
                email.setError("Enter Email");

            } else if (password_text.isEmpty()) {
                password.setError("Enter Password");

            } else if (name_text.isEmpty()) {
                name.setError("Enter Name");

            } else if (!TC_CHECKED) {
                Toast.makeText(this, getString(R.string.i_agree_with_terms_conditions), Toast.LENGTH_SHORT).show();

            } else {
                user = new User("",email_text, password_text, name_text, false);
                userregistration(email_text, password_text, name_text);
            }
        });
    }


    private void userregistration(String email_text, String password_text, String name_text) {
        firebaseauth.createUserWithEmailAndPassword(email_text, password_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Objects.requireNonNull(firebaseauth.getCurrentUser()).sendEmailVerification().addOnCompleteListener(task12 -> {
                        if (task12.isSuccessful()) {
                            Toast.makeText(registrationform.this, "Registration successful Please verify email address", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = firebaseauth.getCurrentUser();
                            User user_data = new User("", email_text, password_text, name_text, false);
                            updateUI(user, user_data);
                        } else {

                            Toast.makeText(registrationform.this, Objects.requireNonNull(task12.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                    String userid = firebaseauth.getCurrentUser().getUid();
                    databaseReference.child(userid);


                    HashMap<String, String> datauser = new HashMap<>();
                    datauser.put("userid", userid);
                    datauser.put("email", email_text);
                    datauser.put("password", password_text);
                    datauser.put("name", name_text);
                    FirebaseUser user = firebaseauth.getCurrentUser();

                    User user_data = new User(userid, email_text, password_text, name_text, false);
                    updateUI(user, user_data);
//                    databaseReference.setValue(datauser).addOnCompleteListener(task1 -> {
//                        if (task1.isSuccessful()) {
//
//                            startActivity(new Intent(registrationform.this, Email.class));
//                            finish();
//
//                        } else
//
//                            Toast.makeText(registrationform.this, "error " + task1.getException(), Toast.LENGTH_SHORT).show();
//                        {
//
//
//                        }
//
//                    });
                    startActivity(new Intent(registrationform.this, Login.class));
                    finish();

                } else {
                    Toast.makeText(registrationform.this, "error " + task.getException(), Toast.LENGTH_SHORT).show();

                }

            }

            private void updateUI(FirebaseUser currentuser, User user_data) {
//                String KeyId = databaseReference.push().getKey();
                String userId = currentuser.getUid();
                databaseReference.child(userId).setValue(user_data);
            }
        });
    }


    private void connectxml() {
        name = findViewById(R.id.nameid);
        address = findViewById(R.id.addressid);
        password = findViewById(R.id.passwordid);
        email = findViewById(R.id.emailid);
        register = findViewById(R.id.registration);
        ch_t_and_c = findViewById(R.id.ch_t_and_c);


    }
}