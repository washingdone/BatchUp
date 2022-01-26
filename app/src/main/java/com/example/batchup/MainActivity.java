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

    private int recipe;

    public void setRecipe(int recipe) {
        TextView showTV = findViewById(R.id.showTV);
        this.recipe = recipe;
        String newData = recipeGenerator(1);
        showTV.setText(newData);
    }

    public int getRecipe() {
        return recipe;
    }

    public void batchButton(View v) {
        // Initialize needed fields and pull or set necessary data
        TextView showTV = findViewById(R.id.showTV);
        EditText multiplyET = findViewById(R.id.multiplyET);
        String batchNumStr = multiplyET.getText().toString();
        int batchNumber = 0;

        try {
            switch(v.getId()){
                // Check which button is pushed by comparing the button's id to expected values
                case R.id.updateBatchBTN:
                    // Convert input to number if use button is selected
                    batchNumber = Integer.parseInt(batchNumStr);
                    break;
                case R.id.DoubleBTN:
                    batchNumber = 2;
                    break;
                case R.id.TripleBTN:
                    batchNumber = 3;
                    break;
                // Note: no default needed as initial batch number will automatically fail in later code
            }

            if (batchNumber < 1) {
                // If less than 1, prompt user to try again
                throw new NumberFormatException();
            } else {
                // Generate and set new recipe
                String newData = recipeGenerator(batchNumber);
                showTV.setText(newData);
            }
        } catch(NumberFormatException e) {
            // Handle invalid input
            Toast.makeText(this, "Please input a positive integer", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // Handle all other exceptions
            Log.d("Unknown exception", e.toString());
            Toast.makeText(this, "Unknown error has occurred, please try again. - Error BN" + batchNumber, Toast.LENGTH_SHORT).show();
        }
    }

    public void recipeButton(View v) {
        switch(v.getId()){
            case R.id.ClassicBTN:
                setRecipe(0);
                break;
            case R.id.PinkBTN:
                setRecipe(1);
                break;
            default:
                throw new RuntimeException();
        }
    }

    private String recipeGenerator(int batchNumber) {
        int recipe = getRecipe();
        String waterString = (batchNumber == 1) ? " cup water\n":" cups water\n";
        if (recipe == 0) {
            // Change display text to modified recipe
            return (batchNumber) + waterString +
                    (2 * batchNumber) + " teaspoons lemon juice\n" +
                    (3 * batchNumber) + " tablespoons sugar";
        } else if (recipe == 1) {
            return (batchNumber) + waterString +
                    (2 * batchNumber) + " teaspoons lemon juice\n" +
                    (3 * batchNumber) + " tablespoons sugar\n" +
                    (2 * batchNumber) + " drops of red food dye";
        }
        throw new RuntimeException();
    }
}