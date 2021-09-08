package com.example.student_management_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATA_BASE ="Student_Record_System.db";
    private static final String TABLE_NAME ="StudentDetails";
    private static final String USER_NAME ="User_Name";
    private static final String FULL_NAME ="Full_Name";
    private static final String MOBILE = "Mobile_Number";
    private static final String PASSWORD ="Password";
    private static final int VERSION_NUMBER = 1;
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+USER_NAME+" VARCHAR(20),"+FULL_NAME+"  VARCHAR(20),"+MOBILE+" VARCHAR(20), "+PASSWORD+" VARCHAR(20));";
    private Context context;
    public DataBase(Context context) {
        super(context, DATA_BASE,null, VERSION_NUMBER) ;
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context, "Database Created.", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insert(String userName, String fullName, String mobile, String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,userName);
        contentValues.put(FULL_NAME,fullName);
        contentValues.put(MOBILE,mobile);
        contentValues.put(PASSWORD,password);

        return sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }
    public int update(String oldUserName,String userName, String fullName, String mobile, String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME,userName);
        contentValues.put(FULL_NAME,fullName);
        contentValues.put(MOBILE,mobile);
        contentValues.put(PASSWORD,password);
        sqLiteDatabase.update(TABLE_NAME,contentValues,USER_NAME+ " = ?",new String[]{oldUserName});
        return 1;
    }
    public Cursor display()
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
    public int delete(String userName,Context context)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Toast.makeText(context, "delete successful", Toast.LENGTH_SHORT).show();

        return sqLiteDatabase.delete(TABLE_NAME,USER_NAME+ " = ?",new String[]{userName});
    }
}

