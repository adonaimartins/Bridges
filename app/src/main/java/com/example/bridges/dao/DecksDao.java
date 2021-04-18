package com.example.bridges.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bridges.Model.AnglesRivetsDefects;
import com.example.bridges.Model.Decks;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface DecksDao {

    @Insert
    void insert(Decks deck);

    @Update
    void update(Decks deck);

    @Delete
    void delete(Decks deck);

    @Query("DELETE FROM Decks WHERE bridge_id = :parentKey")
    void deleteAllForeignKeyMatchingParentKey(int parentKey);

    @Query("SELECT * FROM Decks WHERE bridge_id = :parentKey ORDER BY deck_id DESC")
    ListenableFuture<List<Decks>> getAllForeignKeyMatchingParentKey(int parentKey);


///////////////////////////////////////////////////////////////////
    //the ones bellow are unnecesary for now

    //in case I want to select all the data
    @Query("SELECT * FROM Decks ORDER BY deck_id DESC")
    LiveData<List<Decks>> getAll();

    ///in case I want to delete all the data
    @Query("DELETE FROM Decks")
    void deleteAll();

    @Query("SELECT * FROM Decks WHERE deck_id =:id" )
    ListenableFuture<Decks> getDecksById(int id);


}
