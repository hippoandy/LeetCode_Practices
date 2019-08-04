package app;

class Q268_missing_num
{
    // HashSet
    // Time complexity: O(n)
    // Space complexity: O(n)
    // public int missingNumber(int[] nums)
    // {
    //     Set<Integer> set = new HashSet<Integer>();
    //     for( int n: nums )
    //         set.add( n );
    //     for( int i = 0; i <= nums.length; i++ )
    //         if( !set.contains( i ) )
    //             return i;
    //     throw null;
    // }

    // Gauss's formula
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int missingNumber(int[] nums)
    {
        // sum of continuous number = n * (n + 1) / 2
        int excepted = nums.length * (nums.length + 1) / 2;
        int actual = 0;
        for( int n: nums ) actual += n;
        return excepted - actual;
    }
}