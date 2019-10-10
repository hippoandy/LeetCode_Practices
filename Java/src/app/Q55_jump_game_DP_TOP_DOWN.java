package app;

enum Memo
{
    GOOD, BAD, UNKNOWN
}

// Runtime: 710 ms, faster than 7.71% of Java online submissions for Jump Game.
// Memory Usage: 40.9 MB, less than 52.51% of Java online submissions for Jump Game.

// Time complexity: O(n^2)
public class Q55_jump_game_DP_TOP_DOWN
{
    Memo[] memo;

    public boolean canJump(int[] nums)
    {
        if( nums == null ) return false;
        if( nums.length == 0 ) return true;

        // memo init
        memo = new Memo[ nums.length ];
        for( int i = 0; i < nums.length; i++ )
            memo[ i ] = Memo.UNKNOWN;
        // the last index should always be good
        memo[ nums.length-1 ] = Memo.GOOD;
        
        return helper( nums, 0 );
    }
    
    private boolean helper( int[] nums, int cur )
    {
        if( cur >= nums.length-1 ) return true;
        if( memo[ cur ] != Memo.UNKNOWN )
            return memo[ cur ] == Memo.GOOD ? true : false;

        int jumps = nums[ cur ];
        for( int j = jumps; j >= 1; j-- )
            if( helper( nums, cur + j ) )
            {
                memo[ cur ] = Memo.GOOD;
                return true;
            }
        // not able to reach the end
        // if it is good, the funct will return in the for loop
        memo[ cur ] = Memo.BAD;
        return false;
    }
}