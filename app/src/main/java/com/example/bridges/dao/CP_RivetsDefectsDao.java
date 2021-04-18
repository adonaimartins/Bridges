package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.CP_RivetsDefects;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface CP_RivetsDefectsDao {

    @Insert
    void insert(CP_RivetsDefects cp_RivetsDefects);

    @Update
    void update(CP_RivetsDefects cp_RivetsDefects);

    @Delete
    void delete(CP_RivetsDefects cp_RivetsDefects);

    @Query("DELETE FROM CP_RivetsDefects WHERE rivet_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM CP_RivetsDefects WHERE rivet_id = :parentKey ORDER BY defect_id DESC")
    ListenableFuture<List<CP_RivetsDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM CP_RivetsDefects ORDER BY defect_id DESC")
    LiveData<List<CP_RivetsDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM CP_RivetsDefects")
    void deleteAll();

    @Query("SELECT * FROM CP_RivetsDefects WHERE defect_id =:id" )
    ListenableFuture<CP_RivetsDefects> getCP_RivetsDefectsById(int id);

}
