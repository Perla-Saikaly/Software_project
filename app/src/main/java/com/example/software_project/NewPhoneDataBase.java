package com.example.software_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class NewPhoneDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "NewPhone.db";
    private static final int DB_VERSION = 1;

    public NewPhoneDataBase( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sqlStatement = "CREATE TABLE newphone (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, status TEXT,  quantity INT, price INT);";
        db.execSQL(sqlStatement);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS customer");
    }

    public boolean insertData(com.example.software_project.NewPhone newPhone) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("name", newPhone.getName());
        value.put("staus", newPhone.getStatus());
        value.put("price", newPhone.getPrice());
        value.put("quantity", newPhone.getQuantity());
        long result = database.insert("newphone", null, value);

        return result != -1;
    }

    public List<com.example.software_project.NewPhone> getNewPhones() {
        ArrayList<com.example.software_project.NewPhone> newphonelist = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM newphone";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String status = cursor.getString(2);
                int price = cursor.getInt(3);
                int quantity= cursor.getInt(4);

                com.example.software_project.NewPhone newPhone = new com.example.software_project.NewPhone(name, status, price, quantity);
                newphonelist.add(newPhone);
            } while (cursor.moveToNext());
        } else {
        }
        cursor.close();
        db.close();
        return newphonelist;
    }



    public static String[] newPhoneNames = new String[]{
            "Hawawi","The Richest Man in Babylon","Maybe Someday","Glass sword","Ugly Love"
    };
    public static int[] newPhoneImages = new int[]{
            R.drawable.img,
            R.drawable.img, R.drawable.img, R.drawable.img,
            R.drawable.img
    };

    public static String[] newPhoneStatus = new String[]{
            "Robert M. Drake ","Goerge S. Clason", "Collen Hoover","Victoria Aveyard","Collen Hoover"
    };
    public static String[] newPhonePrice = new String[]{
            "L.L 180,000","L.L 180,000","L.L 200,000","L.L 190,000","L.L 200,000"
    };
}
