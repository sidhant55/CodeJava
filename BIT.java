/*
Binary Index Tree
Range update
Range sum query

 */

package Data_Structure;

public class BIT {
    static int[] constructBITree(int arr[],int n)
    {
        int BIT[]=new int [n+1];
        for (int i=1;i<=n;i++)
            BIT[i]=0;
        for (int i=0; i<n; i++)
            updateBIT(BIT, n, i, arr[i]);
        return BIT;
    }

    static void updateBIT(int BIT[], int n, int index, int val)
    {
        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;
        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
            // Add 'val' to current node of BI Tree
            BIT[index] += val;
            // Update index to that of parent in update View
            index += index & (-index);
        }
    }

    static int getSum(int BIT[], int index)
    {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index>0)
        {
            // Add current element of BITree to sum
            sum += BIT[index];

            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    // Updates such that getElement() gets an increased
// value when queried from l to r.
    static void update(int BIT[], int l, int r, int n, int val)
    {
        // Increase value at 'l' by 'val'
        updateBIT(BIT, n, l, val);

        // Decrease value at 'r+1' by 'val'
        updateBIT(BIT, n, r+1, -val);
    }



    public static void main(String args[]) {
        int arr[]={0,0,0,0,0};
        int n=arr.length;
        int BIT[]=constructBITree(arr, n);

        //updateBIT(BIT,n+1,0,1);
        update(BIT,0,n,n,1);

        for (int i=0;i<n;i++)
            System.out.print(getSum(BIT,i));

        int l = 0, r = 1, val = 1;
        update(BIT, l, r, n, val);

        System.out.println();

        for (int i=0;i<n;i++)
            System.out.print(getSum(BIT,i));



        l = 3;r = 4; val = 1;
        update(BIT, l, r, n, val);

        System.out.println();

        for (int i=0;i<n;i++)
            System.out.print(getSum(BIT,i));


        l = 0; r = 4; val = 1;
        update(BIT, l, r, n, val);

        System.out.println();

        for (int i=0;i<n;i++)
            System.out.print(getSum(BIT,i));




    }
}
