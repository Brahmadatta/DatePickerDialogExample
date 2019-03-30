package escapadetechnologies.com.datepickerdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker picker,picker2;
    Button btnGet,openDialog;
    TextView tvw,resultDate;
    String date1,date2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDialog = findViewById(R.id.openDialog);
        resultDate = findViewById(R.id.resultDate);

        //tvw=(TextView)findViewById(R.id.textView1);
        //picker=(DatePicker)findViewById(R.id.datePicker1);
        //btnGet=(Button)findViewById(R.id.button1);
        /*btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
            }
        });*/

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showCalenderDialog();

            }
        });
    }

    private void showCalenderDialog() {

        LayoutInflater layoutInflater = getLayoutInflater();
        View alertLayout = layoutInflater.inflate(R.layout.custom_calender_layout_from,null);
        Button next = alertLayout.findViewById(R.id.next);
        picker=(DatePicker)alertLayout.findViewById(R.id.datePicker1);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        final AlertDialog alertDialog = alert.create();
        alertDialog.show();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ""+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear(), Toast.LENGTH_SHORT).show();
                date1 = picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear();
                showCalenderToDialog();
                alertDialog.dismiss();

            }
        });


    }

    private void showCalenderToDialog() {

        LayoutInflater layoutInflater = getLayoutInflater();
        View alertLayout = layoutInflater.inflate(R.layout.custom_calender_to,null);
        Button submit = alertLayout.findViewById(R.id.submit);
        picker2 = alertLayout.findViewById(R.id.datePicker2);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setView(alertLayout);
        alert.setCancelable(false);
        final AlertDialog alertDialog = alert.create();
        alertDialog.show();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ""+ picker2.getDayOfMonth()+"/"+ (picker2.getMonth() + 1)+"/"+picker2.getYear(), Toast.LENGTH_SHORT).show();
                date2 = picker2.getDayOfMonth()+"/"+ (picker2.getMonth() + 1)+"/"+picker2.getYear();
                resultDate.setText(date1 + "\n" + date2);
                alertDialog.dismiss();
            }
        });


    }
}
