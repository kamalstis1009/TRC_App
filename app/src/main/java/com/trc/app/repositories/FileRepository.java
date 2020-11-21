package com.trc.app.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileRepository {

    private static final String TAG = "Repository";

    private static FileRepository mInstance;

    public static FileRepository getInstance() {
        if (mInstance == null) {
            mInstance = new FileRepository();
        }
        return mInstance;
    }

    //===============================================| File Upload
    public MutableLiveData<String> uploadFile(MultipartBody.Part file, String fileName) {
        MutableLiveData<String> data = new MutableLiveData<>();
        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().uploadFile(file, fileName);
        //Call<ResponseBody> call = RetrofitClient.getInstance(ConstantKey.SERVER_URL).getApi().uploadFile(fileToUpload, file.getName());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        data.setValue(response.body().toString());
                    } else {
                        data.setValue(null);
                    }
                } else {
                    data.setValue(null);
                }
            }
            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.e(TAG, "Retrofit " + t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }

}
