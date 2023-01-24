package com.example.mvvm_arslan;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employees_table")

public class ModelEmployees
{
    @PrimaryKey(autoGenerate = true)
      public       int id;
    String name;
    String image;

    public ModelEmployees() {
    }

    public ModelEmployees(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}