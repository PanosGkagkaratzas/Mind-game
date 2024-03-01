package com.example.game_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class Activity5 extends AppCompatActivity
{
    private Button seen;
    private Button unseen;

    TextView stringTextView;

    public int correct = 0,incorrect = 0;
    public int correct1 = 0, incorrect1 = 0;
    public int correct2 = 0, incorrect2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        List<String> round1 = Arrays.asList(getResources().getStringArray(R.array.round1));
        List<String> round2 = Arrays.asList(getResources().getStringArray(R.array.round2));

        seen = (Button) findViewById(R.id.seen);
        unseen = (Button) findViewById(R.id.unseen);
        stringTextView = (TextView) findViewById(R.id.round);

        stringTextView.post(new Runnable()
        {
            int i = 0, j = 0;

            @Override
            public void run()
            {

                stringTextView.setText(round2.get(i));

                unseen.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        if(round1.contains(round2.get(i)))
                        {
                            incorrect1 +=1;
                        }
                        else
                        {
                            correct1 +=1;
                        }
                        i++;
                        if(i<=29)
                        {
                            stringTextView.setText(round2.get(i));
                        }
                        else
                        {
                            correct = correct1+correct2;
                            incorrect = incorrect1+incorrect2;
                            Intent i = new Intent(Activity5.this, Activity6.class);
                            i.putExtra("Correct",correct);
                            i.putExtra("Incorrect",incorrect);
                            startActivity(i);
                        }
                    }
                });

                seen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(round1.contains(round2.get(i)))
                        {
                            correct2 +=1;
                        }
                        else
                        {
                            incorrect2 +=1;
                        }
                        i++;
                        if(i<=29)
                        {
                            stringTextView.setText(round2.get(i));
                        }
                        else
                        {
                            correct = correct1+correct2;
                            incorrect = incorrect1+incorrect2;
                            Intent i = new Intent(Activity5.this, Activity6.class);
                            i.putExtra("Correct",correct);
                            i.putExtra("Incorrect",incorrect);
                            startActivity(i);
                        }
                    }
                });
            }
        });
    }
}




