package com.example.numbertoroman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numberInput = findViewById(R.id.numberInput);
        Button convertButton = findViewById(R.id.convertButton);
        TextView romanOutput = findViewById(R.id.romanOutput);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberStr = numberInput.getText().toString();

                if (!numberStr.isEmpty()) {
                    int number = Integer.parseInt(numberStr);
                    if (number > 0 && number <= 3999) {
                        String roman = convertToRoman(number);
                        romanOutput.setText("Roman Numeral: " + roman);
                    } else {
                        romanOutput.setText("Enter a number between 1 and 3999");
                    }
                } else {
                    romanOutput.setText("Please enter a valid number");
                }
            }
        });
    }

    // Function to convert a number to Roman numeral
    private String convertToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }
}
