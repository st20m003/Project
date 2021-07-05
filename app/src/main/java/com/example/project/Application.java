package com.example.project;

import androidx.room.Room;

public class Application extends android.app.Application {

    private MuFDatabase muFDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        muFDatabase = Room
                .databaseBuilder(this, MuFDatabase.class, "data")
                .build();

    }
    public MuFDatabase getDatabase() {
        return muFDatabase;
    }
}
