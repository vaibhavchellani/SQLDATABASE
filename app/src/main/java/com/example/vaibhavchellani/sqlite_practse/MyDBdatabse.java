package com.example.vaibhavchellani.sqlite_practse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vaibhavchellani on 1/6/17.
 */

public class MyDBdatabse extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="products.db";
    public static final String TABLE_PRODUCTS="products";
    public static final String  COLUMN_ID="_id";
    public static final String  COLUMN_PRODUCTNAME="_productname";

    public MyDBdatabse(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABSE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE_PRODUCTS + "("+
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT"+
                COLUMN_PRODUCTNAME + "TEXT" +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXITS"+TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add new row to the database
    public void addProduct (products product){
        ContentValues values=new ContentValues();//list
        values.put(COLUMN_PRODUCTNAME,product.get_products());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);//inserts new row
        db.close();

    }
    public void deleteProduct(String productname){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM"+TABLE_PRODUCTS+"WHERE"+COLUMN_PRODUCTNAME+"=\""+productname+"\";");

    }
    //pritn database as a string, returns string
    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_PRODUCTS+"WHERE !";//means select every column and row
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME))!=null){
                dbString+=c.getString(c.getColumnIndex(COLUMN_PRODUCTNAME));
                dbString+="\n";

            }
        }
        db.close();
        return dbString;
    }
}
