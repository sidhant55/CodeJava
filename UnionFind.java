package Data_Structure;

/*
see dishown in codechef package
*/

class edge
{
    int src;
    int dest;
}
class graph
{
    int v,e;
    edge edg[];
}
class subset
{
    int parent;
    int rank;
}
public class UnionFind {
    static graph createGraph(int V,int E)
    {
        graph obj= new graph();
        obj.v=V;
        obj.e=E;
        edge arr[]=new edge [E];
        for (int i=0;i<E;i++)
        {
            edge ob=new edge();
            arr[i]=ob;
        }
        obj.edg=arr;
        return obj;
    }
    static int find(subset sub[], int i)
    {
        //System.out.println(i);
        if (sub[i].parent!=i)
            sub[i].parent=find(sub,sub[i].parent);
        return sub[i].parent;
    }
    static void union(subset sub[],int x,int y)
    {
        int xroot=find(sub,x);
        int yroot=find(sub,y);
        if (sub[xroot].rank<sub[yroot].rank)
            sub[xroot].parent=yroot;
        else if (sub[xroot].rank>sub[yroot].rank)
            sub[yroot].parent=xroot;
        else
        {
            sub[yroot].parent=xroot;
            sub[xroot].rank++;
        }
    }

    static int isCycle(graph obj)
    {
        int v=obj.v;
        int e=obj.e;
        subset sub[]=new subset[v];
        for (int i=0;i<v;++i)
        {
            subset ob=new subset();
            sub[i]=ob;
            sub[i].parent=i;
            sub[i].rank=0;
        }
        for (int i=0;i<e;i++)
        {
            //System.out.println(i+" 55");
            int x=find(sub, obj.edg[i].src);
            int y=find(sub, obj.edg[i].dest);
            if (x==y)
                return 1;
            union(sub,x,y);
        }
        return 0;
    }
    public static void main(String args[]) {
        int V=3,E=3;
        graph obj= createGraph(V,E);

        obj.edg[0].src=0;
        obj.edg[0].dest=1;

        obj.edg[1].src=0;
        obj.edg[1].dest=2;

        obj.edg[2].src=2;
        obj.edg[2].dest=1;

        if (isCycle(obj)==1)
            System.out.println("Cycle");
        else
            System.out.println("No Cycle");
    }
}
