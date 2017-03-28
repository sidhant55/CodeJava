// Created by sidhant
//28/03/2017

//Basic Grapgh implementation to add and delete edges between the vertices using DDA

import java.util.*;

public class Graph_implementatn
{
    public static void main (String args[])
    {
        Scanner in=new Scanner (System.in);
        System.out.println("Enter number of vertices");
        int n=in.nextInt();
        int a[][]=new int [n][n];
        while (true)
        {
            System.out.println("1:insertion");
            System.out.println("2:removal");
            System.out.println("3:print");
            int d=in.nextInt();
            if (d==1)
            {
                System.out.println("Enter pair of vertices to form edge");
                int x=in.nextInt();
                int y=in.nextInt();
                a[x-1][y-1]=1;
                a[y-1][x-1]=1;
            }
            if (d==2)
            {
                System.out.println("Enter pair of vertices to remove edge");
                int x=in.nextInt();
                int y=in.nextInt();
                a[x-1][y-1]=0;
                a[y-1][x-1]=0;
            }
            if (d==3)
            {
                for (int i=0;i<n;i++)
                {
                    for (int j=0;j<n;j++)
                    System.out.print(a[i][j]);
                    System.out.println();
                }
            }
        }
    }
}
        
