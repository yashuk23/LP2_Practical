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

    public static void main(String [] args)
    {
        int V = 4;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) 
        {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 15));

        graph.get(1).add(new Edge(0, 10));
        graph.get(1).add(new Edge(3, 12));

        graph.get(2).add(new Edge(0, 15));
        graph.get(2).add(new Edge(3, 10));

        graph.get(3).add(new Edge(1, 12));
        graph.get(3).add(new Edge(2, 10));

        int ans = prims(graph, V);

        System.out.println("Minimum Cost of MST = " + ans);
    }
}