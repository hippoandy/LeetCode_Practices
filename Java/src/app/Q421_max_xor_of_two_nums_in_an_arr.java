// ref. https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91059/Java-O(n)-solution-using-Trie
// ref. [Flip a bit] https://stackoverflow.com/questions/2411023/most-elegant-way-to-change-0-to-1-and-vice-versa

package app;

class Q421_max_xor_of_two_nums_in_an_arr
{
    public int findMaximumXOR(int[] nums)
    {
        TrieNode root = new TrieNode();
        // build the trie
        TrieNode ptr;
        for( int n: nums )
        {
            ptr = root;
            for( int j = 31; j >= 0; j-- )
            {
                int bit = (n >> j) & 1;
                if( !ptr.containsKey( bit ) )
                    ptr.put( bit, new TrieNode() );
                ptr = ptr.get( bit );
            }
            ptr.setEnd( n );
        }
        
        // try to find the best number to XOR
        int max = Integer.MIN_VALUE;
        for( int n: nums )
        {
            // for each number, find the number
            ptr = root;
            for( int j = 31; j >= 0; j-- )
            {
                int bit = (n >> j) & 1;
                // Runtime: 51 ms, faster than 30.16% of Java online submissions for Maximum XOR of Two Numbers in an Array.
                // Memory Usage: 54.5 MB, less than 17.55% of Java online submissions for Maximum XOR of Two Numbers in an Array.
                // switch( bit )
                // {
                // case 1:
                //     if( ptr.containsKey( 0 ) )
                //         ptr = ptr.get( 0 );
                //     else
                //         ptr = ptr.get( bit );
                //     break;
                // case 0:
                //     if( ptr.containsKey( 1 ) )
                //         ptr = ptr.get( 1 );
                //     else
                //         ptr = ptr.get( bit );
                //     break;
                // }

                // logic improved
                // Runtime: 49 ms, faster than 34.77% of Java online submissions for Maximum XOR of Two Numbers in an Array.
                // Memory Usage: 53 MB, less than 19.08% of Java online submissions for Maximum XOR of Two Numbers in an Array.
                if( ptr.containsKey( bit ^ 1 ) ) // xor 1 will flip the bit
                    ptr = ptr.get( bit ^ 1 );
                else
                    ptr = ptr.get( bit );
            }

            if( ptr.isEnd() )
            {
                int val = ptr.getNum();
                max = Math.max( (n ^ val), max );
            }
        }
        return max;
    }
    
    private class TrieNode
    {
        private TrieNode[] links;
        private int num;
        private boolean isEnd;
        
        public TrieNode()
        {
            this.links = new TrieNode[ 2 ]; // 0 or 1
            this.num = 0;
            this.isEnd = false;
        }
        
        public void put( int idx, TrieNode n )
        {
            this.links[ idx ] = n;
        }
        
        public boolean containsKey( int idx )
        {
            if( this.links[ idx ] == null ) return false;
            return true;
        }
        
        public TrieNode get( int idx )
        {
            return this.links[ idx ];
        }
        
        public void setEnd( int num )
        {
            this.isEnd = true;
            this.num = num;
        }
        
        public boolean isEnd()
        {
            return this.isEnd;
        }
        
        public int getNum()
        {
            if( this.isEnd ) return this.num;
            throw null;
        }
    }
    
    // debug
    // private void inorder( TrieNode root )
    // {
    //     if( root.containsKey( 0 ) ) inorder( root.get( 0 ) );
    //     if( root.containsKey( 1 ) ) inorder( root.get( 1 ) );
        
    //     if( root.isEnd() )
    //         System.out.println( root.getNum() );
    // }
}