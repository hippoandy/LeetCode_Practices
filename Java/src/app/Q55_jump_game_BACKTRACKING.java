package app;

// Time Limit Exceeded!!
// Time complexity: O(2^n)
class Q55_jump_game_BACKTRACKING
{
    public boolean canJump(int[] nums)
    {
        if( nums == null ) return false;
        if( nums.length == 0 ) return true;

        return helper( nums, 0 );
    }
    
    private boolean helper( int[] nums, int cur )
    {
        if( cur >= nums.length-1 ) return true;

        int jumps = nums[ cur ];
        for( int j = jumps; j >= 1; j-- )
            if( helper( nums, cur + j ) )
                return true;
        
        return false;
    }
}