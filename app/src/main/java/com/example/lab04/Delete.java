package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Delete extends AppCompatActivity {
    EditText username;
    Button delete;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        username = findViewById(R.id.username);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                deleteData(username.getText().toString());
                Toast.makeText(Delete.this,"SuccessfullyDeleted",Toast.LENGTH_SHORT).show();
            }
        });
    } private void deleteData(String toString) {
        reference =FirebaseDatabase.getInstance().getReference("Users");
        reference.child(username.getText().toString()).removeValue();
    }
}
//DELETE ALL:
/*
*package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Delete extends AppCompatActivity {
    Button delete;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAllData();
                Toast.makeText(Delete.this, "Successfully Deleted All Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteAllData() {
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.removeValue();
    }
}
* */