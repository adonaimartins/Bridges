package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.CP_Rivets;

import java.util.List;

@Dao
public interface CP_RivetsDao {


    @Insert
    void insert(CP_Rivets cp_Rivet);

    @Update
    void update(CP_Rivets cp_Rivet);

    @Delete
    void delete(CP_Rivets cp_Rivet);

    @Query("DELETE FROM CP_Rivets WHERE cp_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM CP_Rivets WHERE cp_id = :parentKey ORDER BY rivet_id DESC")
    LiveData<List<CP_Rivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM CP_Rivets ORDER BY rivet_id DESC")
    LiveData<List<CP_Rivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM CP_Rivets")
    void deleteAll();
}
