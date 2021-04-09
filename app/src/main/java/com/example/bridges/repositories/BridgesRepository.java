package com.example.bridges.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.bridges.Model.Bridges;
import com.example.bridges.dao.BridgesDao;
import com.example.bridges.database.BridgesDatabase;
import com.example.bridges.database.DatabaseContract;

import java.util.List;

public class BridgesRepository {

    private BridgesDao bridgesDao;
    private LiveData<List<Bridges>> allBridges;

    public BridgesRepository(Application application){

        BridgesDatabase bridgesDatabase = BridgesDatabase.getInstance(application);
        bridgesDao = bridgesDatabase.bridgesDao();
        allBridges = bridgesDao.getAllBridges();
    }

    public void insert(Bridges bridge) {
        new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.INSERT).execute(bridge);
    }
    public void update(Bridges bridge) {
        new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.UPDATE).execute(bridge);
    }
    public void delete(Bridges bridge) {
        new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.DELETE).execute(bridge);
    }
    public void deleteAllBridges() {
        new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.DELETE_ALL).execute((Bridges)null);
    }

    public LiveData<List<Bridges>> getAllBridges() {
        return allBridges;
    }

    private static class BridgeOpeationAsyncTask extends AsyncTask<Bridges, Void, Void> {
        private BridgesDao bridgesDao;
        private int type;

        public BridgeOpeationAsyncTask(BridgesDao bridgesDao, int type){
            this.bridgesDao = bridgesDao;
            this.type = type;
        }

        @Override
        protected Void doInBackground(Bridges... bridges) {

            switch(type){
                case DatabaseContract.INSERT:
                    bridgesDao.insert(bridges[0]);
                    break;
                case DatabaseContract.UPDATE:
                    bridgesDao.update(bridges[0]);
                    break;
                case DatabaseContract.DELETE:
                    bridgesDao.delete(bridges[0]);
                    break;
                case DatabaseContract.DELETE_ALL:
                    bridgesDao.deleteAllBridges();
                    break;
            }
            return null;
        }
    }




}
