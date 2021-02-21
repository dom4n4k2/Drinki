package pl.swierzy.dynksy;
import android.content.Context;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;

import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class database_content extends drinks {

    public void drink_read_from_csv(Context context){
        Database_management data_b = new Database_management(context);
        drink_add_class drink_1 = new drink_add_class();



        drink_1.setNr_drink((long)1);
        drink_1.setNazwa_drink("kurwamac");
        drink_1.setPhoto_drink("ochuj");
        drink_1.setS1_drink("S1");
        drink_1.setS2_drink("S2");
        drink_1.setS3_drink("S3");
        drink_1.setS4_drink("S4");
        drink_1.setS5_drink("S5");
        drink_1.setS6_drink("S6");
        drink_1.setS7_drink("S7");
        drink_1.setS8_drink("S8");
        drink_1.setInstruction_drink("Instruction");
        data_b.add_drink(drink_1);

    }



    }


