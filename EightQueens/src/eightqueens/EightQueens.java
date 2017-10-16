/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueens;

/**
 *
 * @author casgu
 */
public class EightQueens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final char QUEEN = 'Q';
        final int SIZE = 8;

        char[][] makeBoard = new char[SIZE][SIZE];

        Board board = new Board(makeBoard);

        //print board before trying to place queens
        board.printBoard();

        board.solve();
        System.out.println("\n\n");
        board.printBoard();
        
    }
    
}
