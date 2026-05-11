import java.util.*;
class NQueenProblem
{
    public static boolean nQueen(char board[][],int row,int n)
    {
        if(row==n)return true;
        for(int col=0;col<n;col++)
        {
            if(isSafe(board,row,col,n))
            {
                board[row][col]='Q';
                if(nQueen(board,row+1,n))
                {
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }

    public static boolean isSafe(char board[][],int row,int col,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(board[row][i]=='Q')return false;
        }

        for(int i=0;i<n;i++)
        {
            if(board[i][col]=='Q')return false;
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')return false;
        }

        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
        {
            if(board[i][j]=='Q')return false;
        }

        return true;
    }

    public static void printBoard(char board[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);
        System.out.print("\nEnter the size of the board  :  ");
        int n=sn.nextInt();

        sn.close();

        char board[][]=new char[n][n];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(board[i],'.');
        }

        if(nQueen(board,0,n))
        {
            printBoard(board,n);
        }
        else
        {
            System.out.print("\n No Solution ");
        }
    }
}