package pl.swierzy.dynksy;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.LinkedList;
import java.util.List;


public class Database_management extends SQLiteOpenHelper {

    public Database_management(Context context){
        super(context, "database_all_bar.db", null,1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table drinks("+
                "nr_drink integer primary key,"+
                "nazwa_drink text,"+
                "photo_drink text,"+
                "S1_drink text,"+
                "S2_drink text," +
                "S3_drink text," +
                "S4_drink text," +
                "S5_drink text," +
                "S6_drink text," +
                "S7_drink text," +
                "S8_drink text," +
                "Instruction_drink text)" +
                "");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public  void add_drink(drink_add_class drinks_database){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa_drink", drinks_database.getNazwa_drink());
        wartosci.put("photo_drink", drinks_database.getPhoto_drink());
        wartosci.put("S1_drink", drinks_database.getS1_drink());
        wartosci.put("S2_drink", drinks_database.getS2_drink());
        wartosci.put("S3_drink", drinks_database.getS3_drink());
        wartosci.put("S4_drink", drinks_database.getS4_drink());
        wartosci.put("S5_drink", drinks_database.getS5_drink());
        wartosci.put("S6_drink", drinks_database.getS6_drink());
        wartosci.put("S7_drink", drinks_database.getS7_drink());
        wartosci.put("S8_drink", drinks_database.getS8_drink());
        wartosci.put("Instruction_drink", drinks_database.getInstruction_drink());
        db.insertOrThrow("drinks", null, wartosci);

    }
    public void delete_drink (int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] arguments = {""+id};
        db.delete("drinks","nr_drink=?", arguments);
    }



    public void update_drink(drink_add_class drinks_database){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues wartosci = new ContentValues();
        wartosci.put("nazwa_drink", drinks_database.getNazwa_drink());
        wartosci.put("photo_drink", drinks_database.getPhoto_drink());
        wartosci.put("S1_drink", drinks_database.getS1_drink());
        wartosci.put("S2_drink", drinks_database.getS2_drink());
        wartosci.put("S3_drink", drinks_database.getS3_drink());
        wartosci.put("S4_drink", drinks_database.getS4_drink());
        wartosci.put("S5_drink", drinks_database.getS5_drink());
        wartosci.put("S6_drink", drinks_database.getS6_drink());
        wartosci.put("S7_drink", drinks_database.getS7_drink());
        wartosci.put("S8_drink", drinks_database.getS8_drink());
        wartosci.put("Instruction_drink", drinks_database.getInstruction_drink());
        String args[] = {drinks_database.getNr_drink()+""};
        db.update("drinks", wartosci,"nr_drink=?" , args);
    }

    public List<drink_add_class> read_drink() {
        List<drink_add_class> drinks_databaseList = new LinkedList<drink_add_class>();
        String[] columns = {"nr_drink", "nazwa_drink", "photo_drink", "S1_drink", "S2_drink", "S3_drink", "S4_drink", "S5_drink", "S6_drink", "S7_drink", "S8_drink", "Instruction_drink"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor kursor = db.query("drinks", columns, null, null, null, null, null, null);
        while (kursor.moveToNext()) {
            drink_add_class drinks_database = new drink_add_class();
            drinks_database.setNr_drink(kursor.getLong(0));
            drinks_database.setNazwa_drink(kursor.getString(1));
            drinks_database.setPhoto_drink(kursor.getString(2));
            drinks_database.setS1_drink(kursor.getString(3));
            drinks_database.setS2_drink(kursor.getString(4));
            drinks_database.setS3_drink(kursor.getString(5));
            drinks_database.setS4_drink(kursor.getString(6));
            drinks_database.setS5_drink(kursor.getString(7));
            drinks_database.setS6_drink(kursor.getString(8));
            drinks_database.setS7_drink(kursor.getString(9));
            drinks_database.setS8_drink(kursor.getString(10));
            drinks_database.setInstruction_drink(kursor.getString(11));
            drinks_databaseList.add(drinks_database);

        }
        return drinks_databaseList;
    }





}
