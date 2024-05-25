package com.example.ql_ban_do_an.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ql_ban_do_an.R;
import com.example.ql_ban_do_an.View.Domain.Foods;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvKq;
    ArrayList<Foods> lstFood = new ArrayList<>();
    ArrayList<String>lsDataLV = new ArrayList<>();
    ArrayAdapter<String> adapter;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        FirebaseApp.initializeApp(this);
        // initData();
        getDataFromFirebase();
        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,lsDataLV);
        lvKq.setAdapter(adapter);

    }

    public void addControls()
    {
        lvKq = (ListView) findViewById(R.id.lvKq);
    }

    ArrayList<String> convertToArrString(ArrayList<Foods> lstF)
    {
        ArrayList<String>lsString=new ArrayList<>();
        for (Foods f:lstF ) {
            String s = "ID: " + f.getId() + " -  " + "Price: "+String.valueOf(f.getPrice());
            lsString.add(s);
        }
        return lsString;
    }

    public void getDataFromFirebase () {

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://qlbandoan-6f252-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Foods");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstFood.clear();
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    Foods food = userSnapshot.getValue(Foods.class);
                    lstFood.add(food);
                }
                lsDataLV = convertToArrString(lstFood);
                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lsDataLV);
                lvKq.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}