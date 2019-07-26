package app;

class Q303_range_sum_query_immutable_BF
{
    int[] nums;
    public Q303_range_sum_query_immutable_BF(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j)
    {
        if( this.nums == null )                      throw null;
        if( this.nums.length == 0 )                  throw null;
        if( i < 0 || i > j || j > this.nums.length ) throw null;
        int sum = 0;
        for( int idx = i; idx <= j; idx++ )
        {
            sum += nums[ idx ];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */