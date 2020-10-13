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
        super(context, "database_for_bar.db", null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table drinks("+
                "nr_drink integer primary key autoincrement,"+
                "Nazwa_drink text,"+
                "Photo_drink text,"+
                "S1_drinc text,"+
                "S2_drink text,"+
                "S3_drink text,"+
                "S4_drink text,"+
                "S5_drink text,"+
                "S6_drink text,"+
                "S7_drink text,"+
                "S8_drink text,"+
                "Instruction_drink text)"+
                        "");
        /*db.execSQL(
                "create table shots("+
                        "nr_shot integer primary key autoincrement,"+
                        "Nazwa_shot text,"+
                        "Photo_shot text,"+
                        "S1_shot text,"+
                        "S2_shot text,"+
                        "S3_shot text,"+
                        "S4_shot text,"+
                        "S5_shot text,"+
                        "S6_shot text,"+
                        "S7_shot text,"+
                        "S8_shot text,"+
                        "Instruction_shot text)"+
                        "");
*/


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public  void add_drink(database_add_class database_class){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
            wartosci.put("Nazwa_drink", database_class.getNazwa_drink());
            wartosci.put("Photo_drink", database_class.getPhoto_drink());
            wartosci.put("S1_drink", database_class.getS1_drink());
            wartosci.put("S2_drink", database_class.getS2_drink());
            wartosci.put("S3_drink", database_class.getS3_drink());
            wartosci.put("S4_drink", database_class.getS4_drink());
            wartosci.put("S5_drink", database_class.getS5_drink());
            wartosci.put("S6_drink", database_class.getS6_drink());
            wartosci.put("S7_drink", database_class.getS7_drink());
            wartosci.put("S8_drink", database_class.getS8_drink());
            wartosci.put("Instruction_drink", database_class.getInstruction_drink());
        db.insertOrThrow("drinks", null, wartosci);

    }


    public  void add_shot(database_add_class database_class){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("Nazwa_shot", database_class.getNazwa_shot());
        wartosci.put("Photo_shot", database_class.getPhoto_shot());
        wartosci.put("S1_shot", database_class.getS1_shot());
        wartosci.put("S2_shot", database_class.getS2_shot());
        wartosci.put("S3_shot", database_class.getS3_shot());
        wartosci.put("S4_shot", database_class.getS4_shot());
        wartosci.put("S5_shot", database_class.getS5_shot());
        wartosci.put("S6_shot", database_class.getS6_shot());
        wartosci.put("S7_shot", database_class.getS7_shot());
        wartosci.put("S8_shot", database_class.getS8_shot());
        wartosci.put("Instruction_shot", database_class.getInstruction_shot());
        db.insertOrThrow("shots", null, wartosci);

    }
    public void delete_drink (int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] arguments = {""+id};
        db.delete("drinks","nr_drink=?", arguments);
    }

    public void delete_shot (int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] arguments = {""+id};
        db.delete("shots","nr_shot=?", arguments);
    }

    public void update_drink(database_add_class database_class){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
            wartosci.put("Nazwa_drink", database_class.getNazwa_drink());
            wartosci.put("Photo_drink", database_class.getPhoto_drink());
            wartosci.put("S1_drink", database_class.getS1_drink());
            wartosci.put("S2_drink", database_class.getS2_drink());
            wartosci.put("S3_drink", database_class.getS3_drink());
            wartosci.put("S4_drink", database_class.getS4_drink());
            wartosci.put("S5_drink", database_class.getS5_drink());
            wartosci.put("S6_drink", database_class.getS6_drink());
            wartosci.put("S7_drink", database_class.getS7_drink());
            wartosci.put("S8_drink", database_class.getS8_drink());
            wartosci.put("Instruction_drink", database_class.getInstruction_drink());
        String args[] = {database_class.getNr_drink()+""};
        db.update("drinks", wartosci,"nr_drink=?" , args);
    }

    public void update_shot(database_add_class database_class){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("Nazwa_shot", database_class.getNazwa_shot());
        wartosci.put("Photo_shot", database_class.getPhoto_shot());
        wartosci.put("S1_shot", database_class.getS1_shot());
        wartosci.put("S2_shot", database_class.getS2_shot());
        wartosci.put("S3_shot", database_class.getS3_shot());
        wartosci.put("S4_shot", database_class.getS4_shot());
        wartosci.put("S5_shot", database_class.getS5_shot());
        wartosci.put("S6_shot", database_class.getS6_shot());
        wartosci.put("S7_shot", database_class.getS7_shot());
        wartosci.put("S8_shot", database_class.getS8_shot());
        wartosci.put("Instruction_shot", database_class.getInstruction_shot());
        String args[] = {database_class.getNr_shot()+""};
        db.update("shots", wartosci,"nr_shot=?" , args);
    }

    public List<database_add_class> read_database_drinks() {
        List<database_add_class> drinks_databaseList = new LinkedList<database_add_class>();
        String[] columns = {"nr_drink", "Nazwa_drink","Photo_drink", "S1_drink","S2_drink","S3_drink","S4_drink","S5_drink","S6_drink","S7_drink","S8_drink","Instruction_drink"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("drinks", columns, null, null, null, null, null, null);
        while (kursor.moveToNext()) {
            database_add_class database_class = new database_add_class();
            database_class.setNr_drink(kursor.getLong(0));
            database_class.setNazwa_drink(kursor.getString(1));
            database_class.setPhoto_drink(kursor.getString(2));
            database_class.setS1_drink(kursor.getString(3));
            database_class.setS2_drink(kursor.getString(4));
            database_class.setS3_drink(kursor.getString(5));
            database_class.setS4_drink(kursor.getString(6));
            database_class.setS5_drink(kursor.getString(7));
            database_class.setS6_drink(kursor.getString(8));
            database_class.setS7_drink(kursor.getString(9));
            database_class.setS8_drink(kursor.getString(10));
            database_class.setInstruction_drink(kursor.getString(11));
            drinks_databaseList.add(database_class);

        }
        return drinks_databaseList;
    }

    public List<database_add_class> read_database_shots() {
        List<database_add_class> drinks_databaseList = new LinkedList<database_add_class>();
        String[] columns = {"nr_shot", "Nazwa_shot","Photo_shot", "S1_shot","S2_shot","S3_shot","S4_shot","S5_shot","S6_shot","S7_shot","S8_shot","Instruction_shot"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("shots", columns, null, null, null, null, null, null);
        while (kursor.moveToNext()) {
            database_add_class database_class = new database_add_class();
            database_class.setNr_shot(kursor.getLong(0));
            database_class.setNazwa_shot(kursor.getString(1));
            database_class.setPhoto_shot(kursor.getString(2));
            database_class.setS1_shot(kursor.getString(3));
            database_class.setS2_shot(kursor.getString(4));
            database_class.setS3_shot(kursor.getString(5));
            database_class.setS4_shot(kursor.getString(6));
            database_class.setS5_shot(kursor.getString(7));
            database_class.setS6_shot(kursor.getString(8));
            database_class.setS7_shot(kursor.getString(9));
            database_class.setS8_shot(kursor.getString(10));
            database_class.setInstruction_shot(kursor.getString(11));
            drinks_databaseList.add(database_class);

        }
        return drinks_databaseList;
    }
















/*

    public Drinks_database get_drink(int nr){
        Drinks_database drinks_database = new Drinks_database();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"nr","nazwa", "photo", "ingredient_1", "ingredient_2"};
        String args[] = {nr +" "};
        Cursor kursor = db.query("drinks", columns, " nr=?", args, null, null, null, null);
        if (kursor != null){
            kursor.moveToFirst();
            drinks_database.setNr(kursor.getLong(0));
            drinks_database.setNazwa(kursor.getString(1));
            drinks_database.setPhoto(kursor.getString(2));
            drinks_database.setIngredient_1(kursor.getString(3));
            drinks_database.setIngredient_2(kursor.getString(4));
        }
        return drinks_database;
    }
*/



}
