package com.example.supervisor_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListNameItem extends AppCompatActivity {

    private UsersViewModel mUsersViewModel;


    private RecyclerView mRecyclerView;
    private Users_Adapter mUsers_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name_item);

        setTitle("List Of Names");

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

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mUsersViewModel.delete(mUsers_adapter.getUserAt(position));

            }
        }).attachToRecyclerView(mRecyclerView);


        mUsers_adapter.onItemClickListner(new Users_Adapter.OnItemclickListner() {
            @Override
            public void onItemClick(UsersDB User) {
                Intent i = new Intent(ListNameItem.this, AddName.class);
                i.putExtra(AddName.EXTRA_ID, User.getId());
                i.putExtra(AddName.EXTRA_NAME, User.getNamedb());
                i.putExtra(AddName.EXTRA_USER, User.getUserdb());
                i.putExtra(AddName.EXTRA_SALES, User.getSalesdb());
                i.putExtra(AddName.EXTRA_DAYOFF, User.getDayOffdb());
                i.putExtra(AddName.EXTRA_EMAIL, User.getEmaildb());
                startActivity(i);
            }
        });






    }
}