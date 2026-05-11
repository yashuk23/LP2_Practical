import java.util.*;
class NQueenProblem
{
    public static boolean nQueen(char grid[][],int row,int n,int queen)
    {
        if(queen==0)return true;
        if(row==n)return false;

        for(int col=0;col<n;col++)
        {
            if(isSafe(grid,row,col,n))
            {
                grid[row][col]='Q';
                if(nQueen(grid,row+1,n,queen-1))
                {
                    return true;
                }
                grid[row][col]='.';
            }
        }

        if(nQueen(grid,row+1,n,queen))
        {
            return true;
        }

        return false;
    }

    public static boolean isSafe(char grid[][],int row,int col,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(grid[row][i]=='Q')return false;
        }

        for(int i=0;i<n;i++)
        {
            if(grid[i][col]=='Q')return false;
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(grid[i][j]=='Q')return false;
        }

        for(int i=row-1,j=col+1;i>=0 && j<n ;i--,j++)
        {
            if(grid[i][j]=='Q')return false;
        }

        return true;
    }

    public static void printBoard(char grid[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);
        System.out.print("\nEnter the size of Grid : ");
        int n=sn.nextInt();

        char grid[][]=new char[n][n];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(grid[i],'.');
        }

        System.out.print("\nEnter the number of Queens to be placed : ");
        int queen=sn.nextInt();

        boolean res=nQueen(grid,0,n,queen);

        if(res)
        {
            printBoard(grid,n);
        }
    }
}