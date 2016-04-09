package com.example.win81user.myprojectmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Win81 User on 5/4/2559.
 */
public class Register extends Activity {
    @Bind(R.id.editTextName) EditText editTextName;
    @Bind(R.id.editTextUsername) EditText editTextUsername;
    @Bind(R.id.editTextPassword) EditText editTextPassword;
    @Bind(R.id.editTextEmail) EditText editTextEmail;
    @Bind(R.id.buttonRegister) Button buttonRegister;
    @OnClick(R.id.buttonRegister) void insert(){
        insertUser();
    }

    public static final String ROOT_URL = "http://192.168.56.1:8181";

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ButterKnife.bind(this);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
                // Snackbar.make(view, "Hi I'm Tom", Snackbar.LENGTH_LONG).setAction("Action", null).show();


            }
        });



    }

    private void insertUser() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter


        Registerapi api = adapter.create(Registerapi.class);
        api.insertUser(


                editTextName.getText().toString(),
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {

                        BufferedReader reader = null;

                        String output = "";

                        try {

                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                            output = reader.readLine();
                            Log.d("resultASync", result + "");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Toast.makeText(Register.this, output, Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(Register.this, error.toString(), Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

}
