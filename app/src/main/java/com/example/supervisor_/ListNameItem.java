package com.example.supervisor_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ListNameItem extends AppCompatActivity {

    private UsersViewModel mUsersViewModel;

    private RecyclerView mRecyclerView;
    private Users_Adapter mUsers_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name_item);


        mRecyclerView = findViewById(R.id.User_Rec);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mUsers_adapter = new Users_Adapter();
        mRecyclerView.setAdapter(mUsers_adapter);


        mUsersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        mUsersViewModel.getAllUsers().observe(this, new Observer<List<UsersDB>>() {


            @Override
            public void onChanged(List<UsersDB> usersDBS) {
                //Update UI
                //RecyclerView
                mUsers_adapter.setUsers(usersDBS);

            }
        });


    }
}