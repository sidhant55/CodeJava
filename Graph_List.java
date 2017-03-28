//created by sidhant
//28/03/2017

//Addition and deletion of edges in vertices with the help of linked list

import java.util.*;
class node
{
    int data;
    node next;
}
public class Graph_list
{
    public static void main (String args[])
    {
        Scanner in=new Scanner (System.in);
        System.out.println("Enter number of vertices");
        int n=in.nextInt();
        node ar[]=new node[n];
        for (int i=0;i<n;i++)
        {
            ar[i]=new node();
            ar[i].data=i+1;
            ar[i].next=null;
        }
        while (true)
        {
            System.out.println("1 for adding an edge\n2 for deltion of edge\n3 to print\n4 to break");
            int d=in.nextInt();
            if (d==1)
            {
                System.out.println("Enter two vertices between 1 to "+n);
                int a=in.nextInt();
                int b=in.nextInt();
                node x=new node();
                x.data=b;
                x.next=null;
                node y=new node();
                y.data=a;
                y.next=null;
                node head1=ar[a-1];
                while(head1.next!=null)
                {
                    head1=head1.next;
                }
                head1.next=x;
                node head2=ar[b-1];
                while(head2.next!=null)
                {
                    head2=head2.next;
                }
                head2.next=y;
            }
            else if (d==3)
            {
                for (int i=0;i<n;i++)
                {
                    node head=ar[i];
                    while (head!=null)
                    {
                        System.out.print(head.data+" ");
                        head=head.next;
                    }
                    System.out.println();
                }
            }
            else if (d==2)
            {
                System.out.println("Enter two vertices between 1 to "+n);
                int a=in.nextInt();
                int b=in.nextInt();
                node s;
                node head1=ar[a-1];
                s=head1;
                while(head1.next!=null)
                {
                    head1=head1.next;
                    if(head1.data==b)
                    s.next=head1.next;
                    s=head1;
                }
                node head2=ar[b-1];
                s=head2;
                while(head2.next!=null)
                {
                    head2=head2.next;
                    if(head2.data==a)
                    s.next=head2.next;
                    s=head2;
                }
            }
            else
            break;
        }
    }
}
