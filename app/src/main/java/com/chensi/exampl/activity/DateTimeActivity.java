package com.chensi.exampl.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.chensi.exampl.R;

public class DateTimeActivity extends Activity {
    private TextView tvDate;
    private DatePicker dp;
    private TextView tvTime;
    private TimePicker tp;
    private TextView tvDateTime;
    private Button btnDate;
    private Button btnTime;
    private final int DATEDIALOG = 0;
    private final int TIMEDIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        findView();
        setListener();
    }

    private void findView() {
        tvDate = (TextView) findViewById(R.id.tvTime);
        dp = (DatePicker) findViewById(R.id.dp);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tp = (TimePicker) findViewById(R.id.tp);
        tvDateTime = (TextView) findViewById(R.id.tvDateTime);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnTime = (Button) findViewById(R.id.btnTime);
    }

    private void setListener() {
        dp.init(1990, 10, 12, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tvDate.setText("year: " + dp.getYear() + "\nmonth: " + dp.getMonth() + "\nday: " + dp.getDayOfMonth());
            }
        });
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText(hourOfDay + ":" + minute);
            }
        });
        btnDate.setOnClickListener(myListener);
        btnTime.setOnClickListener(myListener);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnDate:
                    showDialog(DATEDIALOG);
//                    showDialog和createDialog的替代：http://www.android100.org/html/201503/19/128650.html
                    break;
                case R.id.btnTime:
                    showDialog(TIMEDIALOG);
                    break;
            }
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATEDIALOG:
                DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDateTime.setText("year: " + year + "\nmonth: " + monthOfYear + "\nday: " + dayOfMonth);
                    }
                }, 1990, 10, 1);
                return dpd;
            case TIMEDIALOG:
                TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDateTime.setText(tvDateTime.getText().toString() + "\nhour: " + hourOfDay + "\nminute: " + minute);
                    }
                }, 12, 0, true);
                return tpd;
        }
        return super.onCreateDialog(id);
    }
}
