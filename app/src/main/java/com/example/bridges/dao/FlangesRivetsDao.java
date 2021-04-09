package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bridges.Model.FlangesRivets;

import java.util.List;

@Dao
public interface FlangesRivetsDao {

    @Insert
    void insert(FlangesRivets flangesRivets);

    @Update
    void update(FlangesRivets flangesRivets);

    @Delete
    void delete(FlangesRivets flangesRivets);

    @Query("DELETE FROM FlangesRivets WHERE flange_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM FlangesRivets WHERE flange_id = :parentKey ORDER BY rivet_id DESC")
    LiveData<List<FlangesRivets>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM FlangesRivets ORDER BY rivet_id DESC")
    LiveData<List<FlangesRivets>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM FlangesRivets")
    void deleteAll();

}
