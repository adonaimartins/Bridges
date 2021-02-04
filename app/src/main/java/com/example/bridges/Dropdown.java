package com.example.bridges;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Dropdown {

    private final String UNSELECTEDMESSAGE;
    private String selectedItem;

    public Dropdown(String unselectedMessage) {
        this.UNSELECTEDMESSAGE = unselectedMessage;
    }

    public void addSpinnerValues(View spinnerView, ArrayAdapter spinnerListItems){


            Spinner dropDown_elevation = (Spinner) spinnerView;//spinerID

            spinnerListItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dropDown_elevation.setAdapter(spinnerListItems);
            dropDown_elevation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                             @Override
                                                             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                                 selectedItem = parent.getItemAtPosition(position).toString().trim();

                                                                 if(parent.getItemAtPosition(position).equals(UNSELECTEDMESSAGE)){

                                                                 }else{
                                                                     String text = parent.getItemAtPosition(position).toString();
                                                                     Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                                                                 }
                                                             }

                                                             @Override
                                                             public void onNothingSelected(AdapterView<?> parent) {

                                                             }
                                                         }
            );
        }

        public String getSelected(){
            return selectedItem;
        }
}
