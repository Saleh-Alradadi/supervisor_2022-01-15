package com.example.supervisor_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddName extends AppCompatActivity {

    EditText newName , newUser , newSales, newDayOff , newEmail;
    Button btn_addNewEmployee;

    private AddNameViewModel mAddNameViewModel;
    private int mId;

    private boolean editMode;

    public static final String EXTRA_ID = "package com.example.supervisor_ExtraID";
    public static final String EXTRA_NAME = "package com.example.supervisor_ExtraName";
    public static final String EXTRA_USER = "package com.example.supervisor_ExtraUser";
    public static final String EXTRA_SALES = "package com.example.supervisor_ExtraSales";
    public static final String EXTRA_DAYOFF = "package com.example.supervisor_ExtraDayoff";
    public static final String EXTRA_EMAIL = "package com.example.supervisor_ExtraEmail";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        mAddNameViewModel = ViewModelProviders.of(this).get(AddNameViewModel.class);

        ArrayList<random_names> Users = new ArrayList<>();

        newName = findViewById(R.id.NewName);
        newUser = findViewById(R.id.NewUser);
        newSales = findViewById(R.id.NewSales);
        newDayOff = findViewById(R.id.NewDayOff);
        newEmail = findViewById(R.id.NewEmail);

        Intent i = getIntent();
        if (i.hasExtra(EXTRA_ID)){
            //Update
            setTitle("Update Info");
            editMode = true;
            mId = i.getIntExtra(EXTRA_ID , -1);
            newName.setText(i.getStringExtra(EXTRA_NAME));
            newUser.setText(i.getStringExtra(EXTRA_USER));
            newSales.setText(i.getStringExtra(EXTRA_SALES));
            newDayOff.setText(i.getStringExtra(EXTRA_DAYOFF));
            newEmail.setText(i.getStringExtra(EXTRA_EMAIL));





        }else{
            //insert
            setTitle("Add new Employee Info");
            editMode = false;

        }

        btn_addNewEmployee = findViewById(R.id.AddNewEmployee);

        btn_addNewEmployee.setOnClickListener(view -> {


        saveNewEmployeeInRoomDB();

        });



    }


    private void saveNewEmployeeInRoomDB() {
        String Name = newName.getText().toString().trim();
        String User = newUser.getText().toString().trim();
        String Sales = newSales.getText().toString().trim();
        String DayOff = newDayOff.getText().toString().trim();
        String Email = newEmail.getText().toString().trim();

        UsersDB usersDBObj = new UsersDB(Name ,User ,Sales ,DayOff ,Email );

        if(Name.isEmpty() || User.isEmpty() || Sales.isEmpty() || DayOff.isEmpty() || Email.isEmpty()){
            Toast.makeText(AddName.this,"Please fill All inputs", Toast.LENGTH_LONG).show();
            return;
        }
        if (editMode){
            usersDBObj.setId(mId);

            mAddNameViewModel.update(usersDBObj);
        }else {
            mAddNameViewModel.insert(usersDBObj);
        }
        finish();
    }
}