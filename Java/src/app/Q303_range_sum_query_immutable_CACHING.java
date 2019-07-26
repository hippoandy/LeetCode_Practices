package app;

class Q303_range_sum_query_immutable_CACHING
{
    int[] nums;
    int[] sum;
    public Q303_range_sum_query_immutable_CACHING(int[] nums) {
        this.sum = new int[ nums.length+1 ];
        for( int i = 0; i < nums.length; i++ )
            // store the sum from 0 to k
            sum[ i + 1 ] = sum[ i ] + nums[ i ];
        this.nums = nums;
    }
    
    public int sumRange(int i, int j)
    {
        if( this.nums == null )                      throw null;
        if( this.nums.length == 0 )                  throw null;
        if( i < 0 || i > j || j > this.nums.length ) throw null;
        // int sum = 0;
        // for( int idx = i; idx <= j; idx++ )
        // {
        //     sum += nums[ idx ];
        // }
        // return sum;
        
        return sum[ j + 1 ] - sum[ i ];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */