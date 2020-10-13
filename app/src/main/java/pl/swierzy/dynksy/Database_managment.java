package pl.swierzy.dynksy;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.VersionedPackage;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;


public class Database_managment extends SQLiteOpenHelper {

    public Database_managment (Context context){
        super(context, "database_all.db", null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table drinks("+
                "nr integer primary key autoincrement,"+
                "nazwa text,"+
                "photo text,"+
                "S1 text,"+
                "S2 text)" +
                "");

        db.execSQL(
                "create table shots("+
                        "nr integer primary key autoincrement,"+
                        "nazwa text,"+
                        "photo text,"+
                        "S1 text,"+
                        "S2 text)" +
                        "");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public  void add_drink(Drinks_database drinks_database){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa", drinks_database.getNazwa());
        wartosci.put("photo", drinks_database.getPhoto());
        wartosci.put("S1", drinks_database.getS1());
        wartosci.put("S2", drinks_database.getS2());
        db.insertOrThrow("drinks", null, wartosci);

    }
    public void delete_drink (int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] arguments = {""+id};
        db.delete("drinks","nr=?", arguments);
    }

    public void update_drink(Drinks_database drinks_database){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa", drinks_database.getNazwa());
        wartosci.put("photo", drinks_database.getPhoto());
        wartosci.put("S1", drinks_database.getS1());
        wartosci.put("S2", drinks_database.getS2());
        String args[] = {drinks_database.getNr()+""};
        db.update("drinks", wartosci,"nr=?" , args);
    }

    public List<Drinks_database> read_database() {
        List<Drinks_database> drinks_databaseList = new LinkedList<Drinks_database>();
        String[] columns = {"nr", "nazwa", "photo", "S1", "S2"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("drinks", columns, null, null, null, null, null, null);
        while (kursor.moveToNext()) {
            Drinks_database drinks_database = new Drinks_database();
            drinks_database.setNr(kursor.getLong(0));
            drinks_database.setNazwa(kursor.getString(1));
            drinks_database.setPhoto(kursor.getString(2));
            drinks_database.setS1(kursor.getString(3));
            drinks_database.setS2(kursor.getString(4));
            drinks_databaseList.add(drinks_database);

        }
        return drinks_databaseList;
    }





}
