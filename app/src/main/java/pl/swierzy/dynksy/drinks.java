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


Drinks_database drink_1 = new Drinks_database();
drink_1.setNr((long) 1);
drink_1.setNazwa("kurwamac");
data_b.add_drink(drink_1);


        for(int i =4; i<= 1000;i++){
            data_b.delete_drink(i);
        }






    for(Drinks_database d:data_b.read_database()){
        tv.setText("Dane z bazy  :"+ d.getNr() + " " + d.getNazwa() + " " + d.getPhoto() + " " +d.getS1() + " " +d.getS2());
    }

    }
}