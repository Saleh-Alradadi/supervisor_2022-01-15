package com.example.supervisor_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SuppressWarnings("unchecked")
public class random_names {



    //Random without if statement
    public ArrayList distribution_Plan_1(ArrayList Plan){

        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList = Plan;
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public void distribution_Plan_2(ArrayList Plan){

    }

    public void distribution_Plan_3(ArrayList Plan){

    }

    public void distribution_Plan_4(ArrayList Plan){

    }

    public void send(){

    }
    



}
