package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.Webs;

import java.util.List;

@Dao
public interface WebsDao {

    @Insert
    void insert(Webs web);

    @Update
    void update(Webs web);

    @Delete
    void delete(Webs web);

    @Query("DELETE FROM Webs WHERE girder_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Webs WHERE girder_id = :parentKey ORDER BY web_id DESC")
    LiveData<List<Webs>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Webs ORDER BY web_id DESC")
    LiveData<List<Webs>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Webs")
    void deleteAll();


}
