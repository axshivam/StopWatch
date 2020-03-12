package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Button btnStart,btnStop,btnReset;
    //TextView tvShow;
    private int seconds=0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnStart = (Button) findViewById(R.id.btnStart);
        //btnStop = (Button) findViewById(R.id.btnStop);
        //btnReset = (Button) findViewById(R.id.btnReset);
        //tvShow = (TextView) findViewById(R.id.tvShow);
        if(savedInstanceState!=null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTime();
    }

    //this method to save the values of variable when user rotates the his phone
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("running", running);
    }
    public void onClickStart(View view)
    {
        running=true;
    }

    public void onClickStop(View view)
    {
        running=false;
    }
    public void onClickReset(View view)
    {
        running=false;
        seconds=0;
    }

    private void runTime()
    {
        final TextView tvShow = (TextView)findViewById(R.id.tvShow);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs=seconds%60;

                String time= String.format("%d:%02d:%02d", hours,minutes,secs);

                tvShow.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}
