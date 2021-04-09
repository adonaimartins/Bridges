package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.InflateException;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Angle_Defects_Lobby extends AppCompatActivity {


    List<String> error1 = new ArrayList<String>();
    List<String> error2 = new ArrayList<String>();
    List<String> error3 = new ArrayList<String>();
    List<String> error4 = new ArrayList<String>();

    List<List<String>> flangeErrors = new ArrayList<List<String>>();

    TableLayout angleDefectsTable;

    int errorCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angle__defects__lobby);

        angleDefectsTable = findViewById(R.id.angleDefects_p2);

        error1.add("1");
        error1.add("Section Loss");
        error2.add("2");
        error2.add("Hole");
        error3.add("3");
        error3.add("Notch");

        flangeErrors.add(error1);
        flangeErrors.add(error2);
        flangeErrors.add(error3);

        errorCounter = 0;
        loadDefects();
    }

    public void submit(View view) {
        Intent intent = new Intent(this, Angle_Lobby.class);
        startActivity(intent);
    }

    public void deleteDefect(View view) {
        angleDefectsTable.removeView(view);
    }

    public void addDefect(View view) {
        Intent intent = new Intent(this, Angle_Defects_Form.class );
        startActivity(intent);
        errorCounter--;
    }

    public void editDefect(View view) {
        Intent intent = new Intent(this, Angle_Defects_Form.class );
        startActivity(intent);
    }

    private void loadDefects(){
        for(int index=0; index < flangeErrors.size(); index++){
            addDefectToRow(flangeErrors.get(index) );
        }
    }
    private void addDefectToRow(List<String> errorData){

        View angleDefectRow = getLayoutInflater().inflate(R.layout.table_angle_defect_row, null, false);
        TextView angleId = (TextView)angleDefectRow.findViewById(R.id.idRow1_p2);
        TextView angleError = (TextView)angleDefectRow.findViewById(R.id.errorTypeRow1_p2);
        Button angleDelete = (Button)angleDefectRow.findViewById(R.id.row_delete_defect_p2);
        Button angleEdit = (Button)angleDefectRow.findViewById(R.id.row_edit_defect_p2);

        angleId.setText(errorData.get(0));
        angleError.setText(errorData.get(1));

        angleDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDefect(angleDefectRow);
            }
        });

        angleEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDefect(v);
            }
        });
        angleDefectsTable.addView(angleDefectRow);
        errorCounter++;
    }
}