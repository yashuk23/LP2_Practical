import java.util.*;

class DijkstraAlgo
{
    static class Edge
    {
        int node, weight;

        Edge(int node,int weight)
        {
            this.node=node;
            this.weight=weight;
        }
    }

    public static int[] solve(ArrayList<ArrayList<Edge>> adj,int src)
    {
        int n=adj.size();

        int dist[]=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,src});

        while(!pq.isEmpty())
        {
            int current[]=pq.poll();

            int w=current[0];
            int node=current[1];

            for(Edge e:adj.get(node))
            {
                int adjNode=e.node;
                int adjW=e.weight;

                if(w+adjW < dist[adjNode])
                {
                    dist[adjNode]=w+adjW;
                    pq.offer(new int[]{dist[adjNode],adjNode});
                }
            }
        }

        return dist;
    }

    public static void main(String args[])
    {
        int V=5;

        ArrayList<ArrayList<Edge>> adj=new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Edge(1,2));
        adj.get(0).add(new Edge(2,4));

        adj.get(1).add(new Edge(2,1));
        adj.get(1).add(new Edge(3,7));

        adj.get(2).add(new Edge(4,3));

        adj.get(3).add(new Edge(4,2));

        int ans[]=solve(adj,0);

        System.out.println
        (
            "Shortest Distance from Source Node 0"
        );

        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}