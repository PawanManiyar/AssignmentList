package com.pawanmaniyar.android.assignmentlist.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pawanmaniyar.android.assignmentlist.api.RootService;
import com.pawanmaniyar.android.assignmentlist.data.Root;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RootRepository {

    private static final String BASE_URL = "https://api.thecatapi.com/";

    private RootService rootService;
    public MutableLiveData<List<Root>> rootMutableLiveData;

    public RootRepository() {
        rootMutableLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client =new OkHttpClient.Builder().addInterceptor(interceptor).build();

        rootService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RootService.class);
    }

    public void rootData(String limit, String page, String sortOrder) {
        rootService.getRoots(limit,page,sortOrder)
                .enqueue(new Callback<List<Root>>() {
                    @Override
                    public void onResponse(Call<List<Root>> call, Response<List<Root>> response) {
                        if(response.body() != null) {
                            rootMutableLiveData.postValue(response.body());
                            System.out.println("Data fetched");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Root>> call, Throwable t) {
                        rootMutableLiveData.postValue(null);
                        System.out.println("Error fetching data from api");
                    }
                });
    }

    public LiveData<List<Root>> getRootLiveData() {
        return rootMutableLiveData;
    }

}
