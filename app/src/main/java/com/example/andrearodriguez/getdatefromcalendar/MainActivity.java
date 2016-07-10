package com.example.andrearodriguez.getdatefromcalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txtDate;
    int year_x,month_x,day_x;
    static final int DILOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (TextView)findViewById(R.id.txtDate);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogonButtonClick();
    }

    public void showDialogonButtonClick(){
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DILOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DILOG_ID)
            return new DatePickerDialog(this, dpckerlistener, year_x,month_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpckerlistener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;

            Toast.makeText(MainActivity.this,year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
            txtDate.setText(year_x + "/" + month_x + "/" + day_x);

        }
    };
}
