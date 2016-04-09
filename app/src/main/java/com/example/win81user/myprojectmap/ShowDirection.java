package com.example.win81user.myprojectmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ShowDirection extends Activity {
    @Bind(R.id.btn_simple)
    Button btnsimple;
    @OnClick(R.id.btn_simple) void showdirection(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdirection);
        ButterKnife.bind(this);
    }
}
