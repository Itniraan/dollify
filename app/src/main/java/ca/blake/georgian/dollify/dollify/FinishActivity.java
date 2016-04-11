package ca.blake.georgian.dollify.dollify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class FinishActivity extends AppCompatActivity {

    private ImageView _topImageFinished;
    private ImageView _middleImageFinish;
    private ImageView _bottomImageFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //setContentView(R.layout.content_finish);
        setContentView(R.layout.activity_finish);
        int [] pieceReceived = getIntent().getIntArrayExtra("PIECES");
        this._topImageFinished = (ImageView) findViewById(R.id.topImageFinish);
        this._middleImageFinish = (ImageView) findViewById(R.id.middleImageFinish);
        this._bottomImageFinish = (ImageView) findViewById(R.id.bottomImageFinish);



        System.out.println(pieceReceived[0]);
        System.out.println(pieceReceived[1]);
        System.out.println(pieceReceived[2]);


        _topImageFinished.setImageResource(pieceReceived[0]);
        _middleImageFinish.setImageResource(pieceReceived[1]);
        _bottomImageFinish.setImageResource(pieceReceived[2]);




    }

}
