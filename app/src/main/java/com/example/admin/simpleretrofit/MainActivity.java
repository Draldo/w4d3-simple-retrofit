package com.example.admin.simpleretrofit;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.simpleretrofit.entities.Student;
import com.example.admin.simpleretrofit.network.NamesInterface;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mArray;
    private ArrayList<String> mImages;
    private simpleAdapter mAdapter;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //4. Instantiating the interface via the Retrofit object
        NamesInterface namesInterface = retrofit.create(NamesInterface.class);

        //5. Setting up the method to be called from the intervace
        Call<ArrayList<Student>> studentCall = namesInterface.retrieveStudentsImages();

        mArray = new ArrayList<String>();
        mImages = new ArrayList<String>();
        try {
            //6.Executing the Retrofit call
            ArrayList<Student> students = studentCall.execute().body();
            for (Student student :
                    students) {
                mArray.add(student.getName());
                mImages.add(student.getImage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mAdapter = new simpleAdapter(getApplicationContext(),mArray, mImages);

        mRecycler = (RecyclerView) findViewById(R.id.a_main_recycler);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
