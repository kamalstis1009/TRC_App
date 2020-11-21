package com.trc.app.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.trc.app.repositories.FileRepository;

import okhttp3.MultipartBody;

public class FileViewModel extends ViewModel {

    private FileRepository mRepository;

    public FileViewModel() {
        this.mRepository = FileRepository.getInstance();
    }

    //-----------------------------------------------| File
    public LiveData<String> uploadFile(MultipartBody.Part file, String fileName) {
        return mRepository.uploadFile(file, fileName);
    }
}
