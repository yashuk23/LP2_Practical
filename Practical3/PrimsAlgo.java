import java.util.*;
class PrimsAlgo
{
    public static class Edge
    {
        int node,wt;
        Edge(int node,int wt)
        {
            this.node=node;
            this.wt=wt;
        }
    }

    public static int prims(List<List<Edge>> graph,int V)
    {
        boolean vis[]=new boolean[V];
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);

        pq.add(new Edge(0,0));

        int totalWt=0;

        while(!pq.isEmpty())
        {
            Edge curr=pq.poll();

            int node=curr.node;
            int wt=curr.wt;

            if(vis[node])continue;

            vis[node]=true;
            totalWt+=wt;

            for(Edge i:graph.get(node))
            {
                if(!vis[i.node])
                {
                    pq.add(new Edge(i.node,i.wt));
                }
            }
        }

        return totalWt;
    }

       public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);

        System.out.print("Enter Number of Vertices : ");
        int V=sn.nextInt();

        System.out.print("Enter Number of Edges : ");
        int E=sn.nextInt();

        List<List<Edge>> graph=new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            graph.add(new ArrayList<>());
        }

        System.out.println("\nEnter Source Destination Weight");

        for(int i=0;i<E;i++)
        {
            int u=sn.nextInt();
            int v=sn.nextInt();
            int wt=sn.nextInt();

            graph.get(u).add(new Edge(v,wt));
            graph.get(v).add(new Edge(u,wt));
        }

        int ans=prims(graph,V);

        System.out.println("\nMinimum Cost of MST = "+ans);

        sn.close();
    }
}