package pl.swierzy.dynksy;
import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class database_content extends drinks {

    public void drink_read_from_csv(Context context){
        Database_management data_b = new Database_management(context);
        drink_add_class drink_1 = new drink_add_class();

        prepArray(context);



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


    private void prepArray(Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.drinki);
        BufferedReader reader = new BufferedReader( new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";

        try {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                Log.d("wtf", "Line: " + line);
            }
        } catch (IOException e){
                Log.d("wtf","Error reading data file on line" + line, e);
        }




    }

    }





