package com.example.supervisor_;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsViewModel extends AndroidViewModel {

    private LocationsRepository mRepository;
    private LiveData<List<LocationsDB>> mAllUsers;

    public LocationsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new LocationsRepository(application);
        mAllUsers = mRepository.GetAllLocations();
    }

    public void insert(LocationsDB locationsDB){
        mRepository.insert(locationsDB);
    }

    public void delete(LocationsDB locationsDB){
        mRepository.delete(locationsDB);
    }

    public void update(LocationsDB locationsDB){
        mRepository.update(locationsDB);
    }

    public void deletAllUsers(LocationsDB locationsDB){
        mRepository.deleteAllUsers();
    }

    public LiveData<List<LocationsDB>> getAllLocations(){
        return mRepository.GetAllLocations();
    }


}
