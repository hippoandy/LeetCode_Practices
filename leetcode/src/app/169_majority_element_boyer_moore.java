package app;

class Solution {
    public int majorityElement(int[] nums)
    {
        int count = 0, major = nums[ 0 ];
        for( int e : nums )
        {
            if( e != major )
                count--;
            if( e == major )
                count++;
            if( count == 0 )
            {
                major = e;
                count++;
            }
        }
        return major;
    }
}