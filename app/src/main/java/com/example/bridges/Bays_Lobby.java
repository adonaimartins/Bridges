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

            //stiffener_row
            // bays_row

   // final float scale = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65, getResources().getDisplayMetrics());

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

    private void addBay(int index){

        int padding = (int) CalculationsUtility.convertPixelsToDp(18, this);
        int topBottom = (int) CalculationsUtility.convertPixelsToDp(20, this);
        int marginWidth = (int) CalculationsUtility.convertPixelsToDp(1, this);

        //stiffenerRow
        TextView bay = new TextView(this);

        bay.setText(Integer.toString(index));
        bay.setPadding(padding,padding,padding,padding);
        bay.setTextColor(Color.rgb(233,30,99));
        bay.setBackgroundColor(Color.rgb(255,255,255));
        bay.setGravity(Gravity.CENTER);

        TableRow.LayoutParams layout = new TableRow.LayoutParams();
        layout.setMargins(1,0,1,0);
        layout.weight = index;
        bay.setLayoutParams(layout);
/*
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
        layout.setMargins(1,0,1,0);*/
     //  bay.setLayoutParams(new ViewGroup.MarginLayoutParams(10,10)); //here the index of the stiffener
/*
                    android:layout_marginLeft="1dp"
                    android:layout_marginRight="1dp"
                    */
        bays_row.addView(bay);

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


/*                                <TextView
                    android:id="@+id/title_girders_p10"
                    android:layout_column="0"
                    android:layout_weight="1"
                    */

        stiffenerRow.addView(stiffener);
    }

    private void loadStiffeners(){
        for(int index=0; index<10; index++ ){
            addStiffener(index);
            if(index !=0){
                addBay(index);
            }
        }
    }
}