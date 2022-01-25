package com.example.supervisor_;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddNameViewModel extends AndroidViewModel {
    private UsersRepository mRepository;

    public AddNameViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UsersRepository(application);
    }

    public void insert(UsersDB usersDB){
        mRepository.insert(usersDB);
    }

    public void update(UsersDB usersDB){
        mRepository.update(usersDB);
    }


}
