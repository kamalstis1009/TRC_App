package com.trc.app.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.trc.app.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "Repository";

    private static UserRepository mInstance;
    private Context mContext;

    //Singleton design pattern
    public static UserRepository getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserRepository(context);
        }
        return mInstance;
    }
    public UserRepository(Context context) {
        mContext = context;
    }

    //===============================================| Get
    public MutableLiveData<User> getUserByUserNameAndPass(String userName, String password) {
        MutableLiveData<User> data = new MutableLiveData<>();
        Call<User> call = RetrofitClient.getInstance().getApi().getUserByUserNameAndPass(userName, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }

    public MutableLiveData<ArrayList<User>> getAllAccessByUserId(String userId, String token) {
        MutableLiveData<ArrayList<User>> data = new MutableLiveData<>();
        Call<ArrayList<User>> call = RetrofitClient.getInstance().getApi().GetAllAccessByUserId(userId, "Bearer " + token);
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<User>> call, @NonNull Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<User>> call, @NonNull Throwable t) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }

    //===============================================| Store
    public MutableLiveData<User> addUser(User model) {
        MutableLiveData<User> data = new MutableLiveData<>();
        Call<User> call = RetrofitClient.getInstance().getApi().addUser(model);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        data.setValue(response.body());
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(mContext, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }

    //===============================================| Update

}
