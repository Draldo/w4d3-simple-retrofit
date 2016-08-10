package com.example.admin.simpleretrofit.network;

import com.example.admin.simpleretrofit.entities.Student;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 8/10/2016.
 */
//Create Interface
public interface NamesInterface {

    @GET("/v2/57a4dfb40f0000821dc9a3b8")
    Call<ArrayList<Student>> retrieveStudents();
}
