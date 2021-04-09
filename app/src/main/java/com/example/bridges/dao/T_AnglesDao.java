package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.T_Angles;

import java.util.List;

@Dao
public interface T_AnglesDao {

    @Insert
    void insert(T_Angles t_Angles);

    @Update
    void update(T_Angles t_Angles);

    @Delete
    void delete(T_Angles t_Angles);

    @Query("DELETE FROM T_Angles WHERE stiffener_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM T_Angles WHERE stiffener_id = :parentKey ORDER BY t_angle_id DESC")
    LiveData<List<T_Angles>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM T_Angles ORDER BY t_angle_id DESC")
    LiveData<List<T_Angles>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM T_Angles")
    void deleteAll();

}
