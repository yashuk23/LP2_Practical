//Refer the solution using recurrsion as mentioned in problem statement
import java.util.*;
class GraphTraversal
{
    // DFS Using Recurrsion
    public static List<Integer> dfsRecurrsive(int startNode,List<List<Integer>>adj,boolean vis[],List<Integer> ans)
    {
        ans.add(startNode);
        vis[startNode]=true;

        for(int i:adj.get(startNode))
        {
            if(!vis[i])
            {
                dfsRecurrsive(i,adj,vis,ans);
            }
        }
        return ans;
    }

    //BFS using Recurrsion 
    public static List<Integer> bfsRecurrsive(Queue<Integer> q,List<List<Integer>> adj,boolean vis[],List<Integer> ans)
    {
        if(q.isEmpty())return ans;

        int data=q.poll();
        ans.add(data);

        for(int i:adj.get(data))
        {
            if(!vis[i])
            {
                q.offer(i);
                vis[i]=true;
            }
        }

        return bfsRecurrsive(q,adj,vis,ans);
    }


    //dfs Using Stack Datastructure
    public static List<Integer> dfs(int startNode,List<List<Integer>> adj)
    {
        Stack<Integer> st=new Stack<>();
        boolean vis[]=new boolean[adj.size()];

        List<Integer> ans=new ArrayList<>();

        st.push(startNode);
        vis[startNode]=true;

        while(!st.isEmpty())
        {
            int neighbour=st.pop();
            ans.add(neighbour);

            for(int i:adj.get(neighbour))
            {
                if(!vis[i])
                {
                    st.push(i);
                    vis[i]=true;
                }
            }
        }

        return ans;
    }

    //BFS Using Queue DataStructure
    public static List<Integer> bfsTraversal(int startNode,List<List<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();

        boolean vis[]=new boolean[adj.size()];

        q.offer(startNode);
        vis[startNode]=true;

        while(!q.isEmpty())
        {
            int neighbour=q.poll();
            ans.add(neighbour);

            for(int i:adj.get(neighbour))
            {
                if(!vis[i])
                {
                    q.offer(i);
                    vis[i]=true;
                }
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        List<List<Integer>> adj=new ArrayList<>();

        List<Integer> dfsResult=new ArrayList<>();
        List<Integer> bfsResult=new ArrayList<>();

        Scanner sn=new Scanner(System.in);
        System.out.print("\nEnter the Number of the Nodes : ");
        int nodes=sn.nextInt();

        for(int i=0;i<nodes;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<nodes;i++)
        {
            System.out.print("\nEnter the number of edges to "+i+" Node : ");
            int edges=sn.nextInt();

            for(int j=0;j<edges;j++)
            {
                System.out.print("\nEnter the "+(j+1)+"th Edge : ");
                int edge=sn.nextInt();
                adj.get(i).add(edge);
                adj.get(edge).add(i);
            }
        }

        System.out.print("\nEnter the Start Node for the Traversal of the Graph : ");
        int startNode=sn.nextInt();
        sn.close();

        // dfsResult=dfs(startNode,adj);
        // bfsResult=bfsTraversal(startNode,adj);


        List<Integer> ans=new ArrayList<>();
        boolean vis1[]=new boolean[adj.size()];

        dfsResult=dfsRecurrsive(startNode,adj,vis1,ans);

        Queue<Integer> q=new LinkedList<>();
        boolean vis2[]=new boolean[adj.size()];
        List<Integer> res=new ArrayList<>();

        q.offer(startNode);
        vis2[startNode]=true;

        bfsResult=bfsRecurrsive(q,adj,vis2,res);


        System.out.print("\ndfs Traversal of Graph : "+dfsResult);
        System.out.print("\nBFS Traversal of Graph : "+bfsResult);
    }
}