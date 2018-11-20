package ca.csf.pobj.tp2.unit;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.csf.pobj.tp2.R;
import ca.csf.pobj.tp2.util.NumberUtils;
import ca.csf.pobj.tp2.util.StringUtils;

public class MainActivity extends AppCompatActivity {
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
    }

    public void onConvertButtonClicked(View view) {
        if (isInputBlank()) {
            showEmptyInputMessage();
        } else {
            outputTextView.setText(romanNumeral.convertToRomanNumeral(NumberUtils.toInt(inputEditText.getText().toString())));
        }
    }

    private void showEmptyInputMessage() {
        Snackbar.make(rootView, "Veuillez entrez un nombre", Snackbar.LENGTH_SHORT).show();
    }

    private boolean isInputBlank() {
        return StringUtils.isBlank(inputEditText.getText().toString());
    }
}
