package pl.swierzy.dynksy;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
    private HashMap<String, Drink_Get_Set> listaContactos;
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



    }


    private void init() {
        this.expandableListView = findViewById(R.id.expandableListView);
        this.listaContactos = getContactos();
        this.expandableListNombres = new ArrayList<>(listaContactos.keySet());
        this.expandableListAdapter = new CustomExpandableListAdapter(this,
                expandableListNombres, listaContactos);

    }


    private HashMap<String, Drink_Get_Set> getContactos() {
        HashMap<String, Drink_Get_Set> listaC = new HashMap<>();
        Database_management data_b = new Database_management(this);

        for(drink_add_class d:data_b.read_drink()) {
            listaC.put(d.getNazwa_drink(), new Drink_Get_Set(d.getNr_drink(), d.getTyp(), d.getNazwa_drink(), d.getPhoto_drink(), d.getS1_drink(), d.getS2_drink(), d.getS3_drink(), d.getS4_drink(), d.getS5_drink(), d.getS6_drink(), d.getS7_drink(), d.getS8_drink(), d.getInstruction_drink()));
        }

        return listaC;
    }


}


