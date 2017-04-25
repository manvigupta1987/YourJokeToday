package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ProgressBar mSpinner;
    private TextView mtextView;
    private Button mButton;
    public static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"onCreate" );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (ProgressBar)findViewById(R.id.progressBar);
        mtextView = (TextView) findViewById(R.id.instructions_text_view);
        mButton = (Button) findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();
        showTextViewNButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        showProgressBar();
        new EndpointsAsyncTask().execute(this);
    }

    private void showProgressBar(){
        mSpinner.setVisibility(View.VISIBLE);
        mtextView.setVisibility(View.INVISIBLE);
        mButton.setVisibility(View.INVISIBLE);
    }

    private void showTextViewNButton(){
        mSpinner.setVisibility(View.GONE);
        mtextView.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.VISIBLE);
    }
}
