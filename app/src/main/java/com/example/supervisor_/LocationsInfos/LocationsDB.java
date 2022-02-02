package com.example.supervisor_.LocationsInfos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Locations")
public class LocationsDB {

    @PrimaryKey(autoGenerate = true)
    private int idLocation;

    private String NameLocation;
    private String Classification ;


    public LocationsDB(String NameLocation ,String Classification) {
        this.NameLocation = NameLocation;
        this.Classification = Classification;
    }

    public String getNameLocation() {
        return NameLocation;
    }

    public String getClassification() {
        return Classification;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }
}
