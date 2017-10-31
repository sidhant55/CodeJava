package Data_Structure;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.security.auth.login.AccountExpiredException;
import java.util.*;
class suffix
{
    int index;
    int r0;
    int r1;
}
class Comp implements Comparator<suffix>
{

    @Override
    public int compare(suffix a, suffix b) {
        return (a.r0 == b.r0)? (a.r1 < b.r1 ?-1:1): (a.r0 < b.r0 ?-1:1);
    }
}
public class SuffixArray {
    static int[] builArr(String x, int l)
    {
        suffix arr[]=new suffix[l];
        for (int i=0;i<l;i++)
        {
            suffix obj=new suffix();

            obj.index=i;
            obj.r0=x.charAt(i)-'a';
            obj.r1=((i+1) < l)? (x.charAt(i+1) - 'a'): -1;
            arr[i]=obj;
        }
        Arrays.sort(arr, new Comp());
        int ind[]=new int [l];
        for (int k=4;k<2*l;k=k*2)
        {
            int rank=0;
            int prank=arr[0].r0;
            arr[0].r0=rank;
            ind[arr[0].index]=0;
            for (int i=1;i<l;i++)
            {
                if (arr[i].r0==prank && arr[i].r1==arr[i-1].r1)
                {
                    prank=arr[i].r0;
                    arr[i].r0=rank;
                }
                else
                {
                    prank=arr[i].r0;
                    arr[i].r0=++rank;
                }
                ind[arr[i].index]=i;
            }
            for (int i=0;i<l;i++)
            {
                int nxtind=arr[i].index+k/2;
                arr[i].r1=(nxtind<l)?arr[ind[nxtind]].r0:-1;
            }
            Arrays.sort(arr, new Comp());
        }
        int ans[]=new int[l];
        for (int i=0;i<l;i++)
        ans[i]=arr[i].index;
        return ans;
    }

    static void search (String pat, String txt, int arr[], int n)
    {
        int m=pat.length();
        int l=0,r=n-1;
        while (l<=r)
        {
            int mid=l+(r-l)/2;
            String z=((txt.substring(arr[mid])).length()<=m)?(txt.substring(arr[mid])):(txt.substring(arr[mid]).substring(0,m));
            int res=z.compareTo(pat);
            System.out.println(mid+" "+z+" "+res);
            if (res==0)
            {
                System.out.println("Found"+arr[mid]);
                return;
            }
            if (res>0) r=mid-1;
            else l=mid+1;
        }
        System.out.println("Not Found");
    }
    public static void main(String args[]) {
        String x="abcdefgefgxyz";
        int l=x.length();
        int arr[]=builArr(x,l);
        for (int i=0;i<l;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        search("efgx", x,arr,l);
    }
}
