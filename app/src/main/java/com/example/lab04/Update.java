package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
public class Update extends AppCompatActivity {
    EditText firstName, lastName, age, userName;
    DatabaseReference reference;
    Button updateBtn;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        age = findViewById(R.id.age);
        userName = findViewById(R.id.userName);
        updateBtn = findViewById(R.id.updateBtn);
        users = new Users();
        reference =FirebaseDatabase.getInstance().getReference("Users");
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(firstName.getText().toString(),lastName.getText().toString(),age.getText().toString());
            }
        });
    }
    private void updateData(String toString, String toString1, String toString2) {
        HashMap User = new HashMap();
        User.put("firstName",toString);
        User.put("lastName",toString1);
        User.put("age",toString2);
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(userName.getText().toString()).updateChildren(User);
        Toast.makeText(Update.this,"SuccessfullyUpdated",Toast.LENGTH_SHORT).show();
    }
}