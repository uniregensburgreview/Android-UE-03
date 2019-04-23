package ur.mi.android.laufapp_starter_projekt;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    private TextView resultPace, resultKCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // back-button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultPace = (TextView) findViewById(R.id.text_result_pace);
        resultKCal = (TextView) findViewById(R.id.text_result_kcal);

        getExtras();
    }

    private void getExtras() {
        int km = getIntent().getExtras().getInt(Constants.KEY_KM);
        int time = getIntent().getExtras().getInt(Constants.KEY_TIME);
        int pauses = getIntent().getExtras().getInt(Constants.KEY_PAUSES);

        calculateResult(km, time, pauses);
    }

    private void calculateResult(int km, int time, int pauses) {

        Calculator calc = new Calculator();

        calc.setValues(km, time, pauses);

        String pace = formatPace(calc.calculatePace());
        resultPace.setText(pace + " " + getText(R.string.text_result_pace_suffix));
        resultKCal.setText(calc.calculateKcal() + " " + getText(R.string.text_result_kcal_suffix));
    }

    private String formatPace(double pace) {
        int min = (int) pace;
        pace -= min;
        int sec = (int) (60*pace);
        return min+":"+sec;
    }

    // back-button functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
