package com.innova.dao;

import com.innova.util.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDaoConnection<T>{
    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T>List();

    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    }
}
