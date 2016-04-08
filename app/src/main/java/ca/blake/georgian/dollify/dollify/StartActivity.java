package ca.blake.georgian.dollify.dollify;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    // Button Variables
    private Button _leftButton01;
    private Button _leftButton02;
    private Button _leftButton03;
    private Button _rightButton01;
    private Button _rightButton02;
    private Button _rightButton03;
    private Button _nextButton;

    private ImageView _topImage;
    private ImageView _middleImage;
    private ImageView _bottomImage;

    private static final int TOP_LIMIT = 2, MIDDLE_LIMIT = 2, BOTTOM_LIMIT = 2;

    // Arrays of Drawables
    private int[] topList = new int[]{R.drawable.ballc03, R.drawable.beanie04};
    private int[] middleList = new int[]{R.drawable.tank03, R.drawable.tank04};
    private int[] bottomList = new int[]{R.drawable.boxers03, R.drawable.boxers05};

    private int top = 0, middle = 0, bottom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Create references for Button controls
        this._leftButton01 = (Button) findViewById(R.id.leftArrowButton1);
        this._leftButton02 = (Button) findViewById(R.id.leftArrowButton2);
        this._leftButton03 = (Button) findViewById(R.id.leftArrowButton3);
        this._rightButton01 = (Button) findViewById(R.id.rightArrowButton1);
        this._rightButton02 = (Button) findViewById(R.id.rightArrowButton2);
        this._rightButton03 = (Button) findViewById(R.id.rightArrowButton3);
        this._nextButton = (Button) findViewById(R.id.nextButton);

        this._topImage = (ImageView) findViewById(R.id.topImageView);
        this._middleImage = (ImageView) findViewById(R.id.middleImageView);
        this._bottomImage = (ImageView) findViewById(R.id.bottomImageView);


        _leftButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (top == 0) {
                    _topImage.setImageResource(topList[topList.length - 1]);
                    top = topList.length - 1;
                } else {
                    _topImage.setImageResource(topList[top - 1]);
                    top--;
                }
            }
        });

        _rightButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (top == TOP_LIMIT) {
                    _topImage.setImageResource(topList[0]);
                    top = 0;
                    System.out.println(top);
                } else {
                    if (top == 0) {
                        top = 1;
                    }
                    _topImage.setImageResource(topList[top]);
                    top++;
                }
            }
        });

        _leftButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (middle == 0) {
                    _middleImage.setImageResource(middleList[middleList.length - 1]);
                    middle = middleList.length - 1;
                } else {
                    _middleImage.setImageResource(middleList[middle - 1]);
                    middle--;
                }
            }
        });

        _rightButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (middle == MIDDLE_LIMIT) {
                    _middleImage.setImageResource(middleList[0]);
                    middle = 0;
                } else {
                    _middleImage.setImageResource(middleList[middle]);
                    middle++;
                }
            }
        });

        _leftButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottom == 0) {
                    _bottomImage.setImageResource(bottomList[bottomList.length - 1]);
                    bottom = bottomList.length - 1;
                } else {
                    _bottomImage.setImageResource(bottomList[bottom - 1]);
                    bottom--;
                }
            }
        });

        _rightButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottom == BOTTOM_LIMIT) {
                    _bottomImage.setImageResource(bottomList[0]);
                    bottom = 0;
                } else {
                    _bottomImage.setImageResource(bottomList[bottom]);
                    bottom++;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
