package com.example.finalexamcpsu2016;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.finalexamcpsu2016.adapter.userListAdapter;
import com.example.finalexamcpsu2016.db.DatabaseHelper;
import com.example.finalexamcpsu2016.model.user;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<user> userList = new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        mHelper = new DatabaseHelper(this);
        mDb = mHelper.getWritableDatabase();
        mListView = (ListView) findViewById(R.id.user_list_view);

        Cursor cursor = mDb.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        userList.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String image = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_IMAGE));

            user user = new user(name, image);
            userList.add(user);
        }
        userListAdapter adapter = new userListAdapter(
                this,
                R.layout.list_item,
                userList
        );

        mListView.setAdapter(adapter);

    }
}
