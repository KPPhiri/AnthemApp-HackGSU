package com.example.philipphiri.hackgsuanthemapp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class TeamVitals_Activity extends AppCompatActivity {

    private HorizontalBarChart vitalsChart;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_vitals_);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vitalsChart = (HorizontalBarChart) findViewById(R.id.chart1);
        vitalsChart.setDrawBarShadow(false);
        vitalsChart.setDrawValueAboveBar(true);
        vitalsChart.getDescription().setEnabled(false);
        vitalsChart.setPinchZoom(false);
        vitalsChart.setDrawGridBackground(false);


        XAxis xl = vitalsChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        xl.setEnabled(false);
        xl.setGranularity(1);

        YAxis yl = vitalsChart.getAxisLeft();
        yl.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yl.setDrawAxisLine(false);
        yl.setDrawGridLines(false);
        yl.setEnabled(false);
        yl.setAxisMinimum(0f);

        YAxis yr = vitalsChart.getAxisRight();
        yr.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yr.setDrawGridLines(false);
        yr.setAxisMinimum(0f);

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        for (int i = 0; i < 5; i++) {
            yVals1.add(new BarEntry(i, (i + 1) * 20));
        }

        BarDataSet set1;
        set1 = new BarDataSet(yVals1, "DataSet 1");
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        data.setBarWidth(.4f);
        vitalsChart.setData(data);
        vitalsChart.getLegend().setEnabled(false);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTog.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}