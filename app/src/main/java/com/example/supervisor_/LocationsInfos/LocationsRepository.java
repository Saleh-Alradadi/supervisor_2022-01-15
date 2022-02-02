package com.example.supervisor_.LocationsInfos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationsRepository {

    private LocationsDaoDB mLocationsDaoDB;
    private LiveData<List<LocationsDB>> getAllLocations;

    public LocationsRepository(Application app){
        LocationsRoomDB db = LocationsRoomDB.getInstance(app);
        mLocationsDaoDB = db.mlocationsDaoDB();
        getAllLocations = mLocationsDaoDB.getAllLocations();

    }

    //operation


    //insert
    public void insert(LocationsDB locationsDB){
        new LocationsRepository.InsertAsyncTask(mLocationsDaoDB).execute(locationsDB);
    }

    //delete
    public void delete(LocationsDB locationsDB){
        new LocationsRepository.DeleteAsyncTask(mLocationsDaoDB).execute(locationsDB);
    }

    //update
    public void update(LocationsDB locationsDB){
        new LocationsRepository.UpdateAsyncTask(mLocationsDaoDB).execute(locationsDB);
    }

    //getAllUsers
    public LiveData<List<LocationsDB>> GetAllLocations(){

        return getAllLocations;
    }

    //deleteAllUsers
    public void deleteAllUsers(){
        new LocationsRepository.DeleteAllLocationsAsyncTask(mLocationsDaoDB).execute();
    }


    private static class InsertAsyncTask extends AsyncTask<LocationsDB, Void ,Void> {

        public LocationsDaoDB mlocationsDaoDB;
        public InsertAsyncTask(LocationsDaoDB locationsDaoDB){
            mlocationsDaoDB = locationsDaoDB;
        }

        @Override
        protected Void doInBackground(LocationsDB... locationsDBS) {
            mlocationsDaoDB.insert(locationsDBS[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<LocationsDB, Void ,Void>{

        public LocationsDaoDB locationsDaoDB;
        public DeleteAsyncTask(LocationsDaoDB locationsDaoDB){
            this.locationsDaoDB = locationsDaoDB;
        }

        @Override
        protected Void doInBackground(LocationsDB... locationsDBS) {
            locationsDaoDB.delete(locationsDBS[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<LocationsDB, Void ,Void>{

        public LocationsDaoDB locationsDaoDB;
        public UpdateAsyncTask(LocationsDaoDB locationsDaoDB){
            this.locationsDaoDB = locationsDaoDB;
        }

        @Override
        protected Void doInBackground(LocationsDB... locationsDBS) {
            locationsDaoDB.update(locationsDBS[0]);
            return null;
        }
    }

    private static class DeleteAllLocationsAsyncTask extends AsyncTask<Void, Void ,Void>{

        public LocationsDaoDB locationsDaoDB;
        public DeleteAllLocationsAsyncTask(LocationsDaoDB locationsDaoDB){
            this.locationsDaoDB = locationsDaoDB;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            locationsDaoDB.deleteALLUsers();
            return null;
        }
    }


}
