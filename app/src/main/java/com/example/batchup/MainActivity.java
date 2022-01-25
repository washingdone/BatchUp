package com.example.batchup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    public void batchButton(View v){
        TextView showTV = findViewById(R.id.showTV);
        EditText multiplyET = findViewById(R.id.multiplyET);
        String batchNumStr = multiplyET.getText().toString();

        try {
            int batchNumber =Integer.parseInt(batchNumStr);

            if (batchNumber < 1) {
                throw new NumberFormatException();
            } else {
                String newData = (1 * batchNumber) + " cup water\n" +
                        (2 * batchNumber) + " teaspoons lemon juice\n" +
                        (3 * batchNumber) + " tablespoons sugar";
                showTV.setText(newData);
            }
        } catch(NumberFormatException e) {
            // Handle invalid input
            Toast.makeText(this, "Please input a positive integer", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle all other exceptions
            Log.d("Unknown exception", e.toString());
            Toast.makeText(this, "Unknown error has occured, please try again", Toast.LENGTH_SHORT).show();
        }
    }
}