package com.jezhou.soapboxvronly;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.google.unity.GoogleUnityActivity;

import java.io.File;

public class MainActivity extends Activity {

    String recordingFolder = "recordingSoapBox";
    String externalPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    File f = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = new File(externalPath, recordingFolder);
        if(!f.exists()){
            f.mkdirs();
        }

        Button recordingButton = (Button) findViewById(R.id.recording_button);
        recordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecordingActivity();
            }
        });

        Button soapboxButton = (Button) findViewById(R.id.soapbox_button);
        soapboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSoapboxActivity();
            }
        });


    }

    /** Called when the user touches the Recordings button */
    public void startRecordingActivity() {
        Intent intent = new Intent(this, RecordingsActivity.class);
        startActivity(intent);
    }

    public void startSoapboxActivity() {
        Intent intent = new Intent(this, GoogleUnityActivity.class);
        startActivity(intent);
    }

}
