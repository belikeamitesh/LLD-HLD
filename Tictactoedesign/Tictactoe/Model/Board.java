package Tictactoe.Model;


import java.util.List;
import java.util.ArrayList;
public class Board {
    public int size;
    public PlayingPiece[][]board;
    public Board(int size){
        this.size= size;
        board = new PlayingPiece[size][size];
    }
    public boolean addPiece(int row,int col,PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col]=playingPiece;
        return true;
    }

public List<Cell> getFreeCells() {
    List<Cell> freecells = new ArrayList<>();
    for(int i=0; i<size; i++) {
        for(int j=0; j<size; j++) {
            if(board[i][j]==null){
                Cell cell = new Cell(i, j);
                freecells.add(cell);
            }
        }
    }
    return freecells;
}
    public void printBoard(){
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.print("| ");
                if (board[i][j]!=null)
                {
                    System.out.print(board[i][j].pieceType + " ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}
