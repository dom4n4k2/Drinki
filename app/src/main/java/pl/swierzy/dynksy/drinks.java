package pl.swierzy.dynksy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;



public class drinks extends MainActivity {

    public void drinks_back_void(View v){
        Toast.makeText(getApplicationContext(),"DRINKS ACTIVITY", Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(drinks.this, MainActivity.class);
        //startActivity(i);
        finish();
    }




    Button back;

    @SuppressLint("SetTextI18n")

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_layout);
        back = (Button) findViewById(R.id.drinks_button_back);


        TextView tv = (TextView) findViewById(R.id.textView_drinks);
        tv.setText("taki sobie teskt");

      Database_management data_b = new Database_management(this);
/*
    for(drink_add_class d:data_b.read_drink()){
        tv.setText("Dane z bazy  :\n"+ d.getNr_drink() +
                "\n" + d.getNazwa_drink()+
                "\n" + d.getPhoto_drink()+
                "\n" +d.getS1_drink()+
                "\n" +d.getS2_drink()+
                "\n" +d.getS3_drink()+
                "\n" +d.getS4_drink()+
                "\n" +d.getS5_drink()+
                "\n" +d.getS6_drink()+
                "\n" +d.getS7_drink()+
                "\n" +d.getS8_drink()+
                "\n" +d.getInstruction_drink());
    }

*/
        for(drink_add_class d:data_b.read_drink()){
            Log.d("wtf", d.getNr_drink() +
                    "  " + d.getTyp()+
                    "  " + d.getNazwa_drink()+
                    "  " + d.getPhoto_drink()+
                    "  " +d.getS1_drink()+
                    "  " +d.getS2_drink()+
                    "  " +d.getS3_drink()+
                    "  " +d.getS4_drink()+
                    "  " +d.getS5_drink()+
                    "  " +d.getS6_drink()+
                    "  " +d.getS7_drink()+
                    "  " +d.getS8_drink()+
                    "  " +d.getInstruction_drink());
        }

    }
}