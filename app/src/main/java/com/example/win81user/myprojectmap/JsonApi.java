package com.example.win81user.myprojectmap;

/**
 * Created by Win81 User on 6/4/2559.
 */

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface JsonApi {
    @GET("/RetrofitExample/show.php")
    public void GetData(Callback<List<JsonData>> response);

}
