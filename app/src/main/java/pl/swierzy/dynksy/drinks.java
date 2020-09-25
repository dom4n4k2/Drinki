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

        //data_b.add_drink("drink 1", "sciezka photo", "skladnik 1", "skladnik 2");
        //data_b.add_drink("drink 2", "sciezka photo 2", "skladnik 5", "skladnik 6");
        //data_b.add_drink("drink 2", "sciezka photo 2", "skladnik 5", "skladnik 6");

        //Cursor k = data_b.read_database();


        for(int i =4; i<= 1000;i++){
            data_b.delete_drink(i);
        }



        //data_b.update_drink(1, "dupaa", "dup3a", "dup3a", "dup4a");
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
/*
        Drinks_database d = data_b.get_drink(2);
        tv.setText(d.getNazwa() + "-" + d.getPhoto() + "-" + d.getIngredient_1() + "-" + d.getIngredient_2());
*/

    for(Drinks_database d:data_b.read_database()){
        Log.e("Dane z bazy  :", d.getNr() + " " + d.getNazwa() + " " + d.getPhoto() + " " +d.getIngredient_1() + " " +d.getIngredient_2());
    }

    }
}