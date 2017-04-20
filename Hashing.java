//Created by sidhant
//27/03/2017

//Hashing in combination with modulo and chainig

import java.util.*;
class node
{
    int value;
    node next;
}
public class Hashing
{
    public static void main (String args[])
    {
        Scanner in=new Scanner (System.in);
        System.out.println("Enter number of input");
        int n=in.nextInt();
        node m[]=new node[n];
        for (int i=0;i<n;i++)
        {
            m[i]=new node();
        }
        int flag=0;
        System.out.println("Enter "+n+" numbers");
        for (int i=0;i<n;i++)
        {
            int k=in.nextInt();
            node p=m[k%n];
            while (p.next!=null)
            {
                p=p.next;
            }
            node a =new node();
            a.value=k;
            p.next=a;
            a.next=null;
        }
        for (int i=0;i<n;i++)
        {
            
            node b=m[i];
            while(b!=null)
            {
               System.out.print(b.value+" "); 
               b=b.next;
            }
        }
        System.out.println("Here 0 are untouched lists");
        System.out.println("Enter number to be searched");
        int t=in.nextInt();
        node b=m[t%n];
        while (b!=null)
        {
            if (b.value==t)
            {
                flag=1;
                break;
            }
            b=b.next;
        }
        if (flag==1)
        System.out.println("Number Found");
        else
        System.out.println("Number not found");
    }
}
    
    
