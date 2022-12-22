package com.example.tictactoe;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game_Display extends AppCompatActivity {

    private Board ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedisplay);


//        for graping the information of the buttons
        Button playAgainBTN = findViewById(R.id.play_Again);
        Button homeBTN = findViewById(R.id.home_BTN);
        TextView playerTurn = findViewById(R.id.player_display);
        //TO MAKE THE BUTTONS AT THE FIRST NOT VISIBLE
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);


        String [] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");
        if(playerNames !=null){
            playerTurn.setText((playerNames[0])+"'S Turn");
        }
        ticTacToeBoard = findViewById(R.id.board);
        ticTacToeBoard.setUpGame(playAgainBTN,homeBTN,playerTurn,playerNames);
    }

    public void playAgainButtonClick(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public  void homeButtomClick(View view){
        // to load up the page that we have
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}