package com.example.supervisor_;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = LocationsDB.class , version = 1, exportSchema = false)
public abstract class LocationsRoomDB extends RoomDatabase {

    private static LocationsRoomDB instance;

    public abstract LocationsDaoDB mlocationsDaoDB();

    //Singleton
    public static  synchronized LocationsRoomDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocationsRoomDB.class,"Locationsٌ--dataBase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return  instance;
    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new LocationsRoomDB.PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

        }
    };

    private static class PopulateDataAsyncTask extends AsyncTask<Void , Void , Void> {

        private final LocationsDaoDB mLocationsDaoDB;

        PopulateDataAsyncTask(LocationsRoomDB db){
            mLocationsDaoDB = db.mlocationsDaoDB();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mLocationsDaoDB.insert(new LocationsDB("alhilton" , "A"));
            mLocationsDaoDB.insert(new LocationsDB("dar alaiman", "B"));
            mLocationsDaoDB.insert(new LocationsDB("almahkkamh", "C"));
            return null;
        }
    }

}

