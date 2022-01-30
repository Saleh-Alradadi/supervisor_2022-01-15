package com.example.supervisor_;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UsersRepository {
    private UsersDBdao mUsersDBad;
    private LiveData<List<UsersDB>> getAllUsers;

    public UsersRepository(Application app){
        UsersRoomDB db = UsersRoomDB.getInstance(app);
        mUsersDBad = db.usersDBdao();
        getAllUsers = mUsersDBad.getALLUsers();
    }

    //operation


    //insert
    public void insert(UsersDB usersDB){
    new InsertAsyncTask(mUsersDBad).execute(usersDB);
    }

    //delete
    public void delete(UsersDB usersDB){
        new DeleteAsyncTask(mUsersDBad).execute(usersDB);

    }

    //update
    public void update(UsersDB usersDB){
        new UpdateAsyncTask(mUsersDBad).execute(usersDB);
    }

    //getAllUsers
    public LiveData<List<UsersDB>> getAllUsers(){

        return getAllUsers;
    }

    //deleteAllUsers
    public void deleteAllUsers(){
        new DeleteAllUsersAsyncTask(mUsersDBad).execute();
    }

    private static class InsertAsyncTask extends AsyncTask<UsersDB, Void ,Void>{
        public UsersDBdao mUsersDBdao;
        public InsertAsyncTask(UsersDBdao usersDBdao){
            mUsersDBdao = usersDBdao;
        }

        @Override
        protected Void doInBackground(UsersDB... usersDBS) {
            mUsersDBdao.insert(usersDBS[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<UsersDB, Void ,Void>{

        public UsersDBdao mUsersDBdao;
        public DeleteAsyncTask(UsersDBdao usersDBdao){
            mUsersDBdao = usersDBdao;
        }

        @Override
        protected Void doInBackground(UsersDB... usersDBS) {
            mUsersDBdao.delete(usersDBS[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<UsersDB, Void ,Void>{

        public UsersDBdao mUsersDBdao;
        public UpdateAsyncTask(UsersDBdao usersDBdao){
            mUsersDBdao = usersDBdao;
        }

        @Override
        protected Void doInBackground(UsersDB... usersDBS) {
            mUsersDBdao.update(usersDBS[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void ,Void>{

        public UsersDBdao mUsersDBdao;
        public DeleteAllUsersAsyncTask(UsersDBdao usersDBdao){
            mUsersDBdao = usersDBdao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mUsersDBdao.deleteALLUsers();
            return null;
        }
    }

}
