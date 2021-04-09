package com.example.bridges.database;

public class DatabaseContract {

    ///this variables are to pass as a parameters to Model Objects to know if they have been stored or not in MySQL server database
    public static final int SYNC_STATUS_OK = 0;
    public static final int SYNC_STATUS_FAILED = 1;

    //this variables are used to pass the data to the viewmodel to know what type of queries it needs to perform to the database
    public static final int INSERT = 2;
    public static final int UPDATE = 4;
    public static final int DELETE = 8;
    public static final int DELETE_ALL = 16;
    public static final int SELECT_FROM_PARENT = 32;



}
