import java.util.Scanner;



public class TicTacToe {
    
    static int [][] board = new int[3][3];
    static Scanner scanner = new Scanner(System.in);
    //static boolean chance = true;
    
    static ai ai;
    public static void main(String[] args)
    {
        boardInit(board);
        ai= new ai(board,ai.player1);
        ai.learn();
      
        for(;;){
        System.out.println("Use numbers 1-9 to input X and O");
        ai current = ai;
        boolean player = ai.player1;
        for(;;)
        {
           
            System.out.println("Player " + (player ? "X" : "O") + " is about to set");

            
            
            // System.out.println(player);

 
       
        
        if (player) {
            
            int[] index = getInput();
            board[index[0]][index[1]] = player ? 1 : 2;
            current = current.children[index[0]][index[1]];
            
        } else {
            current = current.getChildWithValue();
            board = current.copyBoard();
        }
        printBoard(board);
        
        if (hasWon()) {
            
            System.out.println("Player " + (player ? "X" : "O") + " won!\n");
            //System.out.println(player);
            break;
        }

        if (isFull()) {
            System.out.println("It's a draw!\n");
            break;
        }
        player = !player;
    }
    boardInit(board);
    }
}
    

    
    private static int[] getInput() {
		int val;
		for (;;) {
			try {
				val= Integer.parseInt(scanner.next());
			} catch (final Exception e) {
				System.err.println("Invalid Input");
				continue;
			}
			val--;
			if (val < 0 || val > 8) {
				System.err.println("Invalid Input");
				continue;
			}
            
			final int row = val/3;
			final int col = val % 3;
            // if(ai.ismin==false)
            // {
            //     board[i][j]=-1;
            // }
            // else if(ai.ismin==true)
            // {
            //     board[i][j]=1;
            // }
			if (board[row][col] != 0) {
				System.err.println("Field is already set!");
				continue;
			}

			return new int[] { row, col };

		}

	}

    static void printBoard(int [][] board)
    {
        System.out.println("_________");
        System.out.println("");
        for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board[i].length; j++) {

				System.out.print("|" + (board[i][j] == 0 ? "_" : board[i][j] == 1 ? "X" : "O") + "|");

			}
			
			System.out.println();
		}
	}
        
    
    static void boardInit(int [][] board)
    {
       // chance=false;
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                board[i][j]=0;
            }
        }
    }

    static boolean hasWon() {
		return hasWon(board);
	}
    public static boolean hasWon(int[][] board)
    {
        for (int i = 0; i < board.length; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
				return true;
			}
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
				return true;
			}
		}

		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
			return true;
		}

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
			return true;
		}

		return false;
    }

    static boolean isFull() {
		return isFull(board);
	}
    public static boolean isFull(int[][] board)
    {
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if(board[i][j]==0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}