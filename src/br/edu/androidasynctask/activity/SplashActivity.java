package br.edu.androidasynctask.activity;

import br.edu.androidasynctask.R;
import br.edu.androidasynctask.asynctask.ServerStatus;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler SplashScreen = new Handler();
        SplashScreen.postDelayed(SplashActivity.this, 3000);
    }
    @Override
    public void run() {

        ServerStatus server = new ServerStatus(SplashActivity.this);
        server.execute();

    }
    
}
