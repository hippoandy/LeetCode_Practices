package app;

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Ugly Number.
// Memory Usage: 33.4 MB, less than 5.36% of Java online submissions for Ugly Number.
class Q263_ugly_num
{
    public boolean isUgly(int num)
    {
        if( num <= 0 ) return false;
        if( num == 1 ) return true;
        
        if( num % 2 == 0 ) return isUgly( num >> 1 );
        if( num % 3 == 0 ) return isUgly( num / 3 );
        if( num % 5 == 0 ) return isUgly( num / 5 );
        return false;
    }
}