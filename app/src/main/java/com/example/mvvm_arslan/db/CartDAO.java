package com.example.mvvm_arslan.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvm_arslan.ModelEmployees;

import java.util.List;

@Dao
public interface CartDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCartItem(ModelEmployees shoeCart);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllEmp(List<ModelEmployees> emps);

    @Query("SELECT * FROM employees_table")
    LiveData<List<ModelEmployees>> getAllCartItems();

    @Delete
    void deleteCartItem(ModelEmployees modelEmployees);
//
//    @Query("UPDATE employees_table SET quantity=:quantity WHERE id=:id")
//    void updateQuantity(int id , int quantity);
//
//    @Query("UPDATE employees_table SET totalItemPrice=:totalItemPrice WHERE id=:id")
//    void updatePrice(int id , double totalItemPrice);

    @Query("DELETE FROM employees_table")
    void deleteAllItems();

}
