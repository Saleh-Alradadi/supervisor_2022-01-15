package com.example.supervisor_.LocationsInfos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.supervisor_.R;

public class AddLoaction extends AppCompatActivity {

    EditText newLoaction , newClassification ;
    Button btn_addNewLoaction;

    private AddLoactionViewModel mAddLoactionViewModel;
    private int mId;

    private boolean editMode;

    public static final String EXTRA_ID_L = "package com.example.supervisor_ExtraID";
    public static final String EXTRA_Loaction = "package com.example.supervisor_ExtraName";
    public static final String EXTRA_Classification = "package com.example.supervisor_ExtraUser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loaction);

        mAddLoactionViewModel = ViewModelProviders.of(this).get(AddLoactionViewModel.class);

        newLoaction = findViewById(R.id.NewLocation);
        newClassification = findViewById(R.id.NewClassification);

        Intent i = getIntent();
        if (i.hasExtra(EXTRA_ID_L)){
            //Update
            setTitle("Update Of Location");
            editMode = true;
            mId = i.getIntExtra(EXTRA_ID_L , -1);
            newLoaction.setText(i.getStringExtra(EXTRA_Loaction));
            newClassification.setText(i.getStringExtra(EXTRA_Classification));

        }else{
            //insert
            setTitle("Add Of Location");
            editMode = false;
        }

        btn_addNewLoaction = findViewById(R.id.btn_AddNewLocation);
        btn_addNewLoaction.setOnClickListener(view -> {


            saveNewEmployeeInRoomDB();

        });

    }

    private void saveNewEmployeeInRoomDB() {
        String Loaction = newLoaction.getText().toString().trim();
        String Classification = newClassification.getText().toString().trim();

        LocationsDB locationssDBObj = new LocationsDB(Loaction ,Classification);

        if(Loaction.isEmpty() || Classification.isEmpty() ){
            Toast.makeText(AddLoaction.this,"Please fill All inputs", Toast.LENGTH_LONG).show();
            return;
        }
        if (editMode){
            locationssDBObj.setIdLocation(mId);
            mAddLoactionViewModel.update(locationssDBObj);

        }else {
            mAddLoactionViewModel.insert(locationssDBObj);
        }
        finish();

    }

}