// ref. https://leetcode.com/problems/valid-perfect-square/discuss/83889/Java-Binary-Search-Solution-(-the-obvious-one)

package app;

class Q367_valid_perfect_square
{
    public boolean isPerfectSquare(int num)
    {
        if( num < 1 ) return false;
        long left = 1, right = num;
        
        while( left <= right )
        {
            long mid = left + (right - left) / 2;
            if( mid * mid == num ) return true;
            else if( mid * mid < num )
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}