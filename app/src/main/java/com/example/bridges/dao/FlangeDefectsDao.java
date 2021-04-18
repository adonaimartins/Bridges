package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.FlangeDefects;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface FlangeDefectsDao {

    @Insert
    void insert(FlangeDefects flangeDefects);

    @Update
    void update(FlangeDefects flangeDefects);

    @Delete
    void delete(FlangeDefects flangeDefects);

    @Query("DELETE FROM FlangeDefects WHERE flange_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM FlangeDefects WHERE flange_id = :parentKey ORDER BY defect_id DESC")
    ListenableFuture<List<FlangeDefects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM FlangeDefects ORDER BY defect_id DESC")
    LiveData<List<FlangeDefects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM FlangeDefects")
    void deleteAll();

    @Query("SELECT * FROM FlangeDefects WHERE defect_id =:id" )
    ListenableFuture<FlangeDefects> getFlangeDefectsById(int id);


}
