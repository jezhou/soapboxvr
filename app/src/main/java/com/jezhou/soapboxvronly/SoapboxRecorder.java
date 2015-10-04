package com.jezhou.soapboxvronly;

import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by jezhou on 10/3/15.
 */
public class SoapboxRecorder {

    MediaRecorder recorder = null;
    String externalDirectory = Environment.getExternalStorageDirectory().getAbsolutePath();
    final String FILE_PREFIX = "speech";
    int count = (new File(externalDirectory, "recordingSoapBox")).list().length;

    public SoapboxRecorder() {
        if (isExternalStorageWritable()) {
            recorder = new MediaRecorder();
        }
    }

    public void prepare(){
        try {
            recorder.prepare();
        }
        catch(IOException e){
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }

    public void release(){
        recorder.release();
    }

    public void start(){
        recorder.start();
    }

    public void stop(){
        recorder.stop();
    }

    public void reset(){
        recorder.reset();
    }

    public void init(){
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setOutputFile(externalDirectory + "/recordingSoapBox/" + FILE_PREFIX + count++ + ".mp4");
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
        System.out.println("File # is: " + count);
        prepare();
    }

    private boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
