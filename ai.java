import java.lang.Math;
public class ai{
    static boolean player1 = true;
    int[][] board = new int[3][3];
    ai[][] children = new ai[3][3];
    int value;
    boolean ismin;

    public ai(int[][] board, boolean ismin)
    {
        this.ismin=ismin;
        this.board = board;
    }

    int[][] copyBoard(){
        int[][] copy=new int[3][3];
        
        for(int i=0;i<copy.length;i++)
        {
            for (int j=0;j<copy[i].length;j++)
            {
                copy[i][j]=board[i][j];
            }
        }

        return copy;
    }

    public int learn()
    {
        if(TicTacToe.hasWon(board))
        {
            value= ismin?1 :-1;
            return value;
        }
        else if(TicTacToe.isFull(board))
        {
            value=0;
            return value;
        }
        value=ismin?1:-1;

    for (int i = 0; i < children.length; i++) {
        for (int j = 0; j < children[i].length; j++) {

            if (board[i][j] == 0) {
                int[][] childField = copyBoard();
                childField[i][j] = ismin ? 1 : 2;

                children[i][j] = new ai(childField, !ismin);

                value = ismin ? Math.min(value, children[i][j].learn()) : Math.max(value, children[i][j].learn());

            }
        }
    }

    return value;
}


public ai getChildWithValue() {

    for (int i = 0; i < children.length; i++) {
        for (int j = 0; j < children[i].length; j++) {
            if (children[i][j] != null && children[i][j].value == value) {
                return children[i][j];
            }
        }
    }
    return null;
}
}

