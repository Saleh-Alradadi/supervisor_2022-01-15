package com.example.supervisor_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button random;
    Button location;
    Button namesOfTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Home");

        random = (Button) findViewById(R.id.Random);
        location = (Button) findViewById(R.id.Location_btn);
        namesOfTeam = (Button) findViewById(R.id.NamesOfTeam);

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , Randoms.class);
                startActivity(intent);

            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , LoactionsList.class);
                startActivity(intent);

            }
        });
        namesOfTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , ListNameItem.class);
                startActivity(intent);

            }
        });

    }
}