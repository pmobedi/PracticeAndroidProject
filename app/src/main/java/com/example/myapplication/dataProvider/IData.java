package com.example.myapplication.dataProvider;

import com.example.myapplication.models.Product;

import java.util.List;

public interface IData {
    public List<Product> getBestProducts();

    public List<Product> getNewProducts();

    public List<Product> getBestFreeProducts();

    public List<Product> getAnnouncements();


}
