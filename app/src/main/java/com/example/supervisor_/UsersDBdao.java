package com.example.supervisor_;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsersDBdao {
    @Insert
    void insert (UsersDB user);

    @Update
    void update (UsersDB user);

    @Delete
    void delete (UsersDB user);


    @Query("DELETE From UsersTable")
    void deleteALLUsers();

    @Query("SELECT * From UsersTable")
    LiveData<List<UsersDB>> getALLUsers();
}
