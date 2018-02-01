package kp.project.mesoshqip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity{
    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setProgress(0);

        final long period = 100;
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //this repeats every 100 ms
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    progressBar.setProgress(i);
                    i+=2;
                }else{
                    //closing the timer
                    timer.cancel();
                    Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    // close this activity
                    finish();
                }
            }
        }, 0, period);
    }

}
