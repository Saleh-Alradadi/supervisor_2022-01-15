package com.example.supervisor_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddName extends AppCompatActivity {

//    EditText newName , newUser , newSales, newDayOff;
//    Button btn_addNewEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        //ArrayList<random_names> Users = new ArrayList<>();


//        btn_addNewEmployee = findViewById(R.id.AddNewEmployee);
//
//        btn_addNewEmployee.setOnClickListener(view -> {
//            newName = findViewById(R.id.NewName);
//            newUser = findViewById(R.id.NewUser);
//            newSales = findViewById(R.id.NewSales);
//            newDayOff = findViewById(R.id.NewDayOff);
//
//
//            Intent intent = new Intent(AddName.this , Randoms.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("Key_Name", newName.getText().toString());
//            bundle.putString("Key_User", newUser.getText().toString());
//            bundle.putString("Key_Sales", newSales.getText().toString());
//            bundle.putString("Key_DayOff", newDayOff.getText().toString());
//            intent.putExtras(bundle);
//            startActivity(intent);
//            finish();
//        });



    }
}