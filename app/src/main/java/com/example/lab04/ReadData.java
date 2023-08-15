package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReadData extends AppCompatActivity {
    EditText uname;
    TextView fname, lname, age;
    FirebaseDatabase db;
    DatabaseReference reference;
    Button show;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        uname = findViewById(R.id.uname);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        age = findViewById(R.id.age);
        show = findViewById(R.id.show);
        users = new Users();
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference =FirebaseDatabase.getInstance().getReference().child("Users").child(uname.getText().toString());
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                fname.setText(snapshot.child("firstName").getValue().toString());
                                lname.setText(snapshot.child("lastName").getValue().toString());
                                age.setText(snapshot.child("age").getValue().toString());
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                               Toast.makeText(ReadData.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}