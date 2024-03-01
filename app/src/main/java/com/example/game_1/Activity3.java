package com.example.game_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class Activity3 extends AppCompatActivity {
    TextView stringTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        List<String> round1 = Arrays.asList(getResources().getStringArray(R.array.round1));

        stringTextView = (TextView) findViewById(R.id.round1);

        stringTextView.post(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                if(i>12)
                {
                    Intent intent = new Intent(Activity3.this, Activity4.class);
                    startActivity(intent);
                }
                else
                {
                    stringTextView.setText(round1.get(i));
                    i++;
                    stringTextView.postDelayed(this, 2000);
                }
            }
        });
    }
}
