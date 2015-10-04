package com.jezhou.soapboxvronly;

import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class RecordingsActivity extends Activity {

    boolean recording = false;
    SoapboxRecorder recorder = null;
    ArrayAdapter<File> adapter = null;
    File[] files = null;
    File f = null;

    String recordingFolder = "recordingSoapBox";
    String externalPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordings);

        // Populate the listView
        f = new File(externalPath, recordingFolder);
        files = f.listFiles();
        adapter = new ArrayAdapter<File>(this, android.R.layout.simple_list_item_1, files);

        final ListView recordingList = (ListView) findViewById(R.id.recordingList);
        recordingList.setAdapter(adapter);
        recordingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // do something
            }
        });
    }

}
