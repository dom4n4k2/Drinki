package pl.swierzy.dynksy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    public void main_drinks_void(View V){
        Toast.makeText(getApplicationContext(),"DRINKS", Toast.LENGTH_SHORT).show();
    }

    public void main_shots_void(View V){
        Toast.makeText(getApplicationContext(),"SHOTS", Toast.LENGTH_SHORT).show();
    }

    public void main_cart_void(View V){
        Toast.makeText(getApplicationContext(),"CART", Toast.LENGTH_SHORT).show();
    }

    ImageButton drinks;
    ImageButton shots;
    ImageButton cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drinks = (ImageButton)findViewById(R.id.drinks_button);
        shots = (ImageButton)findViewById(R.id.shots_button);
        cart = (ImageButton)findViewById(R.id.cart_button);




        //b=(Button) findViewById(R.id.button);
        //t=(TextView) findViewById(R.id.textView);
        //b.setText("SIEMA");
        //t.setTextColor(Color.MAGENTA);
        //t.setText("elo napis");
        //Log.i("tak", "aaa");
        //Toast.makeText(getApplicationContext(),"DUPA  ( . y ( . ) ",Toast.LENGTH_SHORT).show();

    }
}