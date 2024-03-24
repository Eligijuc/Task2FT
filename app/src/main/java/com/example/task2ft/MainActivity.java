package com.example.task2ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Spinner spCountopt;
    private EditText edMaintxt;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edMaintxt = (EditText) findViewById(R.id.edMaintxt);
        this.tvResult = (TextView) findViewById(R.id.tvResult);
        this.spCountopt = (Spinner) findViewById(R.id.spCountopt);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCountopt.setAdapter(adapter);
    }

    public void btnCountomClick(View view) {
        String userInput = this.edMaintxt.getText().toString();
        String selectedOption = this.spCountopt.getSelectedItem().toString();

        if (userInput.isEmpty()) {
            // Display "Not implemented" if user input is empty
            Toast.makeText(getApplicationContext(), "Enter a word or a phrase", Toast.LENGTH_LONG).show();
            return; // Exit the method
        }

        int result;
        if (selectedOption.equalsIgnoreCase(getResources().getString(R.string.symbols_selection))) {
            result = TxtCounter.countLetters(userInput);
        } else if (selectedOption.equalsIgnoreCase(getResources().getString(R.string.word_selection))) {
            result = TxtCounter.countWords(userInput);
        } else {
            Toast.makeText(getApplicationContext(), "Not implemented", Toast.LENGTH_LONG).show();
            return;
        }

        this.tvResult.setText(String.valueOf(result));

    }

}
