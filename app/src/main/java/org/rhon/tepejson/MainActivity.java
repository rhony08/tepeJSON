package org.rhon.tepejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "6706161078 - Rhony";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadJSON loadJSON = new LoadJSON(this);
        Log.d(TAG, loadJSON.loadJSONFromAsset("likes/count"));

        Log.d(TAG, loadJSON.loadJSONFromAsset("filter"));

        Log.d(TAG, loadJSON.loadJSONFromAsset("images/thumbnail/url"));

        Log.d(TAG, loadJSON.loadJSONFromAsset("user/username"));
    }
}
