package com.example.supervisor_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Randoms extends AppCompatActivity {
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





    }


}


