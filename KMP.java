package Data_Structure;

import java.util.*;

public class KMP {
    void Search(String patern, String text)
    {
        int l1=patern.length();
        int l2=text.length();

        int lps[]=new int [l1];

        createLPS(patern, l1,lps);
        int i;
        for ( i=0;i<l1;i++)
        System.out.print(lps[i]+" ");
        System.out.println();
        i=0;
        int j=0;
        while(i<l2)
        {
            if (patern.charAt(j)==text.charAt(i))
            {
                j++;
                i++;
            }
            if (j==l1)
            {
                System.out.print("Found "+(i-j));
                j=lps[j-1];
            }
            else if (i<l2 && patern.charAt(j)!=text.charAt(i))
            {
                if (j!=0)
                    j=lps[j-1];
                else
                    i=i+1;
            }
        }
    }

    void createLPS(String patern, int l, int lps[])
    {
        int len=0;
        int i=1;
        lps[0]=0;

        while (i<l)
        {
            if (patern.charAt(i)==patern.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if (len!=0)
                    len=lps[len-1];
                else
                {
                    lps[i]=len;
                    i++;
                }
            }

        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String txt = "ABACABABA";
        String pat = "ABA";
        new KMP().Search(pat,txt);
    }
}
