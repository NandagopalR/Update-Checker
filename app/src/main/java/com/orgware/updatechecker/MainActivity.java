package com.orgware.updatechecker;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.orgware.updatechecker.utils.UpdateRunnable;

public class MainActivity extends AppCompatActivity {

    String current_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            current_version = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e("Version", "" + current_version);

//        new UpdateRunnable(this, new Handler()).start();
        new UpdateRunnable(this, new Handler()).force(true).start();

    }
}
