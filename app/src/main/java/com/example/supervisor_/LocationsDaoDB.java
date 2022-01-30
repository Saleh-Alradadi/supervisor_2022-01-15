package com.example.supervisor_;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LocationsDaoDB {

    @Insert
    void insert (LocationsDB locations);

    @Update
    void update (LocationsDB locations);

    @Delete
    void delete (LocationsDB locations);

    @Query("DELETE FROM Locations")
    void deleteALLUsers();

    @Query("SELECT * FROM Locations")
    LiveData<List<LocationsDB>> getAllLocations();
}
