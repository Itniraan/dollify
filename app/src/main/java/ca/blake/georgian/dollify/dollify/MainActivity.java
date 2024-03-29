package ca.blake.georgian.dollify.dollify;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button _startButton;
    private Button _instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create references for Button controls
        this._startButton = (Button) findViewById(R.id.startButton);
        this._instructionsButton = (Button) findViewById(R.id.instructionsButton);

        _startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenStartScreen();
            }
        });

        _instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenInstructionsScreen();
            }
        });

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

    public void OpenInstructionsScreen() {
        Intent openInstructionsIntent = new Intent(MainActivity.this, instructionsActivity.class);
        startActivity(openInstructionsIntent);
    }

    public void OpenStartScreen() {
        Intent openStartIntent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(openStartIntent);
    }

}
