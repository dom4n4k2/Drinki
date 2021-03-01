package pl.swierzy.dynksy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class drinks extends MainActivity {


    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListNombres;
    private HashMap<String, Contacto> listaContactos;
    private int lastExpandedPosition = -1;


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


        init();

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });


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


    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listaContactos = getContactos();
        this.expandableListNombres = new ArrayList<>(listaContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,
                expandableListNombres, listaContactos);

    }


    private HashMap<String, Contacto> getContactos() {
        HashMap<String, Contacto> listaC = new HashMap<>();

        listaC.put("Juan", new Contacto("111-111-111",
                "juan@correo.com", "Calle 1, 11 - 4D", R.drawable.img_11));
        listaC.put("Sara", new Contacto("222-222-222",
                "sara@correo.com", "Calle 2, 1 - 1A", R.drawable.img_22));
        listaC.put("Raquel", new Contacto("333-333-333",
                "raquel@correo.com", "Calle 3, 3 - 6B", R.drawable.img_33));


        return listaC;
    }
}