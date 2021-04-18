package com.example.bridges.httpRequests;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bridges.Model.Bridges;
import com.example.bridges.database.DatabaseContract;
import com.example.bridges.viewModel.BridgesViewModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequest {



    public void syncSQLiteMySQLDB(Context context, BridgesViewModel bridgesViewModel, ProgressDialog prgDialog){
        //Create AsycHttpClient object

        List<Bridges> allNonSyncBridges = bridgesViewModel.getAllNonSyncBridges();
        //System.out.println(" TEST ADONAI" + bridgesViewModel.getAllNonSyncBridges().size());

        if(allNonSyncBridges.size()!=0){
                prgDialog.show();

            if(checkNetworkConnection(context)) { //if there is interenet, we send a response with data to the server
                System.out.println(" TEST ADONAI internet");
                ///how it should be

                RequestQueue requestQueue;
                    StringRequest stringRequest = new StringRequest
                            (Request.Method.POST, DatabaseContract.SERVER_URL, new Response.Listener<String>() { //this is an interface that receives 2 interfaces
                                @Override
                                public void onResponse(String response) { //here we handle the response

                                    prgDialog.hide();
                                    try {

                                        System.out.println("SUCCESS RESPONSE TEST ADONAI" + response);

                                        JSONObject jsonObject = new JSONObject(response);
                                        System.out.println("SUCCESS RESPONSE TEST ADONAI");

                                        String thisResponse = jsonObject.getString("status");
                                        if(thisResponse.equals("OK")){ //we send a request to the php URL. if the response is OK. we save to local database with status OK, otherwise we save with Failed
                                            for (int i = 0; i < allNonSyncBridges.size(); i++) { //loop through array
                                                Bridges bridge = allNonSyncBridges.get(i);  // we store the actual object
                                                bridge.setSync_status(DatabaseContract.SYNC_STATUS_OK);
                                                bridgesViewModel.update(bridge);
                                                System.out.println(bridge.getBridge_id());
                                                System.out.println(bridge.getSync_status());
                                            }
                                            prgDialog.hide();
                                            Toast.makeText(context, "DB Sync completed!", Toast.LENGTH_LONG).show();
                                        }else{
                                            prgDialog.hide();
                                            Toast.makeText(context, "There is no internet, Try another time", Toast.LENGTH_LONG).show();
                                        }
                                    }catch(JSONException e){
                                        prgDialog.hide();
                                        Toast.makeText(context, "catch error ADONAI", Toast.LENGTH_LONG).show();

                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) { //if we receive an error trying to connect to the server
                                    prgDialog.hide();
                                    System.out.println("ERROR COMING" + error);
                                    //end of test
                                    Toast.makeText(context, "Something went wrong at server end", Toast.LENGTH_LONG).show();
                                }
                            }
                            ){//here is where we override the methods
                        ///this is the request body (similar to AJAX); //this method has the request data we are sending to the php URL
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            Gson gson = new Gson();
                            String json = gson.toJson(allNonSyncBridges);
                           // System.out.println(json + "Adonai");
                            params.put("allNonSyncBridges", json);   //here we send the request as name we can add more data here to be sent in the request so the php script saves it in the database
                            System.out.println("REQUEST BODY TEST ADONAI");
                            return  params;
                        }
                    };
                     Volley.newRequestQueue(context).add(stringRequest); //execute send request
                }else{
                    System.out.println("NO ONTERNET TEST ADONAI");
                    prgDialog.hide();
                    Toast.makeText(context, "There is no internet, Try another time", Toast.LENGTH_LONG).show();
                }
        }
    }
    //////METHOD NEEDED TO CHECK IF THERE IS INTERNET CONNECTION
    public boolean checkNetworkConnection(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null && networkInfo.isConnected());
    }


}
