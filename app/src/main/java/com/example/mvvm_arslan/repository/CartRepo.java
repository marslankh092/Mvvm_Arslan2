package com.example.mvvm_arslan.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.mvvm_arslan.ModelEmployees;
import com.example.mvvm_arslan.db.CartDAO;
import com.example.mvvm_arslan.db.CartDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {

    private CartDAO cartDAO;
    private LiveData<List<ModelEmployees>> allCartItemsLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<ModelEmployees>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){
        cartDAO = CartDatabase.getInstance(application).cartDAO();
        allCartItemsLiveData = cartDAO.getAllCartItems();
    }

    public void insertCartItem(ModelEmployees shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.insertCartItem(shoeCart);
            }
        });
    }

    public void insertCartList(List<ModelEmployees> shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.insertAllEmp(shoeCart);
            }
        });
    }

    public void deleteCartItem(ModelEmployees shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteCartItem(shoeCart);
            }
        });
    }

//    public void updateQuantity(int id , int quantity) {
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                cartDAO.updateQuantity(id, quantity);
//            }
//        });
//    }
//
//    public void updatePrice(int id , double price){
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                cartDAO.updatePrice(id , price);
//            }
//        });
//    }

    public void deleteAllCartItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteAllItems();
            }
        });
    }
}
