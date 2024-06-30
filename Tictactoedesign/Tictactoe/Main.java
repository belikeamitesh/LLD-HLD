package  Tictactoe;

public class Main{
    public static void main(String args[]){
        TicTacToe game = new TicTacToe();
        System.out.println("The winner of the game is : "+game.startGame());
    }
}