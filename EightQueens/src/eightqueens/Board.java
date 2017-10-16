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
public class Board {
    private char[][] board;
    int queens = 0;
    
    public static int SIZE = 8;
    public static char QUEEN = 'Q';
    public static char OPEN = '*';
    
    public Board(char[][] board){
        this.board = board;
        
        for( int row = 0; row < board.length; row++ ){
            for( int col = 0; col < board.length; col++ ){
                board[row][col] = OPEN;
            }
        }
    }
    
    public void printBoard(){
        for( int row = 0; row < board.length; row++ ){
            for( int col = 0; col < board.length; col++ ){
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }
    
    public void solve(){
        int rowStart = 0,
            colStart = 0;
        
        solve(rowStart, colStart, SIZE );
    }
    
    private void solve(int row, int col, int end){
        
        if( queens == end ){
            System.out.println("Oh nice! It's done!");
        }else{
            for( int i = 0; i < end; i++ ){
            if( canGoThere(row, col) ){
                board[row][col] = QUEEN;
                queens++;
            }else{
                queens--;
                canGoThere(row + 1, col + 1);
            }
        }
        }
        
        
        
        
    }
    
    private boolean canGoThere(int row, int col){
        for( int i = 0; i < row; i++ ){
            if( queens == col 
                    || i - row == queens - col 
                    || i - row == col - queens ){
                
                return false;
            }
        }
        return true;
    }
}
