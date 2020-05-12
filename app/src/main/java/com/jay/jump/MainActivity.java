package com.jay.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Entry> mData = new ArrayList<>();
    private Timer mTimer;
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLineChart = findViewById(R.id.mLineChart);
        ChartHelper.initChart(mData,mLineChart,100);
    }

    public void star(View view) {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ChartHelper.addEntry(mData,mLineChart,ChartHelper.getRandom(80f));
            }
        },0,1000);
    }

    public void pause(View view) {
        mTimer.cancel();
    }
}
