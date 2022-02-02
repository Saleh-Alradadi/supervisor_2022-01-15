package com.example.supervisor_.LocationsInfos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddLoactionViewModel extends AndroidViewModel {

    private LocationsRepository mRepository;

    public AddLoactionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new LocationsRepository(application);
    }

    public void insert(LocationsDB locationsDB){
        mRepository.insert(locationsDB);
    }

    public void update(LocationsDB locationsDB){
        mRepository.update(locationsDB);
    }

}
