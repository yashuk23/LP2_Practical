// A Star Algorithm for Maze Problem 
import java.util.*;
class Node
{
    int x, y, g, h;

    Node(int x,int y,int g,int h)
    {
        this.x=x;
        this.y=y;
        this.g=g;
        this.h=h;
    }

    int f()
    {
        return g+h;
    }
}

class AStar
{
    public static Node getMin(List<Node> open)
    {
        Node min=open.get(0);

        for(Node node:open)
        {
            if(node.f()<min.f())min=node;
        }

        return min;
    }

    public static int astar(int grid[][],int startX,int startY,int endX,int endY)
    {
        int m=grid.length;
        int n=grid[0].length;

        boolean vis[][]=new boolean[m][n];

        List<Node> open=new ArrayList<>();

        open.add(new Node(startX,startY,0,Math.abs(endX-startX)+Math.abs(endY-startY)));

        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};

        while(!open.isEmpty())
        {
            Node curr=getMin(open);

            open.remove(curr);

            if(curr.x==endX && curr.y==endY)return curr.g;

            if(vis[curr.x][curr.y])continue;

            vis[curr.x][curr.y]=true;

            for(int i=0;i<4;i++)
            {
                int newX=curr.x+row[i];
                int newY=curr.y+col[i];

                if(newX>=0 && newX<m && newY>=0 && newY<n && !vis[newX][newY] && grid[newX][newY]==0)
                {
                    int newG=curr.g+1;
                    int newH=Math.abs(endX-newX)+Math.abs(endY-newY);
                    open.add(new Node(newX,newY,newG,newH));
                }
            }
        }
        return -1;
    }


    public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);
        System.out.print("\nEnter the size of grid  : ");
        int size=sn.nextInt();

        int grid[][]=new int[size][size];

        for(int i=0;i<size;i++)
        {
            System.out.print("\nEnter the "+(i+1)+" row in Maze Problem : ");
            for(int j=0;j<size;j++)
            {
                grid[i][j]=sn.nextInt();
            }
        }

        sn.close();

        int m=grid.length;
        int n=grid[0].length;

        int ans=astar(grid,0,0,m-1,n-1);

        System.out.print("\nShortest Path Cost = " + ans);
    }
}