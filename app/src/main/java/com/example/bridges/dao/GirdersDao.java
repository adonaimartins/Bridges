package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.Girders;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface GirdersDao {


    @Insert
    void insert(Girders girders);

    @Update
    void update(Girders girders);

    @Delete
    void delete(Girders girders);

    @Query("DELETE FROM Girders WHERE deck_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Girders WHERE deck_id = :parentKey ORDER BY girder_id DESC")
    ListenableFuture<List<Girders>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Girders ORDER BY girder_id DESC")
    LiveData<List<Girders>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Girders")
    void deleteAll();

    @Query("SELECT * FROM Girders WHERE girder_id =:id")
    ListenableFuture<Girders> getGirdersById(int id);

}
