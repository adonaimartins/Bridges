package com.example.bridges.recyclerAdapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bridges.Model.Bridges;
import com.example.bridges.R;

public class BridgeAdapter extends ListAdapter<Bridges, BridgeAdapter.BridgesViewHolder> {

   // private ArrayList<Bridges> bridgesList;
    private OnItemClickListener deleteOnClickListener;
    private OnItemClickListener editOnClickListener;

    public BridgeAdapter() {
        super(DIFF_CALLBACK);
    }


    ///here we compare list items and see whether they are the same or contents are the same
    //we compare wether IDs are the same
    //then, we compare whether contents are the same
    public static final DiffUtil.ItemCallback<Bridges> DIFF_CALLBACK = new DiffUtil.ItemCallback<Bridges>() {
        @Override
        public boolean areItemsTheSame(@NonNull Bridges oldItem, @NonNull Bridges newItem) {
            return oldItem.getBridge_id() == newItem.getBridge_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bridges oldItem, @NonNull Bridges newItem) {
            return
                    (oldItem.getBridge_id() == newItem.getBridge_id()) &&
                    (oldItem.getSurveyor_name().equals(newItem.getSurveyor_name())) &&
                    (oldItem.getSurveyor_lastName().equals(newItem.getSurveyor_lastName())) &&
                    (oldItem.getStructure_name().equals(newItem.getStructure_name())) &&
                    (oldItem.getStructure_location().equals(newItem.getStructure_location())) &&
                    (oldItem.getStructure_number().equals(newItem.getStructure_number())) &&
                    (oldItem.getMileageMiles() == newItem.getMileageMiles()) &&
                    (oldItem.getMileageYards() == newItem.getMileageYards());
        }
    };
    @NonNull
    @Override
    public BridgesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ERROR", " error CREATE");
        return new BridgesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_bridge_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BridgesViewHolder holder, int position) {
        Log.d("ERROR", " error BIND");
        Bridges bridge = getItem(position);
        holder.row_bridgeId.setText(Integer.toString(bridge.getBridge_id()));
        holder.row_bridge_name.setText(bridge.getStructure_name());
        holder.row_bridge_location.setText(bridge.getStructure_location());
        holder.row_bridge_number.setText(bridge.getStructure_number());
    }

    ///returns the Model Object from the list it was passed
    public Bridges getBridgesAt(int position) {
        return getItem(position);
    }
    class BridgesViewHolder extends RecyclerView.ViewHolder {
        private TextView row_bridgeId;
        private TextView row_bridge_name;
        private TextView row_bridge_location;
        private TextView row_bridge_number;
        private Button row_editBridge;
        private Button row_deleteBridge;

        public BridgesViewHolder(@NonNull View itemView) {
            super(itemView);
            row_bridgeId = itemView.findViewById(R.id.row_bridgeId);
            row_bridge_name = itemView.findViewById(R.id.row_bridge_name);
            row_bridge_location = itemView.findViewById(R.id.row_bridge_location);
            row_bridge_number = itemView.findViewById(R.id.row_bridge_number);
            row_editBridge = itemView.findViewById(R.id.row_editBridge);
            row_deleteBridge = itemView.findViewById(R.id.row_deleteBridge);

            row_editBridge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (editOnClickListener != null && position != RecyclerView.NO_POSITION ){
                        editOnClickListener.onItemClickListener(getItem(position));

                    }
                }
            });

            row_deleteBridge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(deleteOnClickListener != null && position != RecyclerView.NO_POSITION){
                        deleteOnClickListener.onItemClickListener(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener { //on the other sheet we will only have the Model object
        void onItemClickListener(Bridges bridge);
    }

    public void setDeleteOnClickListener(OnItemClickListener onClickListener){
        this.deleteOnClickListener = onClickListener;
    }

    public void setEditOnClickListener(OnItemClickListener onClickListener){
        this.editOnClickListener = onClickListener;
    }
}
