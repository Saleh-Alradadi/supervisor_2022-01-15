package com.example.supervisor_;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = UsersDB.class , version = 1)
public abstract class UsersRoomDB extends RoomDatabase {
    private static UsersRoomDB instance;

    public abstract UsersDBdao usersDBdao();

    //Singleton
    public static  synchronized UsersRoomDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UsersRoomDB.class,"Users--dataBase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return  instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PobulateDataAsyncTask(instance).execute();

        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

        }
    };

    private static class PobulateDataAsyncTask extends AsyncTask<Void , Void , Void>{

        private UsersDBdao mUsersDBdao;

        PobulateDataAsyncTask(UsersRoomDB db){
            mUsersDBdao = db.usersDBdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mUsersDBdao.insert(new UsersDB("khaled", "OS5000" , "12" ,"monday","SS@S.com"));
            mUsersDBdao.insert(new UsersDB("Ali", "OS5000" , "10" ,"FriDay","SS@S.com"));
            mUsersDBdao.insert(new UsersDB("Ahmed", "OS5020" , "11" ,"sunday","SS@S.com"));
            return null;
        }
    }

}
