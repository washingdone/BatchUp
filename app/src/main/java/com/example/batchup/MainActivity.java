package com.example.batchup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView showTV = findViewById(R.id.showTV);
        String contents =showTV.getText().toString();
        contents = "1 cup water\n2 teaspoons lemon juice\n3 tablespoons sugar";
        showTV.setText(contents);
    }
}