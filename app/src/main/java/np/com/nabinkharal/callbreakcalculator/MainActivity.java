package np.com.nabinkharal.callbreakcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {
    Intent i;
    String[] nabin;
    EditText first_text;
    EditText second_text;
    EditText third_text;
    EditText fourth_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setSupportActionBar((Toolbar) findViewById(R.id.toolbarMain));
        setTitle("CallBreak Calculator");

        FancyButton the_button = (FancyButton) findViewById(R.id.the_button);
        i = new Intent(this, Calculator.class);
        the_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                first_text = (EditText) findViewById(R.id.first_name);
                second_text = (EditText) findViewById(R.id.second_name);
                third_text = (EditText) findViewById(R.id.third_name);
                fourth_text = (EditText) findViewById(R.id.fourth_name);
                nabin = new String[]{first_text.getText().toString(), second_text.getText().toString(), third_text.getText().toString(), fourth_text.getText().toString()};
                i.putExtra("array", nabin);
                startActivity(i);
            }
        });


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
