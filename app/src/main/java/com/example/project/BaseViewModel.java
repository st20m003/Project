package com.example.project;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public abstract class BaseViewModel extends AndroidViewModel {
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MuFDatabase getDatabase () {
        return ((MuFApplication)getApplication()).getDatabase();
    }
}
