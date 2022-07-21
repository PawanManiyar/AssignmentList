package com.pawanmaniyar.android.assignmentlist.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pawanmaniyar.android.assignmentlist.data.Root;
import com.pawanmaniyar.android.assignmentlist.repository.RootRepository;

import java.util.List;

public class RootViewModel extends AndroidViewModel {

    private RootRepository rootRepository;
    private LiveData<List<Root>> rootLiveData;

    public RootViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        rootRepository = new RootRepository();
        rootLiveData = rootRepository.getRootLiveData();
    }

    public void searchRoot(String query, String page, String sortOrder) {
        rootRepository.rootData(query, page, sortOrder);
    }

    public LiveData<List<Root>> getRootLiveData() {
        return rootLiveData;
    }
}
