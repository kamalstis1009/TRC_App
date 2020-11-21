package com.trc.app.utils;

import com.trc.app.R;
import com.trc.app.models.Category;

import java.util.ArrayList;

public class ConstantKey {

    public static final String FIREBASE_SERVER_KEY = "AAAAASaR7OU:APA91bEpZlL6R_27zbW0DjbkmBI6Q43_S66MHVgHpl5XWgRDcpew-SrJHrtxJ6Bx5evnsE8zUahZC8in1IhjGofC0dxMaE7L78kGyoG3S43V2EIerwTCXQL81v1ulOoxX_jqVE1bA7R0";
    public static final String FIREBASE_BASE_URL = "https://fcm.googleapis.com/";
    public static final String SERVER_URL = "http://192.168.0.18:8080/"; //https://localhost:44379/ OR IPv4 192.168.0.105 OR https://docs.microsoft.com/en-us/xamarin/cross-platform/deploy-test/connect-to-local-web-services
    public static final String IMAGE_SERVER_URL = SERVER_URL + "api/file/Download?filePath=";

    public static ArrayList<Category> getDivisions() {
        ArrayList<Category> mArrayList = new ArrayList<>();
        mArrayList.add(new Category(1, "About", R.drawable.ic_baseline_error_outline_24));
        mArrayList.add(new Category(2, "Vat/Tax Guidelines", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(3, "Consultants", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(4, "Application Form", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(5, "Vat Calculation", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(6, "Tax Calculation", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(7, "Offers", R.drawable.ic_baseline_person_24));
        mArrayList.add(new Category(8, "Extra", R.drawable.ic_baseline_person_24));
        return mArrayList;
    }
}
