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
        ticTacToeBoard = findViewById(R.id.board);

//        for graping the information of the buttons
        Button playAgainBTN = findViewById(R.id.play_again);
        Button homeBTN = findViewById(R.id.home_button);
        TextView playerTurn = findViewById(R.id.player_display);

        String [] playerName = getIntent().getStringArrayExtra("PLAYER_NAME");

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