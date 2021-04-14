package com.example.bridges.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.bridges.Model.Bridges;
import com.example.bridges.repositories.BridgesRepository;
import java.util.List;

public class BridgesViewModel extends AndroidViewModel {

    private BridgesRepository repository;
    private LiveData<List<Bridges>> allBridges;

    public BridgesViewModel(@NonNull Application application) {
        super(application);
        repository = new BridgesRepository(application);
        allBridges = repository.getAllBridges();

    }

    public void insert(Bridges bridge){
        repository.insert(bridge);
    }

    public void update(Bridges bridge){
        repository.update(bridge);
    }

    public void delete(Bridges bridge){
        repository.delete(bridge);
    }

    public void deleteAllBridges(){
        repository.getAllBridges();
    }

    public LiveData<List<Bridges>> getAllBridges(){
        return allBridges;
    }

    public Bridges getBridgeByID(int id){
    Bridges bridge = repository.selectBrigeById(id);

        System.out.println("viewModel adonai " + bridge);

        return bridge;
    }
}
