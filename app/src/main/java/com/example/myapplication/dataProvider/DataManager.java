package com.example.myapplication.dataProvider;

import com.example.myapplication.models.Product;

import java.util.ArrayList;
import java.util.List;

public class DataManager  implements  IData{
    @Override
    public List<Product> getBestProducts() {
        List<Product> productList = new ArrayList<>();
        return productList;
    }

    @Override
    public List<Product> getNewProducts() {
        return null;
    }

    @Override
    public List<Product> getBestFreeProducts() {
        return null;
    }

    @Override
    public List<Product> getAnnoucements() {
        return null;
    }
}
