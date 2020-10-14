package pl.swierzy.dynksy;

import android.view.View;
import android.widget.Toast;

public class database_content extends MainActivity{

    public void main_delete_button_void(View V){
        Toast.makeText(getApplicationContext(),"DELETE", Toast.LENGTH_SHORT).show();
        Database_management data_b = new Database_management(this);

        for(int i =0; i<= 1000;i++){
            data_b.delete_drink(i);
        }

    }

}
