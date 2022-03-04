package it.skinjobs.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    Boolean dotMode = false;
    Integer decimals = 0;
    String currentOp;
    Boolean reset;
    double firstValue = 0.0f;
    double value;
    double divider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.resultView = this.findViewById(R.id.resultTextView);
        dotMode = false;
        reset = false;
    }

    public void clickListener(View v) {
        Button b = (Button)v;
        if (Pattern.matches("\\d+", b.getText())) {
            if (reset == true) {
                value = 0.0f;
                reset = false;
            }
                if (dotMode) {
                    decimals++;
                    divider = Math.pow(10, decimals);
                    value = value + Float.parseFloat(b.getText().toString()) / divider;
                } else {
                    value = value * 10 + Float.parseFloat(b.getText().toString());
                }

        } else {
            switch (b.getText().toString()) {
                case "AC": {
                    value = 0.0f;
                    dotMode = false;
                    decimals = 0;
                    break;
                }
                case "+/-": {
                    value = -1 * value;
                    break;
                }
                case "%": {
                    value = value / 100;
                    break;
                }
                case ".": {
                    dotMode = true;
                    break;
                }
                case "=": {
                    if (!currentOp.equals("")) {
                        switch (currentOp) {
                            case "X": {
                                value = firstValue * value;
                                break;
                            }
                            case "/": {
                                value = firstValue / value;
                                break;
                            }
                            case "+": {
                                value = firstValue + value;
                                break;
                            }
                            case "-": {
                                value = firstValue - value;
                                break;
                            }
                        }
                    }
                    currentOp = "";
                    break;
                }
                default: {
                    currentOp = b.getText().toString();
                    firstValue = value;
                    reset = true;
                }
            }
        }


            if (value == Math.floor(value)) {
                Integer result = Math.toIntExact((long)value);
                resultView.setText(result.toString());
            } else {
                value = Math.round(value * divider);
                value = value / divider;
                resultView.setText(Double.toString(value));
            }

    }
}