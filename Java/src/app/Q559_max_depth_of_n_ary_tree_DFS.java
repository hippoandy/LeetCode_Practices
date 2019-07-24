// ref. https://leetcode.com/problems/maximum-depth-of-n-ary-tree/discuss/167010/DFS-and-BFS-solutions-in-C%2B%2B.

package app;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// class Solution {
//     public int maxDepth(Node root)
//     {
//         if( root == null ) return 0;
        
//         Queue<Node> queue = new LinkedList<Node>();
//         queue.offer( root );
//         int level = 0;
//         while( !queue.isEmpty() )
//         {
//             int len = queue.size();
//             for( int i = 0; i < len; i++ )
//             {
//                 Node cur = queue.remove();
//                 if( cur.children != null )
//                     for( Node n: cur.children )
//                         queue.offer( n );
//             }
//             level++;
//         }
        
//         return level;
//     }
// }

class Q559_max_depth_of_n_ary_tree_DFS
{
    public int maxDepth(Node root)
    {
        if( root == null ) return 0;
        
        int level = 0;
        for( Node n: root.children ) level = Math.max( level, maxDepth( n ) );
        return level + 1;
    }

    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}