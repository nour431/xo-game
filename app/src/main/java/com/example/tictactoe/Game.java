package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Game {

    private int [] [] gameBoard;
    private String playerNames [] = {" player 1 ", "player 2"};
    private Button playAgainBTN;
    private Button homeBtn ;
    private TextView playerTurn;
    private int player =1;
    //constructor
    Game(){
        gameBoard = new int[3][3];

        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                gameBoard[r][c]=0;
            }
        }
    }
    // update game board
    public  boolean updateGameBoard(int row , int col){
        if(gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1]=player;
            if(player ==1){
                playerTurn.setText((playerNames[1]+"'s Turn"));

            }else{
                playerTurn.setText((playerNames[0]+"'s Turn"));
            }

            return true;
        }else{
            return false;

        }
    }

    public boolean winnnerCheck(){
        boolean isWinner = false;
        //scanning throw each rows
        for (int r=0;r<3;r++ ){

            if(gameBoard[r][0]==gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] !=0){
                isWinner =true;
            }
        }
        //scanning throw columns
        for (int r=0;r<3;r++ ){
            if(gameBoard[0][r]==gameBoard[1][r] && gameBoard[0][1] == gameBoard[2][r] && gameBoard[0][r] !=0){
                isWinner =true;
            }
        }
        //scanning throw left corner diagonal
        for (int r=0;r<3;r++ ){
            if(gameBoard[0][0]==gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] !=0){
                isWinner =true;
            }
        }
        //scanning throw right corner diagonal
        for (int r=0;r<3;r++ ){
            if(gameBoard[2][0]==gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] && gameBoard[0][2] !=0){
                isWinner =true;
            }
        }

        int boardFilled =0;
        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                if(gameBoard[r][c] != 0){
                    boardFilled++;
                }
            }
        }
        if(isWinner){
           playAgainBTN.setVisibility((View.VISIBLE));
           homeBtn.setVisibility((View.VISIBLE));
           playerTurn.setText(playerNames[player-1] + " WON!!!!!");
           return true;
        }
        else if (boardFilled ==9){
            playAgainBTN.setVisibility((View.VISIBLE));
            homeBtn.setVisibility((View.VISIBLE));
            playerTurn.setText( " DRAW!!!!!");
            return true;
        }else
        {
            return false;
        }

    }


    public void resetGame(){
        for (int r=0;r<3;r++){
            for (int c=0;c<3;c++){
                gameBoard[r][c]=0;
            }
        }
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

}
