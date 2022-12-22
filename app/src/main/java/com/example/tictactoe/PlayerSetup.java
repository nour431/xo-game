package com.example.tictactoe;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {

    //binding the players but in private so we can edit
    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

//        for getting players names from the textBoxes,R.id.Nameof_the_textbox

        player1 = findViewById(R.id.editTextTextPersonName);// editTextTextPersonName name of textBox that is responsible  for carrying the player 1 name
        player2 = findViewById(R.id.editTextTextPersonName2);// editTextTextPersonName name of textBox that is responsible  for carrying the player 2 name

    }
//    submitButton
    public void submitButtonClick(View view){
        String editTextTextPersonName = player1.getText().toString();
        String editTextTextPersonName2 = player1.getText().toString();

        Intent intent = new Intent(this,Game_Display.class);
        intent.putExtra("PLAYER_NAMES", new String [] {editTextTextPersonName , editTextTextPersonName2 });
        startActivity(intent);
//         setting onClick action on the button that in design and pass this function to it
    }
}