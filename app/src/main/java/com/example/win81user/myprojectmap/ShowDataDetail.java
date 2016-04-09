package com.example.win81user.myprojectmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Win81 User on 6/4/2559.
 */
public class ShowDataDetail extends Activity {

    @Bind(R.id.tvid) TextView tvid;
    @Bind(R.id.tvname) TextView tvname;
    @Bind(R.id.tvusername) TextView tvusername;
    @Bind(R.id.tvemail) TextView tvemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdatadetail);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        tvid.setText(String.valueOf(intent.getIntExtra(ShowDataListView.id, 0)));
        tvname.setText(intent.getStringExtra(ShowDataListView.name));
        tvusername.setText(intent.getStringExtra(ShowDataListView.username));
        tvemail.setText(intent.getStringExtra(ShowDataListView.email));


    }
}
