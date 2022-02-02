package com.example.supervisor_.UsersInfos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {

    private UsersRepository mRepository;
    private LiveData<List<UsersDB>> mAllUsers;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UsersRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    public void insert(UsersDB usersDB){
       mRepository.insert(usersDB);
    }

    public void delete(UsersDB usersDB){
           mRepository.delete(usersDB);
    }

    public void update(UsersDB usersDB){
           mRepository.update(usersDB);
    }

    public void deletAllUsers(UsersDB usersDB){
           mRepository.deleteAllUsers();
    }

    public LiveData<List<UsersDB>> getAllUsers(){
        return mRepository.getAllUsers();
    }

}
