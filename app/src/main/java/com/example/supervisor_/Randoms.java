package com.example.supervisor_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Randoms extends AppCompatActivity {

    TextView textViewNames;
    String getName = "" , getUser = "" , getSales = "" , getDayOff = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setTitle("Random");



        textViewNames = findViewById(R.id.Names);


        ArrayList<random_names> Users = new ArrayList<>();
        ArrayList<String> ListNamesForRandom = new ArrayList<>();

        //try&catch
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            getName = bundle.getString("Key_Name");
            getUser = bundle.getString("Key_User");
            getSales = bundle.getString("Key_Sales");
            getDayOff = bundle.getString("Key_DayOff");

        }

//        Users.add(new random_names("Ali" , "OS5000" , "0" , "friday"));
//        Users.add(new random_names("mahdi" , "OS5100" , "1" , "sunday"));
//        Users.add(new random_names("bader" , "OS50020" , "2" , "monday"));
//        Users.add(new random_names("khaled" , "OS5040" , "3" , "Saturday"));





        try{
            StringBuilder ListNames = new StringBuilder(Users.get(0).Name);
            ListNamesForRandom.add(Users.get(0).Name);
            for (int i = 1; i < Users.size(); i++) {
                ListNames.append(" , ").append(Users.get(i).Name);
                ListNamesForRandom.add(Users.get(i).Name);
            }
            textViewNames.setText(ListNames.toString());
        }catch (Exception e){
            e.getMessage();
        }








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
            intent.setClass(Randoms.this, AddName.class);
            startActivity(intent);
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}

