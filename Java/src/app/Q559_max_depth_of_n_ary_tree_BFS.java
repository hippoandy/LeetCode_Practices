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

// Runtime: 2 ms, faster than 27.55% of Java online submissions for Maximum Depth of N-ary Tree.
// Memory Usage: 44.5 MB, less than 87.57% of Java online submissions for Maximum Depth of N-ary Tree.
class Q559_max_depth_of_n_ary_tree_BFS
{
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root)
    {
        if( root == null ) return 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer( root );
        int level = 0;
        while( !queue.isEmpty() )
        {
            int len = queue.size();
            for( int i = 0; i < len; i++ )
            {
                Node cur = queue.remove();
                if( cur.children != null )
                    for( Node n: cur.children )
                        queue.offer( n );
            }
            level++;
        }
        
        return level;
    }
}