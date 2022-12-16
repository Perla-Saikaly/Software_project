package com.example.software_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;

public class UserDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "USER.db";
    private static final int DB_VERSION = 1;

    public UserDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStatement = "CREATE TABLE customer (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, username TEXT, email TEXT, password TEXT);";
        db.execSQL(sqlStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS customer");
    }


    public boolean insertData(User user) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put("username", user.getUsername());
        value.put("email", user.getEmail());
        value.put("password", user.getPassword());
        long result = database.insert("customer", null, value);

        return result != -1;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM customer";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String username = cursor.getString(1);
                String email = cursor.getString(2);
                String password = cursor.getString(3);

                User user = new User(username, email, password);
                userList.add(user);
            } while (cursor.moveToNext());
        } else {
        }
        cursor.close();
        db.close();
        return userList;
    }


    public User search(String email) {
//            User user = new User(null, email, null);
        User user = null;
        ArrayList<User> users = this.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                user = new User(users.get(i).getUsername(), users.get(i).getEmail(), users.get(i).getPassword());
            }
        }

        return user;
    }


    public boolean deleteUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("customer", "email" + "=?", new String[]{user.getEmail()}) > 0;

    }
}