/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author etcharn1
 */
public class Maze {
    private char[][] maze;
    
    public static char WALL = 'W';
    public static char OPEN = ' ';
    public static char STONE = '.';
    public static char START = 'S';
    public static char END = 'E';
    
    private int colStart;
    private int rowStart;
    private boolean unsolved;
    
    public Maze(char[][] maze)
    {
        this.maze = maze;
        unsolved = true;
        colStart = -1;
        rowStart = -1;
        for ( int row = 0; row < maze.length; row++ )
        {
            for ( int col = 0; col < maze[row].length; col++ )
            {
                if ( maze[row][col] == Maze.START )
                {
                    rowStart = row;
                    colStart = col;
                }
            }
        }
    }
    
    public void print()
    {
        for ( int row = 0; row < maze.length; row++ )
        {
            for ( int col = 0; col < maze[row].length; col++ )
            {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
    }
    
    public void solve()
    {
        solve(rowStart, colStart);
    }
    
    private void solve(int row, int col)
    {
        if ( maze[row][col] == Maze.END )
        {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
            unsolved = false;
        }
        else
        {
            maze[row][col] = Maze.STONE;
        }
        
        // Can I go South?
        if ( canGoThere( row+1,col ) )
        {
            solve(row+1, col);
        }
        
        // Can I go East?
        if ( canGoThere( row, col + 1 ) )
        {
            solve(row, col+1);
        }
        
        // Can I go North?
        if ( canGoThere( row-1, col ) )
        {
            solve(row-1, col);
        }
        
        // Can I go West?
        if ( canGoThere( row, col-1 ) )
        {
            solve(row, col-1);
        }
        
        // the stack is empty and I'm back at the beginning
        if ( row == rowStart && col == colStart && unsolved )
        {
            System.out.println("LOSER!");
        }
    }
    
    private boolean canGoThere(int row, int col)
    {
        return unsolved && row >= 0 && col >= 0 && row < maze.length && col < maze[row].length && 
               ( maze[row][col] == Maze.OPEN || maze[row][col] == Maze.END );
    }
}
