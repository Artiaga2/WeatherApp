package com.example.a2_daw.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ToggleButton;

public class SetupActivity extends AppCompatActivity {

    private static final String TAG = SetupActivity.class.getName();

    ToggleButton unitsToggleButton;
    EditText locationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        unitsToggleButton = findViewById(R.id.units_toggle_button);
        locationEditText = findViewById(R.id.location_edit_text);

        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );
        String unit = prefs.getString("UNITS", "no_unit");

        if( unit.equals("metric") ){
            unitsToggleButton.setText("Metric");
            unitsToggleButton.setChecked(true);
        }else{
            unitsToggleButton.setText("Imperial");
            unitsToggleButton.setChecked(false);
        }

        String location = prefs.getString("LOCATION", "No Location");
        locationEditText.setText(location);

        showToolbar("Preferences", true);
    }

    private void showToolbar(String title, boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void saveUnits(String unit) {
        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );

        SharedPreferences.Editor editorPrefs = prefs.edit();

        editorPrefs.putString("UNITS", unit);
        editorPrefs.commit();
    }

    private void saveLocation(String location) {
        SharedPreferences prefs = getSharedPreferences(
                "data",
                Context.MODE_PRIVATE
        );

        SharedPreferences.Editor editorPrefs = prefs.edit();

        editorPrefs.putString("LOCATION", location);
        editorPrefs.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        String unit = unitsToggleButton.getText().toString().toLowerCase();
        String location = locationEditText.getText().toString();

        saveUnits(unit);
        saveLocation(location);
    }


}
