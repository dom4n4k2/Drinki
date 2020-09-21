package pl.swierzy.dynksy;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.VersionedPackage;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


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
                "ingredient_1 text,"+
                "ingredient_2 text)" +
                "");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public  void add_drink(String nazwa, String photo, String ingredient_1, String ingredient_2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa", nazwa);
        wartosci.put("photo", photo);
        wartosci.put("ingredient_1", ingredient_1);
        wartosci.put("ingredient_2", ingredient_2);
        db.insertOrThrow("drinks", null, wartosci);

    }
    public void delete_drink (int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] arguments = {""+id};
        db.delete("drinks","nr=?", arguments);
    }

    public void update_drink(int nr, String nazwa, String photo, String ingredient_1, String ingredient_2){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa", nazwa);
        wartosci.put("photo", photo);
        wartosci.put("ingredient_1", ingredient_1);
        wartosci.put("ingredient_2", ingredient_2);
        String args[] = {nr+""};
        db.update("drinks", wartosci,"nr=?" , args);
    }

    public Cursor read_database(){
        String[] columns = {"nr","nazwa", "photo", "ingredient_1", "ingredient_2"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("drinks", columns, null, null, null, null, null, null);
        return kursor;
    }



     /*

    public Drinks_database get_drink(int nr){
        Drinks_database drinks_database = new Drinks_database();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"nr","nazwa", "photo", "ingredient_1", "ingredient_2"};
        String args[] = {nr +" "};
        Cursor kursor = db.query("drinks", columns, " nr=?", null, null, null, null, null);
        if (kursor != null){
            kursor.moveToFirst();
            drinks_database.setNr(kursor.getLong(0));
            drinks_database.setNazwa_drinka(kursor.getString(1));
            drinks_database.setSciezka(kursor.getString(2));
            drinks_database.setIngredient_1(kursor.getString(3));
            drinks_database.setIngredient_2(kursor.getString(4));
        }
        return drinks_database;
    }

      */


}
