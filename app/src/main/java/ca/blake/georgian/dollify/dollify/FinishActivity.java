package ca.blake.georgian.dollify.dollify;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinishActivity extends AppCompatActivity {

    private ImageView _topImageFinished;
    private ImageView _middleImageFinish;
    private ImageView _bottomImageFinish;

    private Button _saveImageButton;
    private Button _resetButton;

    private TextView _saveCompleteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_finish);

        // Array from StartActivity, with selected clothing
        int [] pieceReceived = getIntent().getIntArrayExtra("PIECES");

        // ImageView init
        this._topImageFinished = (ImageView) findViewById(R.id.topImageFinish);
        this._middleImageFinish = (ImageView) findViewById(R.id.middleImageFinish);
        this._bottomImageFinish = (ImageView) findViewById(R.id.bottomImageFinish);

        // Button init
        this._saveImageButton = (Button) findViewById(R.id.saveImageButton);
        this._resetButton = (Button) findViewById(R.id.resetButton);

        // TextView init
        this._saveCompleteText = (TextView) findViewById(R.id.saveCompleteTextView);

        _topImageFinished.setImageResource(pieceReceived[0]);
        _middleImageFinish.setImageResource(pieceReceived[1]);
        _bottomImageFinish.setImageResource(pieceReceived[2]);

        _saveImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _saveImageButton.setVisibility(View.INVISIBLE);
                _resetButton.setVisibility(View.INVISIBLE);
                //Grab timestamp for unique picture filename
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Take screenshot of device screen, now that buttons are invisible
                Bitmap screenShot;
                View screenShotView = findViewById(R.id.finishRelativeLayout);// get ur root view id
                screenShotView.setDrawingCacheEnabled(true);
                screenShot = Bitmap.createBitmap(screenShotView.getDrawingCache());
                screenShotView.setDrawingCacheEnabled(false);

                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                screenShot.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                // Storing in Pictures directory
                File f = new File(Environment.getExternalStorageDirectory() + "/Pictures"
                        + File.separator + timeStamp + "_dollify.jpg");
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileOutputStream fileOut = null;
                try {
                    fileOut = new FileOutputStream(f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fileOut.write(bytes.toByteArray());
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                _resetButton.setVisibility(View.VISIBLE);
                _saveCompleteText.setVisibility(View.VISIBLE);

                // This will be implemented later, gallery integration

                /**try {
                 MediaStore.Images.Media.insertImage(getContentResolver(), Environment.getExternalStorageDirectory() +
                 File.separator + "Pictures"
                 + File.separator + timeStamp + "_dollify.jpg", timeStamp + "_dollify.jpg", timeStamp + "_dollify.jpg");
                 } catch (FileNotFoundException e) {
                 e.printStackTrace();
                 }**/


            }
        });

        _resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openStartIntent = new Intent(FinishActivity.this, StartActivity.class);
                startActivity(openStartIntent);
                finish();
            }
        });

    }

}
