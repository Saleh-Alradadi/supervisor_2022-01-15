package com.example.supervisor_.RandomEmps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.supervisor_.LocationsInfos.LocationsDB;
import com.example.supervisor_.LocationsInfos.LocationsViewModel;
import com.example.supervisor_.R;
import com.example.supervisor_.UsersInfos.UsersDB;
import com.example.supervisor_.UsersInfos.UsersViewModel;

import java.util.ArrayList;
import java.util.List;

public class ResultRandomName extends AppCompatActivity {

    private UsersViewModel mUsersViewModel;
    private LocationsViewModel mLocationsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_random_name);


        ArrayList<String> arrayListNa = new ArrayList<>();
        ArrayList<String> arrayListLo = new ArrayList<>();




        mUsersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
        mUsersViewModel.getAllUsers().observe(this, new Observer<List<UsersDB>>() {
            @Override
            public void onChanged(List<UsersDB> usersDBS) {

                for (int i = 0; i < usersDBS.size(); i++) {
                    UsersDB S = usersDBS.get(i);
                    arrayListNa.add(S.getNamedb());
                }

                random_names randomNames = new random_names();

                ArrayList<String> arrayListRes = new ArrayList<>();
                arrayListRes = randomNames.distribution_Plan_1(arrayListNa);
                TextView textView = (TextView) findViewById(R.id.textResRanName);
                String ResName = "";
                for (int i = 0; i < arrayListRes.size(); i++) {
                    ResName = ResName + "\n" +  arrayListRes.get(i);
                }
                textView.setText(ResName);

            }
        });


        mLocationsViewModel = ViewModelProviders.of(this).get(LocationsViewModel.class);
        mLocationsViewModel.getAllLocations().observe(this, new Observer<List<LocationsDB>>() {
            @Override
            public void onChanged(List<LocationsDB> locationsDBS) {

                for (int i = 0; i < locationsDBS.size(); i++) {
                    LocationsDB S = locationsDBS.get(i);
                    arrayListLo.add(S.getNameLocation());
                }

                TextView textView = (TextView) findViewById(R.id.textLocation);
                String ResLocation = "";
                for (int i = 0; i < arrayListLo.size(); i++) {
                    ResLocation = ResLocation + "\n" +  arrayListLo.get(i);
                }
                textView.setText(ResLocation);

            }
        });







    }
}