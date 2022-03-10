package com.simple.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
    ImageView btn_dot,btn_equals,btn_ac,btn_plus,btn_minus,btn_multiple,btn_divide,btn_bracket_start,btn_bracket_end;
    TextView inputText,outputText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here numbers are called
        btn_0 = findViewById(R.id.button_0);
        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);

        //here operators are called
        btn_dot = findViewById(R.id.button_dot);
        btn_plus = findViewById(R.id.button_plus);
        btn_minus = findViewById(R.id.button_minus);
        btn_multiple = findViewById(R.id.button_multiplication);
        btn_divide = findViewById(R.id.button_division);
        btn_equals = findViewById(R.id.button_equals);
        btn_ac = findViewById(R.id.button_ac);
        btn_bracket_start = findViewById(R.id.button_bracket_start);
        btn_bracket_end = findViewById(R.id.button_bracket_end);

        //Input and Output Text
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        //number events
        btn_0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "9");
            }
        });

        //operators events
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                outputText.setText("");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + ".");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "-");
            }
        });

        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "x");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "÷");
            }
        });

        btn_bracket_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + "(");
            }
        });

        btn_bracket_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data + ")");
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                //replacing the string operators with logical operators
                data = data.replaceAll("x","*");
                data = data.replaceAll("÷","/");
                //data = data.replaceAll("x","*");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                Scriptable scriptable = rhino.initSafeStandardObjects();
                finalResult = rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                outputText.setText(finalResult);
            }
        });
    }
}