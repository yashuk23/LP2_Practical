// A Star Algorithm for Maze Problem 
import java.util.*;
class Node
{
    int x, y, g, h;
    Node parent;

    Node(int x,int y,int g,int h,Node parent)
    {
        this.x=x;
        this.y=y;
        this.g=g;
        this.h=h;
        this.parent=parent;
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

    public static void printPath(Node endNode)
    {
        List<String> path=new ArrayList<>();

        Node curr=endNode;

        while(curr!=null)
        {
            path.add("("+curr.x+","+curr.y+")");
            curr=curr.parent;
        }

        Collections.reverse(path);

        System.out.print("\nPath: ");
        for(String i:path)
        {
            System.out.print(i+" ");
        }
    }

    public static int astar(int grid[][],int startX,int startY,int endX,int endY)
    {
        int m=grid.length;
        int n=grid[0].length;

        boolean vis[][]=new boolean[m][n];

        List<Node> open=new ArrayList<>();

        open.add(new Node(startX,startY,0,Math.abs(endX-startX)+Math.abs(endY-startY),null));

        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};

        while(!open.isEmpty())
        {
            Node curr=getMin(open);

            open.remove(curr);

            if(curr.x==endX && curr.y==endY)
            {
                printPath(curr);
                return curr.g;
            }
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
                    open.add(new Node(newX,newY,newG,newH,curr));
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

        System.out.print("\n Enter the starting X coordinate : ");
        int x1=sn.nextInt();

        System.out.print("\n Enter the starting Y coordinate : ");
        int y1=sn.nextInt();

        System.out.print("\n Enter the ending X coordinate : ");
        int x2=sn.nextInt();

        System.out.print("\n Enter the ending X coordinate : ");
        int y2=sn.nextInt();

        int ans=astar(grid,x1,y1,x2-1,y2-1);

        if(ans==-1)
        {
            System.out.print("\nNo Path Exist ");
        }
        else
        {
            System.out.print("\nShortest Path Cost = " + ans);
        }
    }
}