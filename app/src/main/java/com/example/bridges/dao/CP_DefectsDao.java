package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.CP_Defects;

import java.util.List;

@Dao
public interface CP_DefectsDao {

    @Insert
    void insert(CP_Defects cp_Defect);

    @Update
    void update(CP_Defects cp_Defect);

    @Delete
    void delete(CP_Defects cp_Defect);

    @Query("DELETE FROM CP_Defects WHERE cp_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM CP_Defects WHERE cp_id = :parentKey ORDER BY defect_id DESC")
    LiveData<List<CP_Defects>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM CP_Defects ORDER BY defect_id DESC")
    LiveData<List<CP_Defects>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM CP_Defects")
    void deleteAll();

}
