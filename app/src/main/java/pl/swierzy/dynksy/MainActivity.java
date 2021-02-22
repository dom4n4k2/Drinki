package pl.swierzy.dynksy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import pl.swierzy.dynksy.database_content;

public class MainActivity extends AppCompatActivity {




    public void main_update_button_void(View V) {
        String messange;
        Context context = this;
        database_content content = new database_content();
        messange = content.drink_read_from_csv(context);
        Toast.makeText(getApplicationContext(),messange, Toast.LENGTH_SHORT).show();

    }

    public void main_clear_button_void(View V){
        Toast.makeText(getApplicationContext(),"CLEAR", Toast.LENGTH_SHORT).show();

        Database_management data_b = new Database_management(this);
        for(int i =0; i<= 1000;i++){
            data_b.delete_drink(i);
        }

    }


    public void main_drinks_button_void(View V){
        Toast.makeText(getApplicationContext(),"DRINKS", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, drinks.class);
        startActivity(i);

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
    Button clear;
    Integer database_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drinks = (ImageButton)findViewById(R.id.drinks_button_main);
        shots = (ImageButton)findViewById(R.id.shots_button_main);
        cart = (ImageButton)findViewById(R.id.cart_button_main);
        update = (Button)findViewById(R.id.update_button_main);
        clear = (Button)findViewById(R.id.clear_button_main);







        //b=(Button) findViewById(R.id.button);
        //t=(TextView) findViewById(R.id.textView);
        //b.setText("SIEMA");
        //t.setTextColor(Color.MAGENTA);
        //t.setText("elo napis");
        //Log.i("tak", "aaa");
        //Toast.makeText(getApplicationContext(),"DUPA  ( . y ( . ) ",Toast.LENGTH_SHORT).show();

    }
}