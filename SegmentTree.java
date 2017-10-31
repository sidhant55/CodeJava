/*
Segment Tree
Point Update
Range sum query
Rannge minimum query
 */

package Data_Structure;

class SegmentTree {
    int st[];

    SegmentTree(int arr[], int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, 0);
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se)
            return st[si];
        if (se < qs || ss > qe)
            return 0;
        int mid = ss + (se - ss) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se)
            return;
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = ss + (se - ss) / 2;
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }

    void updateValue(int arr[], int n, int i, int new_val) {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }
        int diff = new_val - arr[i];
        arr[i] = new_val;
        updateValueUtil(0, n - 1, i, diff, 0);
    }

    int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    int minVal(int x, int y) {
        return (x < y) ? x : y;
    }

    int RMQUtil(int ss, int se, int qs, int qe, int index)
    {
        // If segment of this node is a part of given range, then
        // return the min of the segment
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range
        int mid = ss + (se - ss) / 2;
        return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    // Return minimum of elements in range from index qs (quey
    // start) to qe (query end).  It mainly uses RMQUtil()
    int RMQ(int n, int qs, int qe)
    {
        // Check for erroneous input values
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr, n);

        System.out.println("Sum of values in given range = " +
                tree.getSum(n, 1, 3));

        tree.updateValue(arr, n, 1, 10);

        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                tree.getSum(n, 1, 3));

        int qs = 1;
        int qe = 5;

        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.RMQ(n, qs, qe));
    }
}
