package com.example.supervisor_.LocationsInfos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.supervisor_.R;

import java.util.List;

public class LoactionsList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Loactions_Adapter mloactions_adapter;
    private LocationsViewModel mlocationsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loactions_list);



        setTitle("List Of Location");

        mRecyclerView = findViewById(R.id.Loactions_Rec);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mloactions_adapter = new Loactions_Adapter();
        mRecyclerView.setAdapter(mloactions_adapter);

        mlocationsViewModel = ViewModelProviders.of(this).get(LocationsViewModel.class);
        mlocationsViewModel.getAllLocations().observe(this, new Observer<List<LocationsDB>>() {
            @Override
            public void onChanged(List<LocationsDB> locationsDBS) {
                mloactions_adapter.setUsers(locationsDBS);
            }
        });

        mloactions_adapter.onItemClickListner(new Loactions_Adapter.OnItemclickListner() {
            @Override
            public void onItemClick(LocationsDB locationsDB) {
                Intent i = new Intent(LoactionsList.this, AddLoaction.class);
                i.putExtra(AddLoaction.EXTRA_ID_L, locationsDB.getIdLocation());
                i.putExtra(AddLoaction.EXTRA_Loaction, locationsDB.getNameLocation());
                i.putExtra(AddLoaction.EXTRA_Classification, locationsDB.getClassification());
                startActivity(i);
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
                mlocationsViewModel.delete(mloactions_adapter.getLocationsAt(position));

            }
        }).attachToRecyclerView(mRecyclerView);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.AddNewName) {
            Intent intent = new Intent();
            intent.setClass(LoactionsList.this, AddLoaction.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}