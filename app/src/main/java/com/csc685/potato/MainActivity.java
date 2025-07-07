package com.csc685.potato;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addStuff();
    }
    private void addStuff(){
        Button button = findViewById(R.id.buttonOperate);
        button.setOnClickListener(view -> {
            EditText editText = findViewById(R.id.editTextYourName);
            TextView textView = findViewById(R.id.textViewNameDisplay);
            //String completer = " was not here.";
            //String entered = editText.getText().toString();
            //String enteredWeight = editText.getText().toString();
            int luggageWeight = Integer.parseInt(editText.getText().toString());
            //textView.setText(entered + completer);
            //int weight = 20;
            if (luggageWeight > 50){
                String assessment = "Your luggage is " + luggageWeight + " lbs. It is overweight.";
                textView.setText(assessment);
            } else {
                String assessment = "Your luggage weight is " + luggageWeight + "lbs. It is the allowed limit.";
                textView.setText(assessment);
            }
        });
    }
}