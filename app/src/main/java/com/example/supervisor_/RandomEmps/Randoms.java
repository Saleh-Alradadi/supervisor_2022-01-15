package com.example.supervisor_.RandomEmps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.supervisor_.R;
import com.example.supervisor_.UsersInfos.UsersDB;
import com.example.supervisor_.UsersInfos.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Randoms extends AppCompatActivity {
    Button btnPlan1;

    public static List<UsersDB> arrayListUser = new ArrayList<>();

    TextView textViewNames1;
    private UsersViewModel mUsersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setTitle("Random");


        ArrayList<String> RandomListName = new ArrayList<>();
        textViewNames1 = findViewById(R.id.NamesOfList);
        for (int i = 0; i < arrayListUser.size(); i++) {
            RandomListName.add(arrayListUser.get(i).getNamedb());
        }



        mUsersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        mUsersViewModel.getAllUsers().observe(this, new Observer<List<UsersDB>>() {
            @Override
            public void onChanged(List<UsersDB> usersDBS) {
                //Update UI
                arrayListUser = usersDBS;

                String SS = "";

                for (int i = 0; i <arrayListUser.size(); i++) {

                    UsersDB S = arrayListUser.get(i);
                    if(i == 0){
                        SS = S.getNamedb();
                    }else{
                        SS = SS + " , " + S.getNamedb();
                    }
                }
                textViewNames1.setText(SS);
            }
        });

        btnPlan1 = (Button)findViewById(R.id.Plan1);
        btnPlan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Randoms.this,ResultRandomName.class);
                startActivity(intent);
            }
        });



    }


}


