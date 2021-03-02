package pl.swierzy.dynksy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listTitulo;
    private LinkedHashMap<String, drink_add_class> expandableListDetalles;

    public CustomExpandableListAdapter(Context context,
                                       List<String> listTitulo,
                                       LinkedHashMap<String, drink_add_class> expandableListDetalles) {
        this.context = context;
        this.listTitulo = listTitulo;
        this.expandableListDetalles = expandableListDetalles;
    }


    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final drink_add_class drink = (drink_add_class) getChild(groupPosition, childPosition);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_item, null);

        }

        TextView S1 = convertView.findViewById(R.id.S1);
        S1.setText(drink.getS1_drink());
        if(drink.getS1_drink() == "") {
            
            S1.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S1 set to " + drink.getS1_drink());
        
        TextView S2 = convertView.findViewById(R.id.S2);
        S2.setText(drink.getS2_drink());
        if(drink.getS2_drink() == "") {
            S2.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");;
        }
        Log.d("wtf", "S2 set to " + drink.getS2_drink());
        
        TextView S3 = convertView.findViewById(R.id.S3);
        S3.setText(drink.getS3_drink());
        if(drink.getS3_drink() == "") {
            S3.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S3 set to " + drink.getS3_drink());
        
        TextView S4 = convertView.findViewById(R.id.S4);
        S4.setText(drink.getS4_drink());
        if(drink.getS4_drink().isEmpty()) {
            S4.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S4 set to " + drink.getS4_drink());

        TextView S5 = convertView.findViewById(R.id.S5);
        S5.setText(drink.getS5_drink());        
        if(drink.getS5_drink().isEmpty()) {
            S5.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S5 set to " + drink.getS5_drink());

        TextView S6 = convertView.findViewById(R.id.S6);
        S6.setText(drink.getS6_drink());
        if(drink.getS6_drink() == "") {
            S6.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }

        Log.d("wtf", "S6 set to " + drink.getS6_drink());
        
        TextView S7 = convertView.findViewById(R.id.S7);
        S7.setText(drink.getS7_drink());
        if(drink.getS7_drink() == "") {
            S7.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S7 set to " + drink.getS7_drink());
        
        TextView S8 = convertView.findViewById(R.id.S8);
        S8.setText(drink.getS8_drink());
        if(drink.getS8_drink() == "") {
            S8.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "S8 set to " + drink.getS8_drink());
        
        TextView instruction = convertView.findViewById(R.id.insruction);
        instruction.setText(drink.getInstruction_drink());
        if(drink.getInstruction_drink() == "") {
            instruction.getLayoutParams().height = 0;
            Log.d("wtf", "in if ");
        }
        Log.d("wtf", "Instr set to " + drink.getInstruction_drink());


       /* LinearLayout layoutLlamar = convertView.findViewById(R.id.lLlamar);


        layoutLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Llamamos a: "
                        + contacto.getNr_drink(), Toast.LENGTH_SHORT).show();
            }
        });

        */

        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        convertView.startAnimation(animation);


        return convertView;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {


        String nombre = (String) getGroup(groupPosition);
        drink_add_class contacto = (drink_add_class) getChild(groupPosition,0);

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.list_group, null);

        }

        TextView Nazwa_drinka = convertView.findViewById(R.id.Nazwa_drinka);


        Nazwa_drinka.setText(nombre);


        return convertView;
    }


    @Override
    public int getGroupCount() {
        return this.listTitulo.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listTitulo.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.expandableListDetalles.get(this.listTitulo.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
