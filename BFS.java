/*Created by Sidhant
21-04-17*/

import java.util.*;

public class BFSA
{
    static node1[] BFS(node vert[],int s,int v)
    {
        System.out.println("Well Done");
        node1 prop[]=new node1 [v];
        for (int i=0;i<v;i++)
        {
            prop[i]=new node1();
            prop[i].color='w';
            prop[i].d=100;
            prop[i].p=-1;
        }
        node ob1;
        int t,r;
        s=s-1;
        prop[s].color='g';
        prop[s].d=0;
        prop[s].p=-1;
        Queue<Integer> q = new LinkedList<>();
        s=s+1;
        q.add(s);
        int c=0;
        while (q.size()!=0)
        {
            t=q.remove();
            ob1=vert[t-1].next;
            while (ob1!=null)
            {
                r=ob1.val;
                if (prop[r-1].color=='w')
                {
                    prop[r-1].color='g';
                    prop[r-1].d=prop[t-1].d+1;
                    prop[r-1].p=t;
                    q.add(r);
                }
                ob1=ob1.next;
            }
            prop[t-1].color='b';
            c++;
        }
        return prop;
    }
    
    public static void main (String args[])
    {
        Scanner in=new Scanner (System.in);
        System.out.println("Enter number of vertices and edges");
        int v=in.nextInt();
        int e=in.nextInt();
        node vert[]=new node [v];
        node1 prop[];
        node ob,ob1;
        for (int i=0;i<v;i++)
        {
            vert[i]=new node();
            vert[i].val=i+1;
            vert[i].next=null;
        }
        System.out.println("Enter 2 nodes which form edges");
        for (int i=1;i<=e;i++)
        {
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            
            ob=new node();
            ob.val=b+1;
            ob.next=null;
            ob1=vert[a];
            while (ob1.next!=null)
            {
                ob1=ob1.next;
            }
            ob1.next=ob;
            
            ob=new node();
            ob.val=a+1;
            ob.next=null;
            ob1=vert[b];
            while (ob1.next!=null)
            {
                ob1=ob1.next;
            }
            ob1.next=ob;
        }
        for (int i=0;i<v;i++)
        {
           ob=vert[i];
           while (ob!=null)
           {
               System.out.print(ob.val+" ");
               ob=ob.next;
            }
               System.out.println();
        }
        System.out.println("Enter the source vertex");
        int s=in.nextInt();
        prop=BFS(vert,s,v);
        for (int i=0;i<v;i++)
        {
            System.out.println(prop[i].color+" "+prop[i].d+" "+prop[i].p);
            
        }
    }
}
class node
{
    int val;
    node next;
}
class node1
{
    char color;
    int d;
    int p;
}
            
