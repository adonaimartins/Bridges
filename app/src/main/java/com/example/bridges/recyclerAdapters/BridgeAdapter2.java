package com.example.bridges.recyclerAdapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bridges.Model.Bridges;
import com.example.bridges.R;
import com.example.bridges.database.DatabaseContract;

import java.util.List;

public class BridgeAdapter2 extends RecyclerView.Adapter<BridgeAdapter2.BridgeViewHolder> {


    private List<Bridges> bridgesList;
    private BridgeAdapter2.OnItemClickListener deleteOnClickListener;
    private BridgeAdapter2.OnItemClickListener editOnClickListener;

/*
    /// Constructor
    public RecyclerAdapter(ArrayList<User> userList, RecyclerViewClickListener listener){ //we create a constructor that takes an array list of the itmes to populate the list
        this.userList = userList;
        this.listener = listener;
    }*/

    /// Constructor
    public BridgeAdapter2(){ //we create a constructor that takes an array list of the itmes to populate the list
    }
    /// Constructor
    public BridgeAdapter2(List<Bridges> bridgesList){ //we create a constructor that takes an array list of the itmes to populate the list
        this.bridgesList = bridgesList;
    }
    public void setBridgesList(List<Bridges> bridgesList) {
        this.bridgesList = bridgesList;
    }

    ///override methods
    @NonNull
    @Override
    public BridgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //System.out.println(" CALL ON CREATE ADONAI");
        return new BridgeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_bridge_row, parent, false)); //we return inner class. we pass the layout container.
    }


    @Override
    public void onBindViewHolder(@NonNull BridgeViewHolder holder, int position) {
        //System.out.println(" CALL ON CREATE ADONAI");
        Bridges bridge = bridgesList.get(position);
        holder.row_bridgeId.setText(Integer.toString(bridge.getBridge_id()));
        holder.row_bridge_name.setText(bridge.getStructure_name());
        holder.row_bridge_location.setText(bridge.getStructure_location());
        holder.row_bridge_number.setText(bridge.getStructure_number());

        ////here we change the image to each ViewHolder
        if(bridge.getSync_status() == DatabaseContract.SYNC_STATUS_OK){
            holder.sync_Status.setImageResource(R.drawable.ok);
        }else{
            holder.sync_Status.setImageResource(R.drawable.sync);
        }
    }

    @Override
    public int getItemCount() {
        return bridgesList.size();
    }


    class BridgeViewHolder extends RecyclerView.ViewHolder {
        private TextView row_bridgeId;
        private TextView row_bridge_name;
        private TextView row_bridge_location;
        private TextView row_bridge_number;
        private Button row_editBridge;
        private Button row_deleteBridge;
        private ImageView sync_Status;

        public BridgeViewHolder(@NonNull View itemView) {
            super(itemView);
            row_bridgeId = itemView.findViewById(R.id.row_bridgeId);
            row_bridge_name = itemView.findViewById(R.id.row_bridge_name);
            row_bridge_location = itemView.findViewById(R.id.row_bridge_location);
            row_bridge_number = itemView.findViewById(R.id.row_bridge_number);
            row_editBridge = itemView.findViewById(R.id.row_editBridge);
            row_deleteBridge = itemView.findViewById(R.id.row_deleteBridge);
            sync_Status = itemView.findViewById(R.id.imageSync);


            row_editBridge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (editOnClickListener != null && position != RecyclerView.NO_POSITION ){
                        editOnClickListener.onItemClickListener(bridgesList.get(position));
                    }
                }
            });

            row_deleteBridge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Log.d("Aqui el peo", "PEO");
                    if(deleteOnClickListener != null && position != RecyclerView.NO_POSITION){
                        deleteOnClickListener.onItemClickListener(bridgesList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener { //on the other sheet we will only have the Model object
        void onItemClickListener(Bridges bridge);
    }

    public void setDeleteOnClickListener(BridgeAdapter2.OnItemClickListener onClickListener){
        this.deleteOnClickListener = onClickListener;
    }

    public void setEditOnClickListener(BridgeAdapter2.OnItemClickListener onClickListener){
        this.editOnClickListener = onClickListener;
    }

}
