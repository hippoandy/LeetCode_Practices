/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution
{
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int l = 0;
    int r = 0;

    public List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( root == null ) return ans;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> col = new LinkedList<Integer>();
        q.offer( root );
        col.offer( 0 );
        while( !q.isEmpty() )
        {
            TreeNode cur = q.remove();
            int pos = col.remove();
            
            if( !map.containsKey( pos ) )
                map.put( pos, new ArrayList<Integer>() );
            map.get( pos ).add( cur.val );
            
            if( cur.left != null )
            {
                q.offer( cur.left );
                col.offer( pos-1 );
                l = (pos-1 < l) ? pos-1 : l;
            }
            if( cur.right != null )
            {
                q.offer( cur.right );
                col.offer( pos+1 );
                r = (pos+1 > r) ? pos+1 : r;
            }
        }

        // compute the answer
        for( int i = l; i <= r; i++ ) ans.add( map.get( i ) );
        return ans;
    }
}