package com.example.finalexamcpsu2016;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexamcpsu2016.db.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUser,editTextName,editTextPassword;
    Button btnCreateAccount;

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mHelper = new DatabaseHelper(this);
        mDB = mHelper.getWritableDatabase();

        editTextName = (EditText)findViewById(R.id.regName);
        editTextUser = (EditText)findViewById(R.id.regUser);
        editTextPassword = (EditText)findViewById(R.id.regPsw);

        btnCreateAccount = (Button)findViewById(R.id.btnReg);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=editTextUser.getText().toString();
                String password=editTextPassword.getText().toString();
                String name=editTextName.getText().toString();

                /*if(mHelper.checkUser(user).equals("NO")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                    dialog.setTitle("Registration Failed!");
                    dialog.setMessage("User Alredy Exits");
                    dialog.show();
                }*/
                //else{
                    ContentValues cv = new ContentValues();
                    cv.put(DatabaseHelper.COL_NAME, name);
                    cv.put(DatabaseHelper.COL_USER, user);
                    cv.put(DatabaseHelper.COL_PASSWORD, password);
                    cv.put(DatabaseHelper.COL_IMAGE, "idm.png");

                    mDB.insert(DatabaseHelper.TABLE_NAME, null, cv);
                    Toast.makeText(getApplicationContext(), "Create Account Successfully ", Toast.LENGTH_SHORT).show();
                    finish();
                //}

            }
        });
    }
}
