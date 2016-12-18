package com.example.finalexamcpsu2016;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexamcpsu2016.db.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnReg;

    DatabaseHelper mHelper;
    SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button)findViewById(R.id.buttonLogin);
        btnReg = (Button)findViewById(R.id.buttonReg);

        mHelper = new DatabaseHelper(this);
        mDB = mHelper.getWritableDatabase();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(itn1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        final EditText etUser = (EditText)findViewById(R.id.editText1);
        final EditText etPsw = (EditText)findViewById(R.id.editText2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName= etUser.getText().toString();
                String password= etPsw.getText().toString();

                String storedPassword= mHelper.getSinlgeEntry(userName);
                if(storedPassword.equals(password)){
                    Toast.makeText(getApplicationContext(), "Create Account Successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_show_list) {
            Intent intent = new Intent(this,UserListActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
