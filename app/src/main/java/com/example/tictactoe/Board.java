package com.example.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Board extends View {
    private final int boardColor;
    private final int XColor ;
    private final int OColor ;
    private final int winningLineColor;
    private final Paint paint = new Paint();
    private final Game game ;

    private  int cellSize = getWidth()/3;

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        game = new Game();
//        to get the attrs file
        TypedArray a =context.getTheme().obtainStyledAttributes(attrs,R.styleable.Board,0,0);

        try {
            boardColor = a.getInteger(R.styleable.Board_boardColor,0);
            XColor = a.getInteger(R.styleable.Board_XColor,0);
            OColor = a.getInteger(R.styleable.Board_OColor,0);
            winningLineColor = a.getInteger(R.styleable.Board_winningLineColor,0);
        }finally {
            a.recycle();
        }


    }



    @Override
    //setting the dimensions of the board
    protected  void onMeasure(int width , int height){
//        for making it perfectly square
        super.onMeasure(width,height);
        int dimension = Math.min(getMeasuredHeight() , getMeasuredWidth());
        cellSize = dimension/3;
        setMeasuredDimension(dimension,dimension);
    }

    //on draw
    @Override
    protected  void onDraw (Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawMarkers(canvas);
//        drawX(canvas , 1  ,1 );
//        drawY(canvas , 1 ,2);
    }

    private  void drawMarkers(Canvas canvas){
        //game logic
        for (int  r=0 ; r<3 ;r++){
            for (int c=0 ; c<3 ; c++){
               if(game.getGameBoard()[r][c]!=0){

                   // 1 represent x and 0 represent o
                   if(game.getGameBoard()[r][c] ==1){
                       drawX(canvas ,r , c );
                   }
                   else{
                       drawO(canvas,r,c);
                   }
               }

            }
        }
    }

    public  boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();
        //to make sure that the user is interacting and making an action
        if(action==MotionEvent.ACTION_DOWN){
            int row = (int )Math.ceil(y/cellSize);
            int col = (int )Math.ceil(x/cellSize);
            if(game.updateGameBoard(row , col)){
                invalidate();

                // for updating the players turns , alternating between players
                if(game.getPlayer() %2 ==0){
                    game.setPlayer(game.getPlayer()-1);
                }else{
                    game.setPlayer(game.getPlayer()+1);
                }

            }
            invalidate();// to update the game player
            return true;
        }
        return false;
    }

    private  void drawGameBoard (Canvas canvas){
        paint.setColor((boardColor));
        paint.setStrokeWidth(16);
        for(int c=1 ; c<3;c++){
            canvas.drawLine(cellSize*c,0,cellSize*c,canvas.getWidth(),paint);
        }
        for(int z=1 ; z<3;z++){
            canvas.drawLine(0,cellSize*z,canvas.getWidth(),cellSize*z,paint);
        }
    }

    private void drawX(Canvas canvas,int row,int col){
        paint.setColor(XColor);
        canvas.drawLine( (float) ((col+1)*cellSize - cellSize*0.2),
                (float) (row*cellSize + cellSize*0.2),
                (float) (col*cellSize + cellSize*0.2),
                (float) ((row+1)*cellSize - cellSize*0.2),
                paint);
//        reduction values
        canvas.drawLine( (float) (col*cellSize+ cellSize*0.2),
                (float) (row*cellSize + cellSize*0.2),
                (float) ((col+1)*cellSize - cellSize *0.2),
                (float) ((row+1)*cellSize - cellSize*0.2),
                paint);
    }
    private void drawO(Canvas canvas,int row,int col){
        paint.setColor(OColor);
        canvas.drawOval( (float) (col*cellSize+ cellSize*0.2),
                (float) (row*cellSize+ cellSize*0.2),
                (float) ((col*cellSize+cellSize) - cellSize*0.2),
                (float) ((row*cellSize+cellSize) - cellSize*0.2),
                paint
        );

    }
    public  void setUpGame (Button playAgain , Button home , TextView playerDisplay , String []names){
        //assigning this values to the game class
        game.setPlayAgainBTN(playAgain);
        game.setHomeBtn(home);
        game.setPlayerTurn(playerDisplay);
        game.setPlayerNames(names);
    }
    public void resetGame(){
        game.resetGame();
    }
}
