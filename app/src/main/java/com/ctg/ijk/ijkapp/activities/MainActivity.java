package com.ctg.ijk.ijkapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.ctg.ijk.ijkapp.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void IjkVideo(View view) {
//        Intent intent = new Intent(this, VideoActivity.class);
//        startActivity(intent);
        EditText editText = (EditText) findViewById(R.id.editText_uri);
        String[] str = editText.getText().toString().trim().equals("") ? null : editText.getText().toString().split(";");
        String uri = str != null && str.length > 0 ? str[0] : "1";
        int startTime = str != null && str.length > 1 ? Integer.parseInt(str[1]) : 0;

        if ("1".equals(uri)) {
            uri = "http://192.168.6.74:8888/video/Adele.mp4";
        } else if ("2".equals(uri)) {
            uri = "http://192.168.6.74:8888/dash.mp4";
        } else if ("3".equals(uri)) {
            uri = "http://59.120.43.180:17355";
        }

        Bundle bundle = new Bundle();
        bundle.putString("videoPath", uri);
        bundle.putString("videoTitle", "video");
        bundle.putInt("startTime", startTime);

//        VideoActivity.intentTo(this, uri, "Video");
        VideoActivity.intentTo(this, bundle);
    }
}
