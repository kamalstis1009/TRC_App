package com.trc.app.repositories;

import com.trc.app.models.User;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("/")
    public ResponseBody getAll();

    //======================================================| User
    //@GET("api/user/GetUserByUserNameAndPass")
    //Call<User> getUserByUserNameAndPass(@Query("userName") String userName, @Query("password") String password);

    @GET("api/user/GetUserByUserNameAndPass")
    Call<User> getUserByUserNameAndPass(@Query("userName") String userName, @Query("password") String password);

    @GET("api/access/GetAllAccessByUserId")
    Call<ArrayList<User>> GetAllAccessByUserId(@Query("userId") String userId, @Header("Authorization") String token);

    @Headers("Content-Type: application/json")
    @POST("api/user/AddUser")
    Call<User> addUser(@Body User model);

    //======================================================| File Upload & Download
    @Multipart
    @POST("api/file/UploadFile")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file, @Query("fileName") String fileName);


}
