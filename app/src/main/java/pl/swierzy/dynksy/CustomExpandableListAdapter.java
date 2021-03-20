package pl.swierzy.dynksy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.LinkedHashMap;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

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
        S1.setText(drink.getS1_drink() + " " + drink.getS1_q());
        if(drink.getS1_drink().isEmpty()) {
            S1.getLayoutParams().height = 0;
        }
        
        TextView S2 = convertView.findViewById(R.id.S2);
        S2.setText(drink.getS2_drink() + " " + drink.getS2_q());
        if(drink.getS2_drink().isEmpty()) {
            S2.getLayoutParams().height = 0;
        }
        
        TextView S3 = convertView.findViewById(R.id.S3);
        S3.setText(drink.getS3_drink() + " " + drink.getS3_q());
        if(drink.getS3_drink().isEmpty()) {
            S3.getLayoutParams().height = 0;
        }

        
        TextView S4 = convertView.findViewById(R.id.S4);
        S4.setText(drink.getS4_drink() + " " + drink.getS4_q());
        if(drink.getS4_drink().isEmpty()) {
            S4.getLayoutParams().height = 0;
        }

        TextView S5 = convertView.findViewById(R.id.S5);
        S5.setText(drink.getS5_drink() + " " + drink.getS5_q());
        if(drink.getS5_drink().isEmpty()) {
            S5.getLayoutParams().height = 0;
        }

        TextView S6 = convertView.findViewById(R.id.S6);
        S6.setText(drink.getS6_drink() + " " + drink.getS6_q());
        if(drink.getS6_drink().isEmpty()) {
            S6.getLayoutParams().height = 0;
        }

        
        TextView S7 = convertView.findViewById(R.id.S7);
        S7.setText(drink.getS7_drink() + " " + drink.getS7_q());

        if(drink.getS7_drink().isEmpty()) {
            S7.getLayoutParams().height = 0;
        }
        
        TextView S8 = convertView.findViewById(R.id.S8);
        S8.setText(drink.getS8_drink() + " " + drink.getS8_q());
        if(drink.getS8_drink().isEmpty()) {
            S8.getLayoutParams().height = 0;
        }
        
        TextView instruction = convertView.findViewById(R.id.insruction);
        instruction.setText(drink.getInstruction_drink());
        if(drink.getInstruction_drink().isEmpty()) {
            instruction.getLayoutParams().height = 0;
        }


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


        CircleImageView circleImageView = convertView.findViewById(R.id.circleIMG);

        circleImageView.setImageResource(context.getResources().getIdentifier(contacto.getPhoto_drink(),"drawable", context.getPackageName()));
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
