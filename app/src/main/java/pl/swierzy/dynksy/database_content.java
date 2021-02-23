package pl.swierzy.dynksy;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class database_content extends drinks {


    public String drink_read_from_csv(Context context){


        Database_management data_b = new Database_management(context);
        drink_add_class drink = new drink_add_class();
        InputStream is = context.getResources().openRawResource(R.raw.drinki);
        BufferedReader reader = new BufferedReader( new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        Integer count = 0;
        String return_status = null;

        try {

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //Log.d("wtf", "Line: " + line);
                String[] tokens = line.split(",");



                /*if(count == 0 ) {
                    if(db_version == 0){
                        SharedPreferences.Editor editor = getSharedPreferences("SharedVariables", MODE_PRIVATE).edit();
                        editor.putInt("db_version", Integer.parseInt(tokens[11]));
                        editor.apply();
                        return_status = "DATABASE WAS UPDATED FOR THE FIRST TIME";
                    }
                    if(db_version != Integer.parseInt(tokens[11])) {
                        SharedPreferences.Editor editor = getSharedPreferences("SharedVariables", MODE_PRIVATE).edit();
                        editor.putInt("db_version", Integer.parseInt(tokens[11]));
                        editor.apply();
                        return_status = "DATABASE UPDATED";
                        count = count + 1;
                    }else{
                        return_status = "NO NEED TO UPDATE";
                    }
                    count = count + 1;
                }


                 */
                drink.setNr_drink((long)1);
                drink.setNazwa_drink(tokens[0]);
                drink.setPhoto_drink(tokens[1]);
                drink.setS1_drink(tokens[2]);
                drink.setS2_drink(tokens[3]);
                drink.setS3_drink(tokens[4]);
                drink.setS4_drink(tokens[5]);
                drink.setS5_drink(tokens[6]);
                drink.setS6_drink(tokens[7]);
                drink.setS7_drink(tokens[8]);
                drink.setS8_drink(tokens[9]);
                drink.setInstruction_drink(tokens[10]);
                data_b.add_drink(drink);
            }
        } catch (IOException e){
            Log.d("wtf","Error reading data file on line" + line, e);
        }
        return return_status;
    }

    }





