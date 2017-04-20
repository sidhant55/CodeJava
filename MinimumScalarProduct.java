//Created by Sidhant
//3-04-2017
//Implementation of minimum scalar product

import java.util.*;
public class min
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number of cases");
        int x=in.nextInt();
        int n,temp,sum=0;
        for(int i=0;i<x;i++)
        {
            sum=0;
            n=in.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int j=0;j<n;j++)
            {

                a[j]=in.nextInt();
            }
            for(int j=0;j<n;j++)
            {

                b[j]=in.nextInt();
            }
            for(int j=0;j<n-1;j++)
            {

                for(int k=j+1;k<n;k++)
                {
                    if(a[j]>a[k])
                    {
                    temp=a[j];
                    a[j]=a[k];
                    a[k]=temp;
                }
                if(b[j]<b[k])
                    {
                    temp=b[j];
                    b[j]=b[k];
                    b[k]=temp;
                }
                }
            }
                for(int j=0;j<n;j++)
            {
              //  System.out.println(a[j]);
            sum=sum+(a[j]*b[j]);   
        }
         System.out.println(sum);
            }

    }
    }
