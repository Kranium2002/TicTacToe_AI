import java.util.Scanner;
import java.util.HashSet;


public class TicTacToe {
    static HashSet<Integer> set=new HashSet();
    static int [][] board = new int[3][3];
    static Scanner scanner = new Scanner(System.in);
    static boolean chance = false;
    static int input;
    public static void main(String[] args)
    {
        System.out.println("Use numbers 1-9 to input X and O. X plays FIRST.");
        printBoard(board);
        for(;;)
        {
        boardInit();
        while(isFull()==false)
        {
        printBoard(board);
        input();
        
        if(hasWon(board)==-1)
        {
            System.out.println("X has Won");
            printBoard(board);
            break;
        }
        else if(hasWon(board)==1)
        {
            System.out.println("O has Won");
            printBoard(board);
            break;
        }
    }
    }
    }
    
    static void input()
    {
        input = scanner.nextInt();
        while(input<1||input>9)
        {
            System.out.println("Enter value between 1-9");
            input = scanner.nextInt();
        }
        while(set.contains(input))
        {
        System.out.println("Position already taken. Enter Again.");    
        input = scanner.nextInt();
        //System.out.println(set.size());
        }    
        set.add(input);
        if(chance==false)
        {
            int j = (input-1)%3;
            int i = (input-1)/3;
            board[i][j]=-1;
            chance=!chance;
        }
        else if(chance==true)
        {
            int j = (input-1)%3;
            int i = (input-1)/3;
            board[i][j]=1;
            chance=!chance;
        }
    }
    static void printBoard(int [][] board)
    {
        System.out.println("_________");
        System.out.println("");
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {   
                //System.out.print(board[i][j]);
                if(board[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(board[i][j]==-1)
                {
                    System.out.print("X");
                }
                else if(board[i][j]==1)
                {
                    System.out.print("O");
                }
                if(j==0||j==1)
                {
                    System.out.print(" | ");
            }

            
        }
            System.out.println("");
            System.out.print(" _ ");
            System.out.print(" _ ");    
            System.out.print(" _ ");
            System.out.println("");
            System.out.println("");
        }
        System.out.println("_________");
    }
    private static void boardInit()
    {
        chance=false;
        for(int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                board[i][j]=0;
            }
        }
    }
    static int hasWon(int[][] board)
    {
        int sum_r;
        int sum_c;
        int sum_d1=0;
        int sum_d2=0;
        for(int i=0;i<3;i++)
        {
            sum_r=0;
            sum_c=0;
            for (int j=0;j<3;j++)
            {
                sum_c=sum_c+board[j][i];
                sum_r=board[i][j]+sum_r;
                if(i==j)
                {
                    sum_d1=sum_d1+board[i][j];
                }
            }
            if(sum_r==-3||sum_c==-3)
            {
                return -1;
            }
            else if(sum_r==3||sum_c==3)
            {
                return 1;
            }

        }

        if(sum_d1==-3||sum_d2==-3)
        {
            return -1;
        }
        else if(sum_d1==3||sum_d2==3)
        {
            return 1;
        }
        return 0;
    }
    static boolean isFull()
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