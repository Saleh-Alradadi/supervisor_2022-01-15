package com.example.supervisor_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Randoms extends AppCompatActivity {

    TextView textViewNames1;
//    String getName = "" , getUser = "" , getSales = "" , getDayOff = "";
//
//    private UsersViewModel mUsersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setTitle("Random");


//        mUsersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
//        mUsersViewModel.getAllUsers().observe(this, new Observer<List<UsersDB>>() {
//            @Override
//            public void onChanged(List<UsersDB> usersDBS) {
//                //Update UI
//                //RecyclerView
//                Toast.makeText(Randoms.this,"this Method is Work",Toast.LENGTH_LONG).show();
//
//            }
//        });

        textViewNames1 = findViewById(R.id.Names);
        textViewNames1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Randoms.this,ListNameItem.class);
                startActivity(intent);

            }
        });


//        ArrayList<random_names> Users1 = new ArrayList<>();
//        ArrayList<String> ListNamesForRandom = new ArrayList<>();
//
//        //try&catch
//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            getName = bundle.getString("Key_Name");
//            getUser = bundle.getString("Key_User");
//            getSales = bundle.getString("Key_Sales");
//            getDayOff = bundle.getString("Key_DayOff");
//
//        }

        //Users1.add(new random_names(getName , getUser , getSales , getDayOff));
//        Users.add(new random_names("Ali" , "OS5000" , "0" , "friday"));
//        Users.add(new random_names("mahdi" , "OS5100" , "1" , "sunday"));
//        Users.add(new random_names("bader" , "OS50020" , "2" , "monday"));
//        Users.add(new random_names("khaled" , "OS5040" , "3" , "Saturday"));





//        try{
//            StringBuilder ListNames = new StringBuilder(Users1.get(0).Name);
//            ListNamesForRandom.add(Users1.get(0).Name);
//            for (int i = 1; i < Users1.size(); i++) {
//                ListNames.append(" , ").append(Users1.get(i).Name);
//                ListNamesForRandom.add(Users1.get(i).Name);
//
//            }
//            textViewNames1.setText(ListNames.toString());
//        }catch (Exception e){
//            e.getMessage();
//        }

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


