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
        // Set up initial display data
        TextView showTV = findViewById(R.id.showTV);
        String contents = "1 cup water\n2 teaspoons lemon juice\n3 tablespoons sugar";
        showTV.setText(contents);
    }

    public void batchButton(View v) {
        // Initialize needed fields and pull necessary data
        EditText multiplyET = findViewById(R.id.multiplyET);
        String batchNumStr = multiplyET.getText().toString();

        try {
            // convert input to number
            int batchNumber = Integer.parseInt(batchNumStr);

            if (batchNumber < 1) {
                // If less than 1, prompt user to try again
                throw new NumberFormatException();
            } else {
                recipeGenerator(batchNumber);
            }
        } catch(NumberFormatException e) {
            // Handle invalid input
            Toast.makeText(this, "Please input a positive integer", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle all other exceptions
            Log.d("Unknown exception", e.toString());
            Toast.makeText(this, "Unknown error has occurred, please try again", Toast.LENGTH_SHORT).show();
        }
    }

    public void recipeGenerator(int batchNumber) {
        // Initialize needed fields and pull necessary data
        TextView showTV = findViewById(R.id.showTV);

        // Change display text to modified recipe
        String newData = (batchNumber) + " cup water\n" +
                (2 * batchNumber) + " teaspoons lemon juice\n" +
                (3 * batchNumber) + " tablespoons sugar";
        showTV.setText(newData);
    }
}