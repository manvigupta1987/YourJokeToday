package com.example.jokedisplayandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jokeTellingActivity extends AppCompatActivity {

    public final static String JOKE_STRING = "joke";
    TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_telling);
        mJokeTextView = (TextView)findViewById(R.id.joke_textview);

        Intent intent = getIntent();
        if(intent.hasExtra(JOKE_STRING)){
            String joke = intent.getStringExtra(JOKE_STRING);
            mJokeTextView.setText(joke);
        }
    }
}
