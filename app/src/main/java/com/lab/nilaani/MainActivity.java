package com.lab.nilaani;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonAdd,buttonSubstract,buttonMul,buttonDiv,buttonClear,buttonEqual;
    String result,tmp,operator;
    TextView resultTextView,textview_temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initControlListener();
    }

    private void initControlListener() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClicked("9");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_temp.setText("");
                tmp = "";
                operator = "";
                onClearButtonClicked();
            }
        });
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onOperatorButtonClicked("-");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("X");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview_temp.setText("");
                onEqualButtonClicked();
            }
        });

    }

    private void onEqualButtonClicked() {
        Double res = 0.0;
        result = "";
        try {
            Double number = Double.parseDouble(tmp);
            Double number2 = Double.parseDouble(resultTextView.getText().toString());
            switch (operator) {
                case "+":
                    res = number + number2;
                    break;
                case "/":
                    res = number / number2;
                    break;
                case "-":
                    res = number - number2;
                    break;
                case "X":
                    res = number * number2;
                    break;
            }
            result = String.valueOf(new DecimalFormat("##.##").format(res));
            resultTextView.setText(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onOperatorButtonClicked(String operator) {
        tmp = resultTextView.getText().toString();

        textview_temp.setText(resultTextView.getText().toString());

        onClearButtonClicked();
        this.operator = operator;
    }

    private void onClearButtonClicked() {
        result = "";
        resultTextView.setText("");

    }

    private void onNumberButtonClicked(String pos) {
        result = resultTextView.getText().toString();
        result = result + pos;
        resultTextView.setText(result);
    }

    private void initControl() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        buttonSubstract = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEqual = findViewById(R.id.buttonEqual);
        resultTextView = findViewById(R.id.text_view_result);
        textview_temp = findViewById(R.id.text_temp);
    }
}
