//Created by sidhant 
//27/03/2017

//Deletion of a node or vertices is in progress.

import java.util.*;
class node
{
    int val;
    node left;
    node right;
}
public class BST
{
    static void inorder (node h)
    {
        if (h!=null){
        inorder(h.left);
        System.out.print(h.val+" ");
        inorder(h.right);
    }
    }
    static void preorder (node h)
    {
        if (h!=null){
        System.out.print(h.val+" ");
        preorder(h.left);
        preorder(h.right);
    }
    }
    static void postorder (node h)
    {
        if (h!=null){
        postorder(h.left);
        postorder(h.right);
        System.out.print(h.val+" ");
    }
    }
    public static void main (String args[])
    {
        Scanner in=new Scanner (System.in);
        node head=null;
        int c=0;
        while (true)
        {
            System.out.println("1.to enter \n2.to delete \n3.to print \n4.to break");
            int t=in.nextInt();
            if (t==1)
            {
            c++;
            if (c==1)
            {
                head=new node();
                head.val=in.nextInt();
                head.left=null;
                head.right=null;
            }
            else
            {
                int p=in.nextInt();
                node b=new node();
                b.val=p;
                b.right=null;
                b.left=null;
                node d=head;
                while (true)
                {
                    if(b.val<d.val)
                    {
                        if (d.left==null){
                        d.left=b;
                        break;
                    }
                    else
                        d=d.left;
                    }
                    if(b.val>d.val)
                    {
                        if (d.right==null){
                        d.right=b;
                        break;
                    }
                    else
                        d=d.right;
                    }
                }
                    
            }
            }
            if (t==4)
            break;
           if (t==3)
           {
               System.out.println("1.for inorder\n2.for preoder \n3.for postorder");
               int u=in.nextInt();
               if (u==1)
               inorder(head);
               if (u==2)
               preorder(head);
               if (u==3)
               postorder(head);
               System.out.println();
           }
        }
    }
}
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
            
