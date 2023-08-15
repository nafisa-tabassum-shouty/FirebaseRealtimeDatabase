package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
public class insert extends AppCompatActivity {
    EditText firstName, lastName, age, userName;
    FirebaseDatabase db;
    DatabaseReference reference;
    Button registerBtn;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        age = findViewById(R.id.age);
        userName = findViewById(R.id.userName);
        registerBtn = findViewById(R.id.registerBtn);


        users = new Users();
        reference =FirebaseDatabase.getInstance().getReference("Users");
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
               @Override
               public void onClick(View view) {
                        users.setUserName(userName.getText().toString());
                        users.setFirstName(firstName.getText().toString());
                        users.setLastName(lastName.getText().toString());
                        users.setAge(age.getText().toString());
                        reference.child(userName.getText().toString()).setValue(users);
                        Toast.makeText(insert.this,"SuccessfullyInserted",Toast.LENGTH_SHORT).show();
               }
        });
    }
}