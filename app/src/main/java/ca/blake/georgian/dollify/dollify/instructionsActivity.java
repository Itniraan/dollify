package ca.blake.georgian.dollify.dollify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class instructionsActivity extends AppCompatActivity {

    private Button _backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_instructions);

        this._backButton = (Button) findViewById(R.id.backButton);

        //This doesn't work yet
        _backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

    }

    public void OpenPreviousScreen() {
        Intent openPreviousIntent = new Intent(instructionsActivity.this, StartActivity.class);
        startActivity(openPreviousIntent);

    }

}
