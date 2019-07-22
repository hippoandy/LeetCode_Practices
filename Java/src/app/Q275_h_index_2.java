package app;

class Q275_h_index_2
{
    // Given a sorted list citations of size n in ascending order, one is asked to find the first number citations[i] which meets the constraint of citations[i] >= n - i.
    public int hIndex(int[] citations)
    {
        int idx = 0, n = citations.length;
        int left = 0, right = n - 1;
        int pivot = 0;
        while( left <= right )
        {
            pivot = (left + right) / 2;
            if( citations[ pivot ] == n - pivot ) return n - pivot;
            else if( citations[ pivot ] < n - pivot ) left = pivot + 1;
            else right = pivot - 1;
        }
        return n - left;
    }
}