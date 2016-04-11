package ca.blake.georgian.dollify.dollify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class OptionActivity extends AppCompatActivity {

    // Button Variables
    private Button _instructionsButton;
    private Button _aboutUsButton;
    private Button _backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Create references for Button controls
        this._instructionsButton = (Button) findViewById(R.id.instructionsButton);
        this._aboutUsButton = (Button) findViewById(R.id.aboutUsButton);
        this._backButton = (Button) findViewById(R.id.backButton);

        _instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openInstructionsIntent = new Intent(OptionActivity.this, instructionsActivity.class);
                startActivity(openInstructionsIntent);
            }
        });

        _aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAboutIntent = new Intent(OptionActivity.this, AboutUsActivity.class);
                startActivity(openAboutIntent);
            }
        });

        _backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);


    }

}
