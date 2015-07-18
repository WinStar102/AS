package com.adept386.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ChangeActivity extends ActionBarActivity {

    private EditText nameEditText;
    private EditText surnameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        Button saveChangesButton = (Button) findViewById(R.id.saveChangesButton);

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEditText.getText().length() == 0 && surnameEditText.getText().length() == 0) {
                    Toast.makeText(
                            ChangeActivity.this,
                            "Fields can't be empty!",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    SharedPreferences userData = getSharedPreferences(MainActivity.PREFS_NAME, 0);
                    SharedPreferences.Editor editor = userData.edit();
                    editor.putString(getString(R.string.pref_name), nameEditText.getText().toString());
                    editor.putString(getString(R.string.pref_surname), surnameEditText.getText().toString());
                    editor.apply();
                    ChangeActivity.this.finish();
                }
            }
        });
    }
}
