package com.example.finalexamcpsu2016.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by tmbeamm on 12/18/2016 AD.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "final.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "finalexam";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_USER = "user";
    public static final String COL_PASSWORD = "password";
    public static final String COL_IMAGE = "image";
    private SQLiteDatabase mDB;

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_NAME + " TEXT,"
                    + COL_USER + " TEXT,"
                    + COL_PASSWORD + " TEXT,"
                    + COL_IMAGE + " TEXT"
                    + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        insertInitialData(db);

    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "Android Studio");
        cv.put(COL_USER, "android");
        cv.put(COL_PASSWORD, "123456");
        cv.put(COL_IMAGE, "idm.png");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_NAME, "Promlert Lovichit");
        cv.put(COL_USER, "promlert");
        cv.put(COL_PASSWORD, "456789");
        cv.put(COL_IMAGE, "idm.png");
        db.insert(TABLE_NAME, null, cv);

        cv.put(COL_NAME, "Mark Zuckerberg");
        cv.put(COL_USER, "markz");
        cv.put(COL_PASSWORD, "789012");
        cv.put(COL_IMAGE, "idm.png");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String checkUser(String user) {
        Cursor cursor = mDB.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);
        ArrayList<String> dbUser = new ArrayList<>();
        String check = "YES";
        dbUser.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_USER));

            dbUser.add(name);
        }
        for(int i = 0;i<dbUser.size();i++){
            if(dbUser.get(i).equals(user)){
                check = "NO";
            }
        }
        return check;
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor=mDB.query(TABLE_NAME, null,COL_USER, new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
        cursor.close();
        return password;
    }
}
