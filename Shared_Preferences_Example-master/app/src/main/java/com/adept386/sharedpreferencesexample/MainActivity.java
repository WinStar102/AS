package com.adept386.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public static final String PREFS_NAME = "UserData";

    private TextView nameTextView;
    private TextView surnameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        surnameTextView = (TextView) findViewById(R.id.surnameTextView);
        Button changeButton = (Button) findViewById(R.id.changeButton);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivityIntent = new Intent(
                        MainActivity.this,
                        ChangeActivity.class
                );
                startActivity(changeActivityIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Restore preferences
        SharedPreferences userData = getSharedPreferences(PREFS_NAME, 0);
        nameTextView.setText(
                String.format("Name: %s", userData.getString(getString(R.string.pref_name), "Empty"))
        );
        surnameTextView.setText(
                String.format("Surname: %s", userData.getString(getString(R.string.pref_surname), "Empty"))
        );
    }
}
