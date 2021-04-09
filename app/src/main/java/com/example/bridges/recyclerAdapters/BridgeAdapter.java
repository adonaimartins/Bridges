package com.example.bridges.recyclerAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bridges.Model.Bridges;
import com.example.bridges.R;

import java.util.ArrayList;

public class BridgeRecyclerAdapter extends RecyclerView.Adapter<BridgeRecyclerAdapter.MyViewHolder> {

    private ArrayList<Bridges> bridgesList;
   // private RecyclerViewClickListener listener;

    //CONSTRUCTOR


    public BridgeRecyclerAdapter(ArrayList<Bridges> bridgesList) {
        this.bridgesList = bridgesList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView row_bridgeId;
        private TextView row_bridge_name;
        private TextView row_bridge_location;
        private TextView row_bridge_number;
        private Button row_editBridge;
        private Button row_deleteBridge;


        public MyViewHolder(final View itemView) {
            super(itemView);

            row_bridgeId = itemView.findViewById(R.id.row_bridgeId);
            row_bridge_name = itemView.findViewById(R.id.row_bridge_name);
            row_bridge_location = itemView.findViewById(R.id.row_bridge_location);
            row_bridge_number = itemView.findViewById(R.id.row_bridge_number);
            row_editBridge = itemView.findViewById(R.id.row_editBridge);
            row_deleteBridge = itemView.findViewById(R.id.row_deleteBridge);

            /*
            row_editBridge.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    editBridge();
                }
            });

            row_deleteBridge.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    deleteRow(itemView);
                }
            });*/
        }
    }

    //OVERRIDE METHODS
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_bridge_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int bridgeId = bridgesList.get(position).getBridge_id();
        String bridge_name = bridgesList.get(position).getSurveyor_name();
        String bridge_location = bridgesList.get(position).getStructure_location();
        String bridge_number = bridgesList.get(position).getStructure_number();

        holder.row_bridgeId.setText(bridgeId);
        holder.row_bridge_name.setText(bridgeId);
        holder.row_bridge_location.setText(bridgeId);
        holder.row_bridge_number.setText(bridgeId);
    }

    @Override
    public int getItemCount() {
        return bridgesList.size();
    }

/*
    ////edit and delete methods
    private void editBridge() {
        Intent intent = new Intent(this, Bridge_Form.class);
        startActivity(intent);
    }

    private void deleteRow(View view) {
        table.removeView(view);
    }
*/

}
