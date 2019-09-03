package com.hfad.restaurantapp.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface CreditCardDao {

    @Query("SELECT * FROM ccdata ORDER BY lastName")
    List<CreditCardEntry> loadAllTasks();

    @Insert
    void insertTask(CreditCardEntry taskEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(CreditCardEntry taskEntry);

    @Delete
    void deleteTask(CreditCardEntry taskEntry);
}
