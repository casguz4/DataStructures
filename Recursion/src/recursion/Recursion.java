/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        for ( int number = 1; number < 100; number++ )
//        {
//            System.out.println( "Fib " + number + ": " + FibIter(number) );
//        }

        char[][] maze = { 
            { Maze.START, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL  },
            { Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL  },
            { Maze.OPEN, Maze.WALL, Maze.WALL, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL  },
            { Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.END  },
            { Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.WALL, Maze.WALL, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.WALL  },
            { Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN  },
            { Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN  },
            { Maze.OPEN, Maze.WALL, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.WALL, Maze.OPEN  },
            { Maze.OPEN, Maze.WALL, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.OPEN  },
            { Maze.OPEN, Maze.OPEN, Maze.OPEN, Maze.WALL, Maze.WALL, Maze.WALL, Maze.WALL, Maze.WALL, Maze.WALL, Maze.WALL  }
        };
        
        Maze newMaze = new Maze(maze);
        newMaze.print();
        newMaze.solve();
        System.out.println("\n\n");
        newMaze.print();
    }
    
    public static long FibIter(int n )
    {
        if ( n <= 2 )
        {
            return 1;
        }
        int currentN = 3;
        long previous = 1;
        long current = 1;
        
        while ( currentN < n )
        {
            long temp = previous;
            previous = current;
            current = current + temp;
            currentN++;
        }
        
        return current + previous;
    }
    
    public static long Fib(int n)
    {
        if ( n <= 2 )
        {
            return 1;
        }
        return Fib( n, 3, 1, 1);
    } 
    
    private static long Fib( int n, int currentN, long previous, long current )
    {
        if ( n == currentN )
        {
            return previous + current;
        }
        return Fib( n, currentN + 1, current, current + previous);
    }
    
    public static void count(int i)
    {
        System.out.println(Integer.toString(i));
        if ( i > 1 )
        {
            count(i-1);
        }
    }
}
