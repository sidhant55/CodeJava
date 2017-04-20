import java.util.*;
class node
{
    int val;
    node next;
    node prev;
}
public class Queue_DLL
{
    public static void main (String args[])
    {
    Scanner in=new Scanner (System.in);
    int flag=0;node head=null,a,b=null;
    while(true)
    {
        System.out.println("1-insert\n2-delete\n3-print\n4-break");
        int d=in.nextInt();
        if (d==1)
        {
            flag++;
            System.out.println("Enter Data");
            a=new node();
            a.val=in.nextInt();
            a.next=null;
            a.prev=null;
            if (flag==1)
            head=a;
            else
            {
                b.next=a;
                a.prev=b;
            }
            b=a;
        }
        if (d==2)
        {
            head=head.next;
            head.prev=null;
        }
        if(d==3)
        {
            a=head;
            while(a!=null)
            {
                System.out.print(a.val+" ");
                a=a.next;
            }
            System.out.println();
        }
        if (d==4)
        break;
    }
}
}
               
