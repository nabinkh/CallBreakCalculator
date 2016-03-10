package np.com.nabinkharal.callbreakcalculator;


import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class Calculator extends AppCompatActivity {

    TextView name1, name2, name3, name4;
    String[] the_names;
    View final_score;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Bundle array = getIntent().getExtras();
        the_names = array.getStringArray("array");
        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);

        name1.setText(the_names[0]);
        name2.setText(the_names[1]);
        name3.setText(the_names[2]);
        name4.setText(the_names[3]);

        final_score = findViewById(R.id.final_score);

        TextView final_score1 = (TextView) final_score.findViewById(R.id.bid1);
        TextView final_score2 = (TextView) final_score.findViewById(R.id.bid2);
        TextView final_score3 = (TextView) final_score.findViewById(R.id.bid3);
        TextView final_score4 = (TextView) final_score.findViewById(R.id.bid4);

        final_score1.setText("00");
        final_score2.setText("00");
        final_score3.setText("00");
        final_score4.setText("00");

        FancyButton bid_button1 = (FancyButton) findViewById(R.id.bid_button1);
        bid_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBidDialog bidDialog = new DisplayBidDialog(the_names, R.id.bid_button1);
                bidDialog.show(getSupportFragmentManager(), "first");
            }
        });

        FancyButton bid_button2 = (FancyButton) findViewById(R.id.bid_button2);
        bid_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBidDialog bidDialog = new DisplayBidDialog(the_names, R.id.bid_button2);
                bidDialog.show(getSupportFragmentManager(), "first");
            }
        });

        FancyButton bid_button3 = (FancyButton) findViewById(R.id.bid_button3);
        bid_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBidDialog bidDialog = new DisplayBidDialog(the_names, R.id.bid_button3);
                bidDialog.show(getSupportFragmentManager(), "first");
            }
        });
        FancyButton bid_button4 = (FancyButton) findViewById(R.id.bid_button4);
        bid_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBidDialog bidDialog = new DisplayBidDialog(the_names, R.id.bid_button4);
                bidDialog.show(getSupportFragmentManager(), "first");
            }
        });
        FancyButton bid_button5 = (FancyButton) findViewById(R.id.bid_button5);
        bid_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayBidDialog bidDialog = new DisplayBidDialog(the_names, R.id.bid_button5);
                bidDialog.show(getSupportFragmentManager(), "first");
            }
        });
        FancyButton confirm_button1 = (FancyButton) findViewById(R.id.confirm_button1);
        confirm_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayConfirmDialog confirmDialog = new DisplayConfirmDialog(the_names, R.id.confirm_button1);
                confirmDialog.show(getSupportFragmentManager(), "second");
            }
        });
        FancyButton confirm_button2 = (FancyButton) findViewById(R.id.confirm_button2);
        confirm_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayConfirmDialog confirmDialog = new DisplayConfirmDialog(the_names, R.id.confirm_button2);
                confirmDialog.show(getSupportFragmentManager(), "second");
            }
        });
        FancyButton confirm_button3 = (FancyButton) findViewById(R.id.confirm_button3);
        confirm_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayConfirmDialog confirmDialog = new DisplayConfirmDialog(the_names, R.id.confirm_button3);
                confirmDialog.show(getSupportFragmentManager(), "second");
            }
        });
        FancyButton confirm_button4 = (FancyButton) findViewById(R.id.confirm_button4);
        confirm_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayConfirmDialog confirmDialog = new DisplayConfirmDialog(the_names, R.id.confirm_button4);
                confirmDialog.show(getSupportFragmentManager(), "second");
            }
        });
        FancyButton confirm_button5 = (FancyButton) findViewById(R.id.confirm_button5);
        confirm_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayConfirmDialog confirmDialog = new DisplayConfirmDialog(the_names, R.id.confirm_button5);
                confirmDialog.show(getSupportFragmentManager(), "second");
            }
        });
        FancyButton confirm_final = (FancyButton) findViewById(R.id.confirm_final);
        confirm_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View finalView = findViewById(R.id.full_final);
                TextView finalView1 = (TextView) finalView.findViewById(R.id.bid1);
                TextView finalView2 = (TextView) finalView.findViewById(R.id.bid1);
                TextView finalView3 = (TextView) finalView.findViewById(R.id.bid1);
                TextView finalView4 = (TextView) finalView.findViewById(R.id.bid1);
                Float[] array_final;
                array_final = new Float[]{Float.valueOf(finalView1.getText().toString()), Float.valueOf(finalView2.getText().toString()),
                        Float.valueOf(finalView3.getText().toString()), Float.valueOf(finalView4.getText().toString())};
                ArithmeticFunctions caller = new ArithmeticFunctions();
                Float largest = caller.getLargest(array_final);

                if (largest == Float.valueOf(finalView1.getText().toString())) {
                    Toast.makeText(getBaseContext(), "The winner is " + the_names[0], Toast.LENGTH_LONG).show();
                } else {
                    if (largest == Float.valueOf(finalView2.getText().toString())) {
                        Toast.makeText(getBaseContext(), "The winner is " + the_names[1], Toast.LENGTH_LONG).show();
                    } else {
                        if (largest == Float.valueOf(finalView3.getText().toString())) {
                            Toast.makeText(getBaseContext(), "The winner is " + the_names[2], Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(), "The winner is " + the_names[3], Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
}


