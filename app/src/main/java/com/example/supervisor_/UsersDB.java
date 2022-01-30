package com.example.supervisor_;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UsersTable")
public class UsersDB {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String Namedb;
    private String Userdb;
    private String Salesdb;
    private String DayOffdb;
    private String Emaildb;


    public UsersDB(String Namedb, String Userdb, String Salesdb, String DayOffdb ,String Emaildb ) {
        this.Namedb = Namedb;
        this.Userdb = Userdb;
        this.Salesdb = Salesdb;
        this.DayOffdb = DayOffdb;
        this.Emaildb = Emaildb;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getNamedb() {
        return this.Namedb;
    }

    public String getUserdb() {
        return this.Userdb;
    }

    public String getSalesdb() {
        return this.Salesdb;
    }

    public String getDayOffdb() {
        return this.DayOffdb;
    }

    public String getEmaildb() {
        return this.Emaildb;
    }
}
