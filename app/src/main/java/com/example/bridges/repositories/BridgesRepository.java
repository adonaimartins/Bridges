package com.example.bridges.repositories;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.bridges.Model.Bridges;
import com.example.bridges.dao.BridgesDao;
import com.example.bridges.database.BridgesDatabase;
import com.example.bridges.database.DatabaseContract;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BridgesRepository {

    private BridgesDao bridgesDao;
    private LiveData<List<Bridges>> allBridges;

    public BridgesRepository(Application application){
        BridgesDatabase bridgesDatabase = BridgesDatabase.getInstance(application.getApplicationContext());
        bridgesDao = bridgesDatabase.bridgesDao();
        allBridges = bridgesDao.getAllBridges();
    }

    public void insert(Bridges bridge) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                bridgesDao.insert(bridge);
            }
        }).start();

       // new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.INSERT).execute(bridge);
    }
    public void update(Bridges bridge) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                bridgesDao.update(bridge);
            }
        }).start();

       // new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.UPDATE).execute(bridge);
    }
    public void delete(Bridges bridge) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                bridgesDao.delete(bridge);
            }
        }).start();
        //new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.DELETE).execute(bridge);
    }
    public void deleteAllBridges() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                bridgesDao.deleteAllBridges();
            }
        }).start();
        //new BridgeOpeationAsyncTask(bridgesDao, DatabaseContract.DELETE_ALL).execute((Bridges)null);
    }
    public Bridges selectBrigeById(int id) {
        Bridges bridge = null;
        try {
            bridge = bridgesDao.getBridgeById(id).get(); //get to wait
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bridge;
    }


    public List<Bridges> getAllNonSyncBridges(){
        List<Bridges> allNonSyncBridges = new ArrayList<Bridges>();
        try {
            allNonSyncBridges.addAll(bridgesDao.getAllNonSyncBridges().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  allNonSyncBridges;
    }

    public LiveData<List<Bridges>> getAllBridges() {
        return allBridges;
    }





    /*
    private static class BridgeOpeationAsyncTask extends AsyncTask<Bridges, Void, Void> {
        private BridgesDao bridgesDao;
        private int type;
        private static List<Bridges> allNonSyncBridges;

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

        public List<Bridges> getAllNonSyncBridges(){
            return allNonSyncBridges;
        }
    }*/
}
