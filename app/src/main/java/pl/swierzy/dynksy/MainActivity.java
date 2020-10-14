package pl.swierzy.dynksy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import pl.swierzy.dynksy.database_content;

public class MainActivity extends AppCompatActivity {


    public void main_drinks_button_void(View V){
        Toast.makeText(getApplicationContext(),"DRINKS", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, drinks.class);
        startActivity(i);

    }

    public void main_update_button_void(View V){
        Toast.makeText(getApplicationContext(),"UPDATE", Toast.LENGTH_SHORT).show();
        Database_management data_b = new Database_management(this);
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

    public void main_delete_button_void(View V){
        Toast.makeText(getApplicationContext(),"DELETE", Toast.LENGTH_SHORT).show();
        Database_management data_b = new Database_management(this);

        for(int i =0; i<= 1000;i++){
            data_b.delete_drink(i);
        }

    }





    public void main_shots_button_void(View V){
        Toast.makeText(getApplicationContext(),"SHOTS", Toast.LENGTH_SHORT).show();
    }

    public void main_cart_button_void(View V){
        Toast.makeText(getApplicationContext(),"CART", Toast.LENGTH_SHORT).show();
    }

    ImageButton drinks;
    ImageButton shots;
    ImageButton cart;
    Button update;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drinks = (ImageButton)findViewById(R.id.drinks_button_main);
        shots = (ImageButton)findViewById(R.id.shots_button_main);
        cart = (ImageButton)findViewById(R.id.cart_button_main);
        update = (Button)findViewById(R.id.update_button_main);
        delete = (Button)findViewById(R.id.delete_button_main);







        //b=(Button) findViewById(R.id.button);
        //t=(TextView) findViewById(R.id.textView);
        //b.setText("SIEMA");
        //t.setTextColor(Color.MAGENTA);
        //t.setText("elo napis");
        //Log.i("tak", "aaa");
        //Toast.makeText(getApplicationContext(),"DUPA  ( . y ( . ) ",Toast.LENGTH_SHORT).show();

    }
}