package com.trc.app.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.trc.app.models.User;
import com.trc.app.repositories.UserRepository;

import java.util.ArrayList;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = UserRepository.getInstance(application);
    }

    public LiveData<User> getUserByUserNameAndPass(String userName, String password) {
        return mRepository.getUserByUserNameAndPass(userName, password);
    }

    public LiveData<ArrayList<User>> getAllAccessByUserId(String userId, String token) {
        return mRepository.getAllAccessByUserId(userId, token);
    }

    public LiveData<User> addUser(User model) {
        return mRepository.addUser(model);
    }
}
