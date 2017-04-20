//Created by sidhant
//03-04-2017

/*
Input 	
4
hi
yes
foo  bar
output
hello world	Case #1: 44 444
Case #2: 999337777
Case #3: 333666 6660 022 2777
Case #4: 4433555 555666096667775553
*/

import java.util.*;
public class keypad
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of cases");
        char ch2,ch1,ch,ch3;
        int l,l1,c,o;
        String y,f="";
        int x=sc.nextInt();
        String a[]={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i=1;i<=x;i++)
        {
            System.out.println("Enter the sentence");
            y=sc.nextLine();
            l=y.length();
            for(int j=0;j<l-1;j++)
            {
                ch1=y.charAt(j);
                
                ch2=y.charAt(j+1);

                for(int k=0;k<10;k++)
                {
                    l1=a[k].length();

                    for(int m=0;m<l1;m++)
                    {

                        ch=a[k].charAt(m);
                        if(ch==ch1)
                            {
                            for(int n=0;n<=m;n++)
                            f=f+k;
                            for(int n=0;n<=m;n++)
                            {
                                ch3=a[k].charAt(n);
                                if(ch2==ch3)
                                f=f+' ';
                            }
                            }
                    }
                }
        }
        System.out.println(f);
        f="";
    }
}
}
