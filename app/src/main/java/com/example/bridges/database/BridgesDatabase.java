package com.example.bridges.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bridges.Model.Angles;
import com.example.bridges.Model.AnglesDefects;
import com.example.bridges.Model.AnglesRivets;
import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.BackToBackL_Angles;
import com.example.bridges.Model.BackToBackL_AnglesRivets;
import com.example.bridges.Model.BackToBackL_AnglesRivetsDefects;
import com.example.bridges.Model.Bays;
import com.example.bridges.Model.Bridges;
import com.example.bridges.Model.CP_Defects;
import com.example.bridges.Model.CP_Rivets;
import com.example.bridges.Model.CP_RivetsDefects;
import com.example.bridges.Model.CPs;
import com.example.bridges.Model.Decks;
import com.example.bridges.Model.FlangeDefects;
import com.example.bridges.Model.Flanges;
import com.example.bridges.Model.FlangesRivets;
import com.example.bridges.Model.FlangesRivetsDefects;
import com.example.bridges.Model.Girders;
import com.example.bridges.Model.GussetPlates;
import com.example.bridges.Model.GussetPlatesRivets;
import com.example.bridges.Model.GussetPlatesRivetsDefects;
import com.example.bridges.Model.L_Angles;
import com.example.bridges.Model.L_AnglesRivets;
import com.example.bridges.Model.L_AnglesRivetsDefects;
import com.example.bridges.Model.Stiffener;
import com.example.bridges.Model.StiffenerDefects;
import com.example.bridges.Model.StiffenerRivets;
import com.example.bridges.Model.StiffenerRivetsDefects;
import com.example.bridges.Model.T_Angles;
import com.example.bridges.Model.T_AnglesRivets;
import com.example.bridges.Model.T_AnglesRivetsDefects;
import com.example.bridges.Model.WebDefects;
import com.example.bridges.Model.Webs;
import com.example.bridges.dao.AnglesDao;
import com.example.bridges.dao.AnglesDefectsDao;
import com.example.bridges.dao.AnglesRivetsDao;
import com.example.bridges.dao.AnglesRivetsDefectsDao;
import com.example.bridges.dao.BackToBackL_AnglesDao;
import com.example.bridges.dao.BackToBackL_AnglesRivetsDao;
import com.example.bridges.dao.BackToBackL_AnglesRivetsDefectsDao;
import com.example.bridges.dao.BaysDao;
import com.example.bridges.dao.BridgesDao;
import com.example.bridges.dao.CP_DefectsDao;
import com.example.bridges.dao.CP_RivetsDao;
import com.example.bridges.dao.CP_RivetsDefectsDao;
import com.example.bridges.dao.CPsDao;
import com.example.bridges.dao.DecksDao;
import com.example.bridges.dao.FlangeDefectsDao;
import com.example.bridges.dao.FlangesDao;
import com.example.bridges.dao.FlangesRivetsDao;
import com.example.bridges.dao.FlangesRivetsDefectsDao;
import com.example.bridges.dao.GirdersDao;
import com.example.bridges.dao.GussetPlatesDao;
import com.example.bridges.dao.GussetPlatesRivetsDao;
import com.example.bridges.dao.GussetPlatesRivetsDefectsDao;
import com.example.bridges.dao.L_AnglesDao;
import com.example.bridges.dao.L_AnglesRivetsDao;
import com.example.bridges.dao.L_AnglesRivetsDefectsDao;
import com.example.bridges.dao.StiffenerDao;
import com.example.bridges.dao.StiffenerDefectsDao;
import com.example.bridges.dao.StiffenerRivetsDao;
import com.example.bridges.dao.StiffenerRivetsDefectsDao;
import com.example.bridges.dao.T_AnglesDao;
import com.example.bridges.dao.T_AnglesRivetsDao;
import com.example.bridges.dao.T_AnglesRivetsDefectsDao;
import com.example.bridges.dao.WebDefectsDao;
import com.example.bridges.dao.WebsDao;

@Database(entities = {
        Bridges.class,
        Decks.class,
        Girders.class,
        Bays.class,
        Stiffener.class,
        L_Angles.class,
        L_AnglesRivets.class,
        L_AnglesRivetsDefects.class,
        T_Angles.class,
        T_AnglesRivets.class,
        T_AnglesRivetsDefects.class,
        BackToBackL_Angles.class,
        BackToBackL_AnglesRivets.class,
        BackToBackL_AnglesRivetsDefects.class,
        GussetPlates.class,
        GussetPlatesRivets.class,
        GussetPlatesRivetsDefects.class,
        StiffenerRivets.class,
        StiffenerRivetsDefects.class,
        StiffenerDefects.class,
        Webs.class,
        WebDefects.class,
        Angles.class,
        AnglesRivets.class,
        AnglesRivetsDefects.class,
        AnglesDefects.class,
        CPs.class,
        CP_Rivets.class,
        CP_RivetsDefects.class,
        CP_Defects.class,
        Flanges.class,
        FlangesRivets.class,
        FlangesRivetsDefects.class,
        FlangeDefects.class

}, version = 1,  exportSchema = true)
public abstract class BridgesDatabase extends RoomDatabase {


    private static BridgesDatabase instance;

    public abstract BridgesDao bridgesDao();
    public abstract DecksDao decksDao();
    public abstract GirdersDao girdersDao();
    public abstract BaysDao baysDao();
    public abstract StiffenerDao stiffenerDao();
    public abstract L_AnglesDao l_AnglesDao();
    public abstract L_AnglesRivetsDao l_AnglesRivetsDao();
    public abstract L_AnglesRivetsDefectsDao l_AnglesRivetsDefectsDao();
    public abstract T_AnglesDao t_AnglesDao();
    public abstract T_AnglesRivetsDao t_AnglesRivetsDao();
    public abstract T_AnglesRivetsDefectsDao t_AnglesRivetsDefectsDao();
    public abstract BackToBackL_AnglesDao backToBackL_AnglesDao();
    public abstract BackToBackL_AnglesRivetsDao backToBackL_AnglesRivetsDao();
    public abstract BackToBackL_AnglesRivetsDefectsDao backToBackL_AnglesRivetsDefectsDao();
    public abstract GussetPlatesDao gussetPlatesDao();
    public abstract GussetPlatesRivetsDao gussetPlatesRivetsDao();
    public abstract GussetPlatesRivetsDefectsDao gussetPlatesRivetsDefectsDao();
    public abstract StiffenerRivetsDao stiffenerRivetsDao();
    public abstract StiffenerRivetsDefectsDao stiffenerRivetsDefectsDao();
    public abstract StiffenerDefectsDao stiffenerDefectsDao();
    public abstract WebsDao websDao();
    public abstract WebDefectsDao webDefectsDao();
    public abstract AnglesDao anglesDao();
    public abstract AnglesRivetsDao anglesRivetsDao();
    public abstract AnglesRivetsDefectsDao anglesRivetsDefectsDao();
    public abstract AnglesDefectsDao anglesDefectsDao();
    public abstract CPsDao cpsDao();
    public abstract CP_RivetsDao cp_RivetsDao();
    public abstract CP_RivetsDefectsDao cp_RivetsDefectsDao();
    public abstract CP_DefectsDao cp_DefectsDao();
    public abstract FlangesDao flangesDao();
    public abstract FlangesRivetsDao flangesRivetsDao();
    public abstract FlangesRivetsDefectsDao flangesRivetsDefectsDao();
    public abstract FlangeDefectsDao flangeDefectsDao();

    public static synchronized  BridgesDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), BridgesDatabase.class, "Bridges_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
