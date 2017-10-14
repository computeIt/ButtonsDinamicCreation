package com.example.addy.buttonsdinamiccreation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input;
    Button clearButton, createButton;
    LinearLayout main_field;
    RadioGroup radioGroup, colorRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);

        clearButton = (Button) findViewById(R.id.clearButton);
        createButton = (Button) findViewById(R.id.createButton);

        main_field = (LinearLayout) findViewById(R.id.main_field);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        colorRadioGroup = (RadioGroup) findViewById(R.id.colorRadioGroup);

        clearButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createButton:
                //creating layoutParams for setting up button properties
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                int btnGravity = Gravity.LEFT;
                switch (radioGroup.getCheckedRadioButtonId()){//getCheckedRadioButtonId returns Id choiced radiobutton from a group
                    case R.id.radio_center:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.radio_right:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                layoutParams.gravity = btnGravity;//default = LEFT

                int btnColor = Color.RED;
                switch (colorRadioGroup.getCheckedRadioButtonId()){//determine the color
                    case R.id.red:
                        btnColor = Color.RED;
                        break;
                    case R.id.green:
                        btnColor = Color.GREEN;
                        break;
                    case R.id.blue:
                        btnColor = Color.BLUE;
                        break;
                }

                Button button = new Button(this);
                button.setText(input.getText().toString());
                button.setBackgroundColor(btnColor);
                main_field.addView(button, layoutParams);//addind new button to the view(on the screen)
                break;
            case R.id.clearButton:
                main_field.removeAllViews();
                Toast.makeText(MainActivity.this, "aff buttons deleted", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
