package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Web_Defects_Lobby extends AppCompatActivity {


    TableLayout tableLayout;
    int defectCounter;
    List<String> defect1 = new ArrayList<String>();
    List<String> defect2 = new ArrayList<String>();
    List<String> defect3 = new ArrayList<String>();

    List<List<String>> defectList = new ArrayList<List<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__defects__lobby);

        tableLayout = (TableLayout)findViewById(R.id.tableLayout_p46);

        defect1.add("1");
        defect1.add("Section Loss");


        defect2.add("2");
        defect2.add("Hole");


        defect3.add("3");
        defect3.add("Hole");

        defectList.add(defect1);
        defectList.add(defect2);
        defectList.add(defect3);


        defectCounter = 0;

        loadDefects();
    }

    private void loadDefects() {
        for (int index = 0; index < defectList.size(); index++){
            addDefectRow(defectList.get(index));
        }
    }

    private void addDefectRow(List<String> defects) {
        View row = getLayoutInflater().inflate(R.layout.table_web_defects_row, null, false);

        TextView defectId = (TextView)row.findViewById(R.id.idRow_p46);
        TextView defectType = (TextView)row.findViewById(R.id.errorTypeRow_p46);
        Button editDefect = (Button)row.findViewById(R.id.row_editDefect_p46);
        Button deleteDefect  = (Button)row.findViewById(R.id.row_editDelete_p46);

        defectId.setText(defects.get(0));
        defectType.setText(defects.get(1));

        editDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDefect(v);
            }
        });

        deleteDefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDefect(v);
            }
        });

        tableLayout.addView(row);
        defectCounter ++;
    }

    public void editDefect(View view) {
        Intent intent = new Intent(this, Web_Defects_Form.class);
        startActivity(intent);
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, Web_Defects_Form.class);
        startActivity(intent);
    }

    public void deleteDefect(View view) {
        tableLayout.removeView(view);
        defectCounter--;
    }

    public void submit(View view) {
        Intent intent = new Intent(this, GirderContent.class);
        startActivity(intent);
    }
}