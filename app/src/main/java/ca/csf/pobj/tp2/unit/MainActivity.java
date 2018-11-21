package ca.csf.pobj.tp2.unit;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.util.InputFilterMinMax;
import ca.csf.pobj.tp2.util.NumberUtils;
import ca.csf.pobj.tp2.util.StringUtils;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_INPUT_VALUE = "STATE_INPUT_VALUE";
    private static final String STATE_OUTPUT_VALUE = "STATE_OUTPUT_VALUE";
    private View rootView;
    private EditText inputEditText;
    private TextView outputTextView;
    private RomanNumeral romanNumeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        inputEditText = findViewById(R.id.inputEditText);
        outputTextView = findViewById(R.id.outputTextView);

        romanNumeral = new RomanNumeral();

        EditText et = (EditText) findViewById(R.id.inputEditText);
        et.setFilters(new InputFilter[]{new InputFilterMinMax("1", "4999")});
    }

    public void onConvertButtonClicked(View view) {
        if (isInputBlank()) {
            showEmptyInputMessage();
        } else if (isInvalid()) {
            showInvalidInputMessage();
        } else {
            outputTextView.setText(romanNumeral.convertToRomanNumeral(NumberUtils.toInt(inputEditText.getText().toString())));
        }
    }

    private boolean isInvalid() {
        if (Integer.parseInt(inputEditText.getText().toString()) < RomanNumeral.MIN_VALUE || Integer.parseInt(inputEditText.getText().toString()) > RomanNumeral.MAX_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    private void showEmptyInputMessage() {
        Snackbar.make(rootView, R.string.error_not_a_number, Snackbar.LENGTH_SHORT).show();
    }

    private void showInvalidInputMessage() {
        Snackbar.make(rootView, R.string.error_out_of_range_number, Snackbar.LENGTH_SHORT).show();
    }

    private boolean isInputBlank() {
        return StringUtils.isBlank(inputEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        inputEditText.setText(savedInstanceState.getCharSequence(STATE_INPUT_VALUE));
        outputTextView.setText(savedInstanceState.getCharSequence(STATE_OUTPUT_VALUE));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence(STATE_INPUT_VALUE, inputEditText.getText());
        outState.putCharSequence(STATE_OUTPUT_VALUE, outputTextView.getText());
    }
}
