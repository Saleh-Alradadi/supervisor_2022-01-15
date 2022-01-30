package com.example.supervisor_;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unchecked")
public class random_names {



    //Random without if statement
    public ArrayList distribution_Plan_1(ArrayList Plan){
        Random random = new Random();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = Plan;
        ArrayList<String> ArrayResultRandom = new ArrayList<>();

        for (int i = 0; i < Plan.size(); i++) {
            int RandomNameInt = random.nextInt(arrayList.size());
            String S = arrayList.get(RandomNameInt);
            ArrayResultRandom.add(S);
            arrayList.remove(RandomNameInt);
        }
        return ArrayResultRandom;
    }

    public void distribution_Plan_2(ArrayList Plan){

    }

    public void distribution_Plan_3(ArrayList Plan){

    }

    public void distribution_Plan_4(ArrayList Plan){

    }

    public void send(){

    }

    public String Edit_Name(String Name){

        return "";
    }

    public void Delete_Name(){

    }



}
