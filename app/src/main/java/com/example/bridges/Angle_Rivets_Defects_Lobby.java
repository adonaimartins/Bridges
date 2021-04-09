package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Angle_Rivets_Defects_Lobby extends AppCompatActivity {

    TableLayout rivetDefectTable;
    List<String> rivetDefect1 = new ArrayList<String>();
    List<String> rivetDefect2 = new ArrayList<String>();

    List<List<String>> rivetsDefects = new ArrayList<List<String>>();
    int rivetsDefectsCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__rivets__defects__lobby);

        rivetDefectTable = (TableLayout)findViewById(R.id.angleRivetsDefectsTable_p6);

        rivetDefect1.add("1");
        rivetDefect1.add("Section Loss");
        rivetDefect1.add("4");
        rivetDefect1.add("10");

        rivetDefect2.add("2");
        rivetDefect2.add("Missing Rivets");
        rivetDefect2.add("10");
        rivetDefect2.add("true");


        rivetsDefects.add(rivetDefect1);
        rivetsDefects.add(rivetDefect2);

        rivetsDefectsCounter = 0;

        loadRivetsDefects();
    }

    private void loadRivetsDefects() {
        for (int index = 0; index < rivetsDefects.size(); index++){
            addDefectRow(rivetsDefects.get(index));
        }
    }

    private void addDefectRow(List<String> defects) {
        View row = getLayoutInflater().inflate(R.layout.table_angle_rivets_defect_row, null, false);

        TextView girderId = (TextView)row.findViewById(R.id.idRow_p6);
        TextView errorType = (TextView)row.findViewById(R.id.errorTypeRow1_p6);
        TextView numberAffected = (TextView)row.findViewById(R.id.no_affected_p6);
        TextView percentageLoss = (TextView)row.findViewById(R.id.percent_loss_p6);
        Button editDefect = (Button)row.findViewById(R.id.row_editDefect_p6);
        Button deleteDefect  = (Button)row.findViewById(R.id.row_editDelete_p6);

        girderId.setText(defects.get(0));
        errorType.setText(defects.get(1));
        numberAffected.setText(defects.get(2));
        percentageLoss.setText(defects.get(3));

        editDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDefect(row);
            }
        });
        deleteDefect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                deleteDefect(row);
            }
        });
        rivetDefectTable.addView(row);
        rivetsDefectsCounter++;
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, Angle_Rivets_Defects_Form.class);
        startActivity(intent);
    }

    public void deleteDefect(View view) {
        rivetDefectTable.removeView(view);
        rivetsDefectsCounter--;
    }
    public void editDefect(View view) {
        Intent intent = new Intent(this, Angle_Rivets_Defects_Form.class);
        startActivity(intent);
    }
    public void submit(View view) {
        Intent intent = new Intent(this, Angle_Lobby.class);
        startActivity(intent);
    }
}