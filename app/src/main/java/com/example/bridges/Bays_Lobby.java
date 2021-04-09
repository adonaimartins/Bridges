package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Bays_Lobby extends AppCompatActivity {

    TableRow stiffenerRow;
    TableRow bays_row;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_bays_lobby);

        stiffenerRow = (TableRow)findViewById(R.id.stiffener_row);
        bays_row = (TableRow)findViewById(R.id.bays_row);

        loadStiffeners();
    }

    public void launchStiffenerForm(View view) {
        //need to get the id here to add
        Intent intent = new Intent(this, Stiffener_Form.class);
        startActivity(intent);
    }

    public void submit(View view) {

        Intent intent = new Intent(this, GirderContent.class);

        startActivity(intent);
    }

    private void addStiffener(int index){
        TextView stiffener = new TextView(this);

        int width1 = (int) CalculationsUtility.convertPixelsToDp(18, this);
        int topBottom = (int) CalculationsUtility.convertPixelsToDp(20, this);

        stiffener.setText(Integer.toString(index));
        stiffener.setPadding(width1,topBottom,topBottom,0);
        stiffener.setTextColor(Color.rgb(63,81,181));
        stiffener.setGravity(Gravity.CENTER);

        TableRow.LayoutParams layout = new TableRow.LayoutParams();
        stiffener.setLayoutParams(layout); //here the index of the stiffener
        layout.column = index;
        layout.weight = 1;

        stiffener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchStiffenerForm(v);
            }
        });

        stiffenerRow.addView(stiffener);
    }

    private void addBay(int index){
        TextView bay = new TextView(this);

        int padding = (int) CalculationsUtility.convertPixelsToDp(18, this);
        int topBottom = (int) CalculationsUtility.convertPixelsToDp(20, this);
        int marginWidth = (int) CalculationsUtility.convertPixelsToDp(2, this);

        bay.setText(Integer.toString(index));
        bay.setPadding(padding,padding,padding,padding);
        bay.setTextColor(Color.rgb(233,30,99));
        bay.setBackgroundColor(Color.rgb(255,255,255));
        bay.setGravity(Gravity.CENTER);

        TableRow.LayoutParams layout = new TableRow.LayoutParams();
        layout.setMargins(marginWidth,0,1,0);
        bay.setLayoutParams(layout);

        bays_row.addView(bay);
    }



    private void loadStiffeners(){
        for(int index=0; index<30; index++ ){
            addStiffener(index);
            if(index !=0){
                addBay(index);
            }
        }
    }
}