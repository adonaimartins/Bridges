package com.example.bridges.repositories;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.example.bridges.Model.Bridges;
import com.example.bridges.dao.BridgesDao;
import com.example.bridges.database.BridgesDatabase;
import com.example.bridges.database.DatabaseContract;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BridgesRepository {

    private BridgesDao bridgesDao;
    private LiveData<List<Bridges>> allBridges;

    public BridgesRepository(Application application){
        BridgesDatabase bridgesDatabase = BridgesDatabase.getInstance(application.getApplicationContext());
        bridgesDao = bridgesDatabase.bridgesDao();
        allBridges = bridgesDao.getAllBridges();
        //System.out.println("Arriba");
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
    public Bridges selectBrigeById(int id) {
        BridgeByIdAsyncTask asyncTask = new BridgeByIdAsyncTask(bridgesDao, id);
        try {
            asyncTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //bridgesDao.getBrigeById(id);
        Bridges bridge  = asyncTask.getBridge();

        System.out.println("Adonai " + "Arriba " + bridge +  "  " + id);
        return bridge;

        /*
        final Bridges[] bridge = new Bridges[1];
        new Thread(new Runnable() {
            @Override
            public void run() {
                bridge[0] = bridgesDao.getBrigeById(id);
                System.out.println("Adonai " + " repository" + bridge[0] +  "  " + id);

            }
        }).start();

        System.out.println("AFTER THREAD");

        return bridge[0];*/
    }
/*
    public LiveData<List<Bridges>> getAllBridges() {
        BridgeGetAllAsyncTask asyncTask = new BridgeGetAllAsyncTask();
        asyncTask.execute();
        return asyncTask.getAllBridges();
    }*/

    public LiveData<List<Bridges>> getAllBridges() {
       // System.out.println("aqui" + allBridges.getValue());
        //System.out.println("Abajo");

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
                case DatabaseContract.GET_ALL:
                    bridgesDao.getAllBridges();
                    break;
            }
            return null;
        }
    }

    private static class BridgeByIdAsyncTask extends AsyncTask<Bridges, Void, Void> {
        private BridgesDao bridgesDao;
        private int id;
        private Bridges bridge;

        public BridgeByIdAsyncTask(BridgesDao bridgesDao, int id){
            this.bridgesDao = bridgesDao;
            this.id = id;
            //System.out.println("Adonai " + "Constructor " + bridge +  "  " + id + " "+ bridge);

        }

        public Bridges getBridge(){
            return bridge;
        }

        @Override
        protected Void doInBackground(Bridges... voids) {
            bridge = bridgesDao.getBrigeById(id);
            System.out.println("Adonai " + "Method " + bridge +  "  " + id + " "+ bridge.getSurveyor_name());
            return null;
        }
    }
/*
    private static class BridgeGetAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private BridgesDao bridgesDao;
        LiveData<List<Bridges>> bridges;

        public LiveData<List<Bridges>> getAllBridges(){
            return bridges;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bridges = bridgesDao.getAllBridges();
            return null;
        }
    }*/
}
