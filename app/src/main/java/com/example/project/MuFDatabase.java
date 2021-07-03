package com.example.project;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project.dao.UserDao;

@Database(entities = {AccelerationInformation.class}, version = 1)
public abstract class MuFDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
