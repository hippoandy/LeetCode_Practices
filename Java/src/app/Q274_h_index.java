// ref. https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation

package app;

class Q274_h_index
{
    public int hIndex(int[] citations)
    {
        int n = citations.length;
        int[] bucket = new int[ n+1 ];
        
        // count
        for( int c: citations )
        {
            if( c >= n )    bucket[ n ]++;
            else            bucket[ c ]++;
        }
        
        // get h-index
        // Then we iterate from the back to the front of the buckets, whenever the total count exceeds the index of the bucket, meaning that we have the index number of papers that have reference greater than or equal to the index.
        // The reason to scan from the end of the array is that we are looking for the greatest h-index.
        int h = 0;
        for( int i = n; i >= 0; i-- )
        {
            h += bucket[ i ];
            if( h >= i ) return i;
        }
        return 0;
    }
}