package com.pawanmaniyar.android.assignmentlist.api;

import com.pawanmaniyar.android.assignmentlist.data.Root;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RootService {
//?limit=100&page=10&order=Desc
    @GET("v1/images/search")
    Call<List<Root>> getRoots(
            @Query("limit") String limit,
            @Query("page") String page,
            @Query("order") String sortType
    );
}
