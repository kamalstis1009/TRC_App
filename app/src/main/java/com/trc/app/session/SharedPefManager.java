package com.trc.app.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.trc.app.models.User;

public class SharedPefManager {

    private Context mContext;
    private static SharedPefManager mManager;

    private SharedPefManager(Context context) {
        mContext = context;
    }

    public static SharedPefManager getInstance(Context context) {
        if (mManager == null) {
            mManager = new SharedPefManager(context);
        }
        return mManager;
    }

    private static final String SHARED_PREF_NAME = "shared_preferences";

    //===============================================| Token
    public void saveDeviceToken(String token){
        SharedPreferences ref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putString("TOKEN_KEY", token);
        editor.apply();
    }
    public String getDeviceToken(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString("TOKEN_KEY", null);
    }

    //===============================================| User
    public void saveUser(User model){
        SharedPreferences pref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("UserModel", new Gson().toJson(model));
        editor.apply();
        editor.commit(); //for old version
    }
    public User getUser(){
        SharedPreferences pref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Gson().fromJson(pref.getString("UserModel", null), User.class);
    }

    //===============================================| Access/Permission
    /*public void savePermission(ArrayList<Access> mArrayList){
        SharedPreferences pref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("AccessModel", new Gson().toJson(mArrayList));
        editor.apply();
        editor.commit(); //for old version
    }
    public ArrayList<String> getPermission(){
        SharedPreferences ref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        ArrayList<Access> list = new Gson().fromJson(ref.getString("AccessModel", null), new TypeToken<ArrayList<Access>>(){}.getType());
        ArrayList<String> permissions = new ArrayList<>();
        if (list != null) {
            for (Access model : list) { permissions.add(model.getAccessType()); }
        }
        return permissions;
    }*/

    //===============================================| Login Screen
    public void setSignIn(boolean isSignIn) {
        SharedPreferences pref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("IS_SING_IN", isSignIn);
        editor.apply();
        editor.commit(); //for old version
    }

    public boolean isSignIn() {
        SharedPreferences pref = mContext.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return pref.getBoolean("IS_SING_IN", false);
    }

}
