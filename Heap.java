//Created by Sidhant
//27/03/2017

//Basic implementation of heap

import java.io.*;
import java.util.*;
public class Heap
{
    static int n;
    static void MaxHeapify(int a[], int i)
    {
        int l=2*i;
        int r=2*i+1;
        int largest;
        if (l<=n && a[l-1]>a[i-1])
        largest=l;
        else
        largest=i;
        if (r<=n && a[r-1]>a[largest-1])
        largest=r;
        if (largest!=i)
        {
            int temp=a[i-1];
            a[i-1]=a[largest-1];
            a[largest-1]=temp;
            MaxHeapify(a,largest);
        }
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner (System.in);
        System.out.println("Welcome");
        System.out.println("Enter size of the array");
        n=in.nextInt();
        int a[]=new int [n];
        System.out.println("Enter "+n+" elements");
        for (int i=0;i<n;i++)
        a[i]=in.nextInt();
        for (int i=n/2;i>=1;i--)
        {
            //System.out.println(i);
            MaxHeapify(a,i);
        }
        System.out.println();
        System.out.println("Building max heap");
        for (int i=0;i<n;i++)
        System.out.print(a[i]+" ");
        System.out.println();
        System.out.println("Heap Sort");
        for (int i=n;i>=1;i--)
        {
            System.out.print(a[0]+" ");
            int temp=a[0];
            a[0]=a[i-1];
            temp=a[i-1];
            n=n-1;
            MaxHeapify(a,1);
        }
        
    }
}
        
