// ref. https://leetcode.com/problems/n-ary-tree-level-order-traversal/discuss/134911/Java-Solution

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
class Q429_n_ary_tree_level_order
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

    // public List<List<Integer>> levelOrder(Node root)
    // {
    //     List<List<Integer>> sol = new ArrayList<List<Integer>>();
    //     if( root == null ) return sol;
        
    //     List<Node> this_level = new ArrayList<Node>();
    //     this_level.add( root );
    //     while( true )
    //     {
    //         List<Integer> level = new ArrayList<Integer>();
    //         List<Node> next_level = new ArrayList<Node>();
    //         for( Node n: this_level )
    //         {
    //             level.add( n.val );
    //             if( n.children.size() != 0 )
    //                 for( Node c: n.children )
    //                     next_level.add( c );
    //         }
    //         sol.add( level );
    //         this_level = new ArrayList<Node>( next_level );
    //         if( this_level.size() == 0 ) break;
    //     }
    //     return sol;
    // }

    // logic improved
    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        if( root == null ) return sol;
        
        Queue<Node> queue = new LinkedList<Node>();        
        queue.offer( root );
        while( !queue.isEmpty() )
        {
            List<Integer> cur_level = new LinkedList<>();
            // this will memorize the num of node for each level!
            int len = queue.size();
            for( int i = 0; i < len; i++ )
            {
                Node cur = queue.poll();
                cur_level.add( cur.val );
                for( Node n : cur.children ) queue.offer( n );
            }
            sol.add( cur_level );
        }
        return sol;
    }
}