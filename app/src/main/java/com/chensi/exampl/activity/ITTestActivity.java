package com.chensi.exampl.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chensi.exampl.R;

public class ITTestActivity extends Activity {

    RadioGroup rgSubject1;
    RadioGroup rgSubject2;
    RadioGroup rgSubject3;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ittest);
        findView();
        setListener();
    }

    private void findView() {
        rgSubject1 = (RadioGroup) findViewById(R.id.rgSubject1);
        rgSubject2 = (RadioGroup) findViewById(R.id.rgSubject2);
        rgSubject3 = (RadioGroup) findViewById(R.id.rgSubject3);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    private void setListener() {
        rgSubject1.setOnCheckedChangeListener(myListener);
        rgSubject2.setOnCheckedChangeListener(myListener);
        rgSubject3.setOnCheckedChangeListener(myListener);
    }

    RadioGroup.OnCheckedChangeListener myListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            System.out.println("HAHA: change...");
            boolean allChecked = rgSubject1.getCheckedRadioButtonId() != -1
                    && rgSubject2.getCheckedRadioButtonId() != -1
                    && rgSubject3.getCheckedRadioButtonId() != -1;
            if (allChecked) {
                int score = 0;
                switch (rgSubject1.getCheckedRadioButtonId()) {
                    case R.id.rbSubject1_opt1:
                        score += 3;
                        break;
                    case R.id.rbSubject1_opt2:
                        score += 2;
                        break;
                    case R.id.rbSubject1_opt3:
                        score += 1;
                        break;
                }
                switch (rgSubject2.getCheckedRadioButtonId()) {
                    case R.id.rbSubject2_opt1:
                        score += 3;
                        break;
                    case R.id.rbSubject2_opt2:
                        score += 2;
                        break;
                    case R.id.rbSubject2_opt3:
                        score += 1;
                        break;
                }
                switch (rgSubject3.getCheckedRadioButtonId()) {
                    case R.id.rbSubject3_opt1:
                        score += 3;
                        break;
                    case R.id.rbSubject3_opt2:
                        score += 2;
                        break;
                    case R.id.rbSubject3_opt3:
                        score += 1;
                        break;
                }
                if( score > 8 ) {
                    tvResult.setText("您是电脑达人！");
                } else if (score >= 4) {
                    tvResult.setText("您是一般电脑用户！");
                } else {
                    tvResult.setText("您需要提高电脑知识！");
                }
            }
        }
    };
}
