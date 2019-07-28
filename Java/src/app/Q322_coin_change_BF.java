package app;

// Time Limit Exceeded!!
// Time complexity: O(S^n)
class Q322_coin_change_BF
{
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount)
    {
        if( helper( coins, amount, 0 ) )
            return (min == Integer.MAX_VALUE) ? -1 : min;
        else
            return -1;
    }
    
    private boolean helper( int[] coins, int amount, int count )
    {
        if( amount < 0 ) return false;
        else if( amount == 0 )
        {
            min = Math.min( min, count );
            return true;
        }
        else
            for( int i = 0; i < coins.length; i++ )
                helper( coins, amount - coins[ i ], count + 1 );
        return true;
    }
}