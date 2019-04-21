package ur.mi.android.laufapp_starter_projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    private EditText inputKM, inputTime, inputPauses;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputKM = (EditText)findViewById(R.id.input_km);
        inputTime = (EditText)findViewById(R.id.input_time);
        inputPauses = (EditText)findViewById(R.id.input_pauses);

        buttonCalculate = (Button)findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readValues();
            }
        });
    }

    private void readValues() {
        int km = Integer.parseInt(inputKM.getText().toString());
        int time = Integer.parseInt(inputTime.getText().toString());
        int pauses = Integer.parseInt(inputPauses.getText().toString());

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra(Constants.KEY_KM, km);
        i.putExtra(Constants.KEY_TIME, time);
        i.putExtra(Constants.KEY_PAUSES, pauses);

        startActivity(i);
    }


}
