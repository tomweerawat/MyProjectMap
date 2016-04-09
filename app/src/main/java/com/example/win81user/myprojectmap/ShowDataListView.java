package com.example.win81user.myprojectmap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Win81 User on 6/4/2559.
 */
public class ShowDataListView extends Activity {
    public static final String ROOT_URL = "http://192.168.56.1:8181";
    public static final String id = "id";
    public static final String name = "name";
    public static final String username = "username";
    public static final String email = "email";

    private ListView listView;


    private List<JsonData> jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdatalistview);
        listView =  (ListView) findViewById(R.id.listView);
        getdata();
    }
    private void getdata(){
        //final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();
        JsonApi jsonApi = adapter.create(JsonApi.class);
        jsonApi.GetData(new Callback<List<JsonData>>() {

            @Override
            public void success(List<JsonData> jsonDatas, Response response) {


                //loading.dismiss();
                jsonData = jsonDatas;
                Log.e("DeBUGGGGGGGGGGGGGg","TESTTTT"+jsonData+"");
                showdata();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    public void showdata(){
        String[] items = new String[jsonData.size()];

        for(int i = 0;i<jsonData.size();i++){
            items[i] = jsonData.get(i).getName();

        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.emptytv,items);
        listView.setAdapter(adapter);


    }

   /* public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Creating an intent
        Intent intent = new Intent(this, ShowDataDetail.class);

        //Getting the requested book from the list
        JsonData jsd = jsonData.get(position);

        //Adding book details to intent
        intent.putExtra(name,jsd.getName());
        intent.putExtra(username,jsd.getName());
        intent.putExtra(email,jsd.getEmail());

        //Starting another activity to show book details
        startActivity(intent);
    }*/
}
