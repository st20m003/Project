package com.example.project.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.project.AccelerationInformation;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class UserDao {

    @Query("SELECT * FROM acceleration WHERE x=:x")
    public abstract LiveData<List<AccelerationInformation>> getX(float x);

    @Query("SELECT * FROM acceleration WHERE y=:y")
    public abstract LiveData<List<AccelerationInformation>> getY(float y);

    @Query("SELECT * FROM acceleration WHERE z=:z")
    public abstract LiveData<List<AccelerationInformation>> getZ(float z);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insert(AccelerationInformation accelerationInformation);
}
