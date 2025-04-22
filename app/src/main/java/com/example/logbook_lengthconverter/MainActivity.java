package com.example.logbook_lengthconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText inputValueEditText;
    private Spinner fromUnitSpinner;
    private Spinner toUnitSpinner;
    private Button convertButton;
    private TextView resultTextView;

    private final Map<String, Double> lengthUnits = new HashMap<String, Double>() {{
        put("Metre", 1.0);
        put("Millimetre", 0.001);
        put("Mile", 1609.34);
        put("Foot", 0.3048);
    }};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        inputValueEditText = findViewById(R.id.inputValueEditText);
        fromUnitSpinner = findViewById(R.id.fromUnitSpinner);
        toUnitSpinner = findViewById(R.id.toUnitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set up Spinners
        setupSpinners();

        // Set up button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });
    }

    private void setupSpinners() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromUnitSpinner.setAdapter(adapter);
        toUnitSpinner.setAdapter(adapter);

        // Set default selections (optional)
        fromUnitSpinner.setSelection(0); // Metre
        toUnitSpinner.setSelection(0); // Metre
    }

    private void convertLength() {
        String inputValue = inputValueEditText.getText().toString();

        if (TextUtils.isEmpty(inputValue)) {
            inputValueEditText.setError("Please enter a value");
            return;
        }

        String fromUnit = fromUnitSpinner.getSelectedItem().toString();
        String toUnit = toUnitSpinner.getSelectedItem().toString();

        Double value = null;
        try {
            value = Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            inputValueEditText.setError("Invalid number");
            return;
        }

        double result = convert(value, fromUnit, toUnit);
        String formattedResult = new DecimalFormat("#.####").format(result);
        resultTextView.setText("Result: " + formattedResult + " " + toUnit);
    }

    private double convert(double value, String fromUnit, String toUnit) {
        double valueInMetres = value * (lengthUnits.getOrDefault(fromUnit, 1.0));
        return valueInMetres / (lengthUnits.getOrDefault(toUnit, 1.0));
    }
}