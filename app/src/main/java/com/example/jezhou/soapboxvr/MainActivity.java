package com.example.jezhou.soapboxvr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button recordingButton = (Button) findViewById(R.id.recording_button);
        recordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecordingActivity();
            }
        });

        Button audienceButton = (Button) findViewById(R.id.audience_button);
        audienceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startAudienceActivity();
            }
        });

        Button settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startSettingsActivity();
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

    /** Called when the user touches the Recordings button */
    public void startRecordingActivity() {
        Intent intent = new Intent(this, Recordings.class);
        startActivity(intent);
    }

    /** Called when the user touches the Audience button */
    public void startAudienceActivity() {
        Intent intent = new Intent(this, Audience.class);
        startActivity(intent);
    }

    /** Called when the user touches the Settings button */
    public void startSettingsActivity() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
