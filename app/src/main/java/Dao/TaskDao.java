package Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class TaskDao extends SQLiteOpenHelper {
    public TaskDao(@Nullable Context context) {
        super(context, "tb_ListTask", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL = "CREATE TABLE task (id INTEGER PRIMARY KEY, AUTO INCREMENT, title VARCHAR(50), description VARCHAR(500))";
        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String SQL = ("DROP TABLE task");
        sqLiteDatabase.execSQL(SQL);
        onCreate(sqLiteDatabase);
    }

    public void insert(Task task){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", task.getTitle());
        contentValues.put("description", task.getDescription());
        sqLiteDatabase.insert( "task", null, contentValues);
        sqLiteDatabase.close();
    }
}
