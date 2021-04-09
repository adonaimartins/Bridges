package com.example.bridges.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.L_Angles;

import java.util.List;

@Dao
public interface L_AnglesDao {


        @Insert
        void insert(L_Angles l_Angles);

        @Update
        void update(L_Angles l_Angles);

        @Delete
        void delete(L_Angles l_Angles);

        @Query("DELETE FROM L_Angles WHERE stiffener_id = :parentKey")
        void deleteAllForeignKeyMatchingParentKey(int parentKey);

        @Query("SELECT * FROM L_Angles WHERE stiffener_id = :parentKey ORDER BY l_angle_id DESC")
        LiveData<List<L_Angles>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
        //the ones bellow are unnecesary for now

        //in case I want to select all the data
        @Query("SELECT * FROM L_Angles ORDER BY l_angle_id DESC")
        LiveData<List<L_Angles>> getAll();

        ///in case I want to delete all the data
        @Query("DELETE FROM L_Angles")
        void deleteAll();

    }
