package com.example.vaibhavchellani.sqlite_practse;


public class products {
    private int _id;
    private String _products;

    public products() {

    }

    public products(String products) {
        this._products = products;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_products(String _products) {
        this._products = _products;
    }

    public int get_id() {
        return _id;
    }

    public String get_products() {
        return _products;
    }
}
