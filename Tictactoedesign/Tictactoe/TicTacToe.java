package Tictactoe;

import Tictactoe.Model.*;
import com.sun.tools.javac.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player>players;
    Board gameBoard;

    TicTacToe(){
        initializeGame();
    }
    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter plauer1 Name - X");
        String pl1 = inputScanner.nextLine();
        System.out.println("Enter plauer2 Name - O");
        String pl2 = inputScanner.nextLine();
        Player player1 = new Player(pl1,crossPiece);
        PlayingPieceO zeroPiece= new PlayingPieceO();
        Player player2 = new Player(pl2,zeroPiece);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }
    public String startGame(){
        boolean noWinner= true;
        while(noWinner) {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<Cell> freespace = gameBoard.getFreeCells();
            if(freespace.isEmpty())
            {
                noWinner=false;
                continue;
            }
            System.out.print("Player : "+playerTurn.name+" Enter row and column : ");
            Scanner inputScanner = new Scanner(System.in);
            String s= inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean pieceAddedSuccesfully = gameBoard.addPiece(inputRow,inputCol,playerTurn.playingPiece);
            if(!pieceAddedSuccesfully){
                System.out.println("Incorrect position chosen, Please try again!");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean isWinner = isThereWinner(inputRow,inputCol,playerTurn.playingPiece.pieceType);
            if (isWinner){
                return playerTurn.name;
            }
        }
        return "tie game";
    }

    public boolean isThereWinner(int row, int col, PieceType pieceType){
        boolean rowMatch =true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antidiagonalMatch = true;
        for(int i=0;i<gameBoard.size;i++)
        {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType!=pieceType){
                rowMatch=false;
            }
        }
        for(int i=0;i<gameBoard.size;i++)
        {
            if(gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType!=pieceType){
                colMatch=false;
            }
        }
        for(int i=0,j=0;i<gameBoard.size;i++,j++)
        {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType!=pieceType){
                diagonalMatch=false;
            }
        }
        for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--)
        {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType!=pieceType){
                antidiagonalMatch=false;
            }
        }
        return rowMatch || diagonalMatch || colMatch || antidiagonalMatch;
    }
}
