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
                if(nQueen(board,row+1,n))return true;
                board[row][col]='.';