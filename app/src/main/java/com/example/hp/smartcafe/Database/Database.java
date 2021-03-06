package com.example.hp.smartcafe.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.hp.smartcafe.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 24-01-2018.
 */

public class Database extends SQLiteAssetHelper{

    private static final  String DATABASE_NAME="SmartCafeDB.db";
    private static final  int DATABASE_VER=1;
    public Database(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VER);
    }

    public List<Order> getCarts()
    {
        SQLiteDatabase db= getReadableDatabase();
        SQLiteQueryBuilder qb= new SQLiteQueryBuilder();

        String[] sqlSelect={"ProductName","ProductId","Quantity","Price"};
        String sqlTable="OrderDetail";
        qb.setTables(sqlTable);
        Cursor c=qb.query(db,sqlSelect,null,null,null,null,null);

        final  List<Order> result = new ArrayList<>();
        if (c.moveToNext())
        {
            do {
                result.add(new Order(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price"))
                 ));
            }while (c.moveToNext());

        }
        return result;

    }

public  void addToCart(Order order)
{
    SQLiteDatabase db=getReadableDatabase();
    String query= String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price) VALUES('%s','%s','%s','%s');",
           order.getProductId(),
            order.getProductName(),
            order.getQuantity(),
            order.getPrice());

    db.execSQL(query);


}
    public  void cleanCart()
    {
        SQLiteDatabase db=getReadableDatabase();
        String query= String.format("DELETE FROM OrderDetail");

        db.execSQL(query);


    }

}
