package ca.blake.georgian.dollify.dollify;

import android.content.Intent;
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
    private Button _leftButton04;
    private Button _rightButton01;
    private Button _rightButton02;
    private Button _rightButton03;
    private Button _rightButton04;
    private Button _nextButton;

    private ImageView _topImage;
    private ImageView _middleImage;
    private ImageView _bottomImage;
    private ImageView _bodyImage;

    // Constant variables with upper limit of each item
    private static final int TOP_LIMIT = 42, MIDDLE_LIMIT = 38, BOTTOM_LIMIT = 31, SKIN_LIMIT = 4;

    // Arrays of Drawables for each section
    private int[] skinList = new int[]{R.drawable.body01, R.drawable.body02, R.drawable.body03, R.drawable.body04};
    private int[] topList = new int[]{R.drawable.ballc01, R.drawable.ballc02, R.drawable.ballc03, R.drawable.ballc04,
            R.drawable.ballc05, R.drawable.ballc06, R.drawable.ballc07, R.drawable.beanie01, R.drawable.beanie02,
            R.drawable.beanie03, R.drawable.beanie04, R.drawable.beanie05, R.drawable.beanie06, R.drawable.beanie07,
            R.drawable.pigtails01, R.drawable.pigtails02, R.drawable.pigtails03, R.drawable.pigtails04, R.drawable.pigtails05,
            R.drawable.pigtails06, R.drawable.pigtails07, R.drawable.prin01, R.drawable.prin02, R.drawable.prin03, R.drawable.prin04,
            R.drawable.prin05, R.drawable.prin06, R.drawable.prin07, R.drawable.short01, R.drawable.short02, R.drawable.short03,
            R.drawable.short04, R.drawable.short05, R.drawable.short06, R.drawable.short07, R.drawable.tom01, R.drawable.tom02,
            R.drawable.tom03, R.drawable.tom04, R.drawable.tom05, R.drawable.tom06, R.drawable.tom07};
    private int[] middleList = new int[]{R.drawable.hoodie01, R.drawable.hoodie02, R.drawable.hoodie03,
            R.drawable.hoodie04, R.drawable.hoodie05, R.drawable.hoodie06, R.drawable.longsweater01,
            R.drawable.longsweater02, R.drawable.longsweater03, R.drawable.longsweater04, R.drawable.longsweater05,
            R.drawable.opensweater01, R.drawable.opensweater02, R.drawable.opensweater03, R.drawable.opensweater04,
            R.drawable.opensweater05, R.drawable.polo01, R.drawable.polo02, R.drawable.polo03,
            R.drawable.polo04, R.drawable.polo05, R.drawable.polo06, R.drawable.stripped01, R.drawable.stripped02,
            R.drawable.stripped03, R.drawable.stripped04, R.drawable.stripped05, R.drawable.stripped06, R.drawable.tank01,
            R.drawable.tank02, R.drawable.tank03, R.drawable.tank04, R.drawable.tank05, R.drawable.vest01, R.drawable.vest02,
            R.drawable.vest03, R.drawable.vest04, R.drawable.vest05};
    private int[] bottomList = new int[]{R.drawable.boxers, R.drawable.boxers02, R.drawable.boxers03, R.drawable.boxers04,
            R.drawable.boxers05, R.drawable.boxers06, R.drawable.capri01, R.drawable.capri02, R.drawable.capri03,
            R.drawable.capri04, R.drawable.capri05, R.drawable.jeans01, R.drawable.jeans02, R.drawable.jeans03,
            R.drawable.jeans04, R.drawable.jeans05, R.drawable.shorts01, R.drawable.shorts02, R.drawable.shorts03,
            R.drawable.shorts04, R.drawable.shorts05, R.drawable.skirt01, R.drawable.skirt02, R.drawable.skirt03,
            R.drawable.skirt04, R.drawable.skirt05, R.drawable.tights01, R.drawable.tights02, R.drawable.tights03,
            R.drawable.tights04, R.drawable.tights05};

    private int top = 0, middle = 0, bottom = 0, skin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Create references for Button controls
        this._leftButton01 = (Button) findViewById(R.id.leftArrowButton1);
        this._leftButton02 = (Button) findViewById(R.id.leftArrowButton2);
        this._leftButton03 = (Button) findViewById(R.id.leftArrowButton3);
        this._leftButton04 = (Button) findViewById(R.id.leftArrowButton4);
        this._rightButton01 = (Button) findViewById(R.id.rightArrowButton1);
        this._rightButton02 = (Button) findViewById(R.id.rightArrowButton2);
        this._rightButton03 = (Button) findViewById(R.id.rightArrowButton3);
        this._rightButton04 = (Button) findViewById(R.id.rightArrowButton4);
        this._nextButton = (Button) findViewById(R.id.nextButton);

        // Create references for ImageViews
        this._topImage = (ImageView) findViewById(R.id.topImageFinish);
        this._middleImage = (ImageView) findViewById(R.id.middleImageFinish);
        this._bottomImage = (ImageView) findViewById(R.id.bottomImageFinish);
        this._bodyImage = (ImageView) findViewById(R.id.bodyImageView);

        // Set default ImageResource
        try {
            _topImage.setImageResource(topList[0]);
            _middleImage.setImageResource(middleList[0]);
            _bottomImage.setImageResource(bottomList[0]);
            _bodyImage.setImageResource(skinList[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }


        _leftButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (top == 0) {
                        _topImage.setImageResource(topList[topList.length - 1]);
                        top = topList.length - 1;
                    } else {
                        _topImage.setImageResource(topList[top - 1]);
                        top--;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _rightButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (top == TOP_LIMIT - 1) {
                        _topImage.setImageResource(topList[0]);
                        top = 0;
                        System.out.println(top);
                    } else {
                        if (top == 0) {
                            top = 1;
                        }
                        top++;
                        _topImage.setImageResource(topList[top]);

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _leftButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (middle == 0) {
                        _middleImage.setImageResource(middleList[middleList.length - 1]);
                        middle = middleList.length - 1;
                    } else {
                        _middleImage.setImageResource(middleList[middle - 1]);
                        middle--;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _rightButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (middle == MIDDLE_LIMIT - 1) {
                        _middleImage.setImageResource(middleList[0]);
                        middle = 0;
                    } else {
                        middle++;
                        _middleImage.setImageResource(middleList[middle]);

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _leftButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (bottom == 0) {
                        _bottomImage.setImageResource(bottomList[bottomList.length - 1]);
                        bottom = bottomList.length - 1;
                    } else {
                        _bottomImage.setImageResource(bottomList[bottom - 1]);
                        bottom--;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _rightButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (bottom == BOTTOM_LIMIT - 1) {
                        _bottomImage.setImageResource(bottomList[0]);
                        bottom = 0;
                    } else {
                        bottom++;
                        _bottomImage.setImageResource(bottomList[bottom]);

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _leftButton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (skin == 0) {
                        _bodyImage.setImageResource(skinList[skinList.length - 1]);
                        skin = skinList.length - 1;
                    } else {
                        _bodyImage.setImageResource(skinList[skin - 1]);
                        skin--;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _rightButton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (skin == SKIN_LIMIT - 1) {
                        _bodyImage.setImageResource(skinList[0]);
                        skin = 0;
                    } else {
                        skin++;
                        _bodyImage.setImageResource(skinList[skin]);

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        });

        _nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenFinishScreen();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openOptionIntent = new Intent(StartActivity.this, OptionActivity.class);
                startActivity(openOptionIntent);
            }
        });
    }

    public void OpenFinishScreen() {
        int[] set = new int[] {topList[top], middleList[middle], bottomList[bottom], skinList[skin]};
        Intent openFinishIntent = new Intent(StartActivity.this, FinishActivity.class);
        openFinishIntent.putExtra("PIECES", set);
        startActivity(openFinishIntent);
        finish();
    }

}
