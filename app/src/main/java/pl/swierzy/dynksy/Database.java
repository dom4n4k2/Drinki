package pl.swierzy.dynksy;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.VersionedPackage;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {

    public Database (Context context){
        super(context, "database_all.db", null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table drinks("+
                "nr integer primary key autoincrement,"+
                "nazwa text,"+
                "photo text,"+
                "ingredient_1 text,"+
                "ingredient_2 text)" +
                "");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public void add_drink(String nazwa, String photo, String ingredient_1, String ingredient_2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa", nazwa);
        wartosci.put("photo", photo);
        wartosci.put("ingredient_1", ingredient_1);
        wartosci.put("ingredient_2", ingredient_2);
        db.insertOrThrow("drinks", null, wartosci);
    }

    public Cursor read_database(){
        String[] columns = {"nr","nazwa", "phosssto", "ingredient_1", "ingredient_2"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("drinks", columns, null, null, null, null, null, null);
        return kursor;
    }


}
