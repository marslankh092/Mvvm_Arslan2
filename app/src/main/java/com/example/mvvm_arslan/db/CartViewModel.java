package com.example.mvvm_arslan.db;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvm_arslan.ModelEmployees;
import com.example.mvvm_arslan.repository.CartRepo;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private CartRepo cartRepo;

    public CartViewModel(@NonNull Application application) {
        super(application);
        cartRepo = new CartRepo(application);
    }

    public LiveData<List<ModelEmployees>> getAllCartItems() {
        return cartRepo.getAllCartItemsLiveData();
    }

    public void insertCartItem(ModelEmployees shoeCart) {
        cartRepo.insertCartItem(shoeCart);
    }

    public void insertCartList(List<ModelEmployees> shoeCart) {
        cartRepo.insertCartList(shoeCart);
    }

//    public void updateQuantity(int id, int quantity) {
//        cartRepo.updateQuantity(id, quantity);
//    }
//
//    public void updatePrice(int id, double price) {
//        cartRepo.updatePrice(id, price);
//    }

    public void deleteCartItem(ModelEmployees shoeCart) {
        cartRepo.deleteCartItem(shoeCart);
    }

    public void deleteAllCartItems() {
        cartRepo.deleteAllCartItems();
    }
}
