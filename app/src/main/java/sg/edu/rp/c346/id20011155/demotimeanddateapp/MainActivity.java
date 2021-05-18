package sg.edu.rp.c346.id20011155.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        btnDisplayDate = findViewById(R.id.buttonDate);
        btnDisplayTime = findViewById(R.id.buttonTime);
        tvDisplay = findViewById(R.id.textView3);
        btnReset = findViewById(R.id.reset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Time is ";
                int timeHour = tp.getCurrentHour();
                int timeMin = tp.getCurrentMinute();

                if (timeMin < 11) {
                    text += timeHour + ":0" + timeMin;
                } else {
                    text += timeHour + ":" + timeMin;
                }
                tvDisplay.setText(text);
            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Date is ";

                int day = dp.getDayOfMonth();
                int mth = dp.getMonth()+1;
                int year = dp.getYear();
                text += day + "/" + mth + "/" + year;
                tvDisplay.setText(text);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2021, 4, 18);
            }
        });

    }
}