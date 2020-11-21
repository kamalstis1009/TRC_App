package com.trc.app.utils;

import java.util.ArrayList;

public class ConstantKey {

    public static final String FIREBASE_SERVER_KEY = "AAAAASaR7OU:APA91bEpZlL6R_27zbW0DjbkmBI6Q43_S66MHVgHpl5XWgRDcpew-SrJHrtxJ6Bx5evnsE8zUahZC8in1IhjGofC0dxMaE7L78kGyoG3S43V2EIerwTCXQL81v1ulOoxX_jqVE1bA7R0";
    public static final String FIREBASE_BASE_URL = "https://fcm.googleapis.com/";
    public static final String SERVER_URL = "http://192.168.0.18:8080/"; //https://localhost:44379/ OR IPv4 192.168.0.105 OR https://docs.microsoft.com/en-us/xamarin/cross-platform/deploy-test/connect-to-local-web-services
    public static final String IMAGE_SERVER_URL = SERVER_URL + "api/file/Download?filePath=";

    public static ArrayList<String> getDivisions() {
        ArrayList<String> mArrayList = new ArrayList<>();
        mArrayList.add("Barisal");
        mArrayList.add("Chittagong");
        mArrayList.add("Dhaka");
        mArrayList.add("Khulna");
        mArrayList.add("Mymensingh");
        mArrayList.add("Rangpur");
        mArrayList.add("Rajshahi");
        mArrayList.add("Sylhet");
        return mArrayList;
    }
}
