package com.example.bridges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.example.bridges.viewModel.BridgesViewModel;

import java.util.List;

public class Bridge_Form extends AppCompatActivity {

    public static String EXTRA_ID = BuildConfig.APPLICATION_ID.concat("EXTRA_ID");
    public static String EXTRA_SURVEYOR_NAME = BuildConfig.APPLICATION_ID.concat("EXTRA_SURVEYOR_NAME");
    public static String EXTRA_SURVEYOR_LASTNAME = BuildConfig.APPLICATION_ID.concat("EXTRA_SURVEYOR_LASTNAME");
    public static String EXTRA_STRUCTURE_NAME = BuildConfig.APPLICATION_ID.concat("EXTRA_STRUCTURE_NAME");
    public static String EXTRA_STRUCTURE_LOCATION = BuildConfig.APPLICATION_ID.concat("EXTRA_STRUCTURE_LOCATION");
    public static String EXTRA_STRUCTURE_NUMBER = BuildConfig.APPLICATION_ID.concat("EXTRA_STRUCTURE_NUMBER");
    public static String MILEAGEMILES = BuildConfig.APPLICATION_ID.concat("MILEAGEMILES");
    public static String MILEAGEYARDS = BuildConfig.APPLICATION_ID.concat("MILEAGEYARDS");
    //public static String SYNC_STATUS = BuildConfig.APPLICATION_ID.concat("SYNC_STATUS");

    TextView title_bridge_p11;

    EditText input_surveior_name_p11;
    EditText input_surveior_lastName_p11;
    EditText input_structureName_p11;
    EditText input_structureLocation_p11;
    EditText input_structureNumber_p11;
    EditText input_mileage_miles_p11;
    EditText input_mileage_yards_p11;

    Bridges bridge;
   // Button buttonNext_p11;
   BridgesViewModel bridgesViewModel; //this is for the database
    Intent intentBridgesLobby;
    private int bridgeId;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge_form);

        intentBridgesLobby = getIntent();
        bridgesViewModel = ViewModelProviders.of(this).get(BridgesViewModel.class);

        title_bridge_p11 = (TextView) findViewById(R.id.title_bridge_p11);

        bridgeId = intentBridgesLobby.getIntExtra(EXTRA_ID, 1);

        input_surveior_name_p11 = (EditText) findViewById(R.id.input_surveior_name_p11);
        input_surveior_lastName_p11 = (EditText) findViewById(R.id.input_surveior_lastName_p11);
        input_structureName_p11 = (EditText) findViewById(R.id.input_structureName_p11);
        input_structureLocation_p11 = (EditText) findViewById(R.id.input_structureLocation_p11);
        input_structureNumber_p11 = (EditText) findViewById(R.id.input_structureNumber_p11);
        input_mileage_miles_p11 = (EditText) findViewById(R.id.input_mileage_miles_p11);
        input_mileage_yards_p11 = (EditText) findViewById(R.id.input_mileage_yards_p11);

        if (intentBridgesLobby.hasExtra(EXTRA_ID)){
            setTitle("Edit Bridge");

            //BridgesViewModel bridgesViewModel = ViewModelProviders.of(this).get(BridgesViewModel.class);

            bridge = bridgesViewModel.getBridgeByID(bridgeId);

            input_surveior_name_p11.setText(bridge.getSurveyor_name());
            input_surveior_lastName_p11.setText(bridge.getSurveyor_lastName());
            input_structureName_p11.setText(bridge.getStructure_name());
            input_structureLocation_p11.setText(bridge.getStructure_location());
            input_structureNumber_p11.setText(bridge.getStructure_number());
            input_mileage_miles_p11.setText(Integer.toString(bridge.getMileageMiles()) );
            input_mileage_yards_p11.setText(Integer.toString(bridge.getMileageYards()));
        }else{
            setTitle("Add Bridge");
        }
    }

    public void launchDeckLobby(View view) {
        Intent intent = new Intent(this, Decks_Lobby.class);
        saveToLocalDatabase();
        startActivity(intent);
    }

    public void launchBridgesLobby(View view) {
        Intent intent = new Intent(this, Bridges_Lobby.class);
        saveToLocalDatabase();
        startActivity(intent);
    }

    private void saveToLocalDatabase(){
        String surveior_name_p11 = input_surveior_name_p11.getText().toString();
        String surveior_lastName_p11 = input_surveior_lastName_p11.getText().toString();
        String structureName_p11 = input_structureName_p11.getText().toString();
        String structureLocation_p11 = input_structureLocation_p11.getText().toString();
        String structureNumber_p11 = input_structureNumber_p11.getText().toString();
        int mileage_miles_p11 = Integer.parseInt(input_mileage_miles_p11.getText().toString());
        int mileage_yards_p11 = Integer.parseInt(input_mileage_yards_p11.getText().toString());

        Bridges bridge = new Bridges(
                surveior_name_p11,
                surveior_lastName_p11,
                structureName_p11,
                structureLocation_p11,
                structureNumber_p11,
                mileage_miles_p11,
                mileage_yards_p11,
                DatabaseContract.SYNC_STATUS_FAILED);


        if (intentBridgesLobby.hasExtra(EXTRA_ID)) {
            System.out.println("ARRIBA SENT BACK");
            bridge.setBridge_id(bridgeId);
            bridgesViewModel.update(bridge);
        }else{
            System.out.println("ABAJO SENT BACK");

            bridgesViewModel.insert(bridge);
        }
    }
}