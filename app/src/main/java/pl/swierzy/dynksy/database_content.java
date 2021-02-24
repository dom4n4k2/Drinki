package pl.swierzy.dynksy;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class database_content extends drinks {


    public static Pair<String, Integer> drink_read_from_csv(Context context, int database_version){


        Database_management data_b = new Database_management(context);
        drink_add_class drink = new drink_add_class();
        InputStream is = context.getResources().openRawResource(R.raw.drinki);
        BufferedReader reader = new BufferedReader( new InputStreamReader(is, Charset.forName("UTF-8")));
        String line = "";
        Integer count = 0;
        String return_status = null;
        int return_database_version = 0;
        boolean to_update = false;

        try {

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //Log.d("wtf", "Line: " + line);
                String[] tokens = line.split(";");



                if(count == 0 ) {
                    if(database_version != Integer.parseInt(tokens[11])){
                        return_database_version = Integer.parseInt(tokens[11]);
                        return_status = "DATABASE WAS UPDATED FOR THE FIRST TIME";
                        for(int i =0; i<= 1000;i++) {
                            data_b.delete_drink(i);
                        }
                        to_update = true;

                    }

                    else{
                        return_status = "NO NEED TO UPDATE";
                        return_database_version = database_version;
                        to_update = false;
                    }
                    count = count + 1;
                }
                if (to_update == true) {

                    drink.setNr_drink((long) 1);
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

            }
        } catch (IOException e){
            Log.d("wtf","Error reading data file on line" + line, e);
        }
        return new Pair<>(return_status, return_database_version);
    }

    }





