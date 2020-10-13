package pl.swierzy.dynksy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class drinks extends MainActivity {

    public void drinks_back_void(View v){
        Toast.makeText(getApplicationContext(),"DRINKS ACTIVITY", Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(drinks.this, MainActivity.class);
        //startActivity(i);
        finish();
    }

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_layout);
        back = (Button) findViewById(R.id.drinks_button_back);

        TextView tv = (TextView) findViewById(R.id.textView_drinks);
        tv.setText("taki sobie teskt");


        Database_managment data_b = new Database_managment(this);

        /*database_add_class data_1 = new database_add_class();
        data_1.setNr_drink((long)1);
        data_1.setPhoto_drink("dupa");
        data_1.setS1_drink("dupa1");
        data_1.setS2_drink("dupa2");

        data_b.add_drink(data_1);


         */


        /*for(int i =4; i<= 1000;i++){
            data_b.delete_drink(i);
        }


         */



        /*
        while(k.moveToNext()){
            int nr = k.getInt(0);
            String nazwa_drinka = k.getString(1);
            String sciezka = k.getString(2);
            String skladnik_1 = k.getString(3);
            String skladnik_2 = k.getString(4);
            tv.setText(tv.getText()+"\n"+nr+" "+nazwa_drinka+" "+sciezka+" "+skladnik_1+" "+skladnik_2);
        }

         */


    for(database_add_class d:data_b.read_database_drinks()){
        tv.setText("Dane z bazy  :"+ d.getNr_drink() + " " + d.getNazwa_drink() + " " + d.getPhoto_drink() + " " +d.getS1_drink() + " " +d.getS2_drink());
    }



    }
}