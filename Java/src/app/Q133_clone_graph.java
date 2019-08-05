// ref. https://leetcode.com/problems/clone-graph/discuss/42482/Java-BFS-solution

package app;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

// Runtime: 2 ms, faster than 50.73% of Java online submissions for Clone Graph.
// Memory Usage: 33.1 MB, less than 97.55% of Java online submissions for Clone Graph.
class Q133_clone_graph
{
    public Node cloneGraph( Node root )
    {
        if (root == null) return null;

        // use a map to save cloned nodes
        Map<Node, Node> map = new HashMap<Node, Node>();
        // clone the root
        map.put( root, createNewNode( root.val ) );

        // use a queue to help BFS
        Queue<Node> q = new LinkedList<Node>();
        q.add( root );
        while( !q.isEmpty() )
        {
            Node cur = q.remove();
            // handle the neighbors
            for( Node n : cur.neighbors)
            {
                if (!map.containsKey( n ) )
                {
                    // clone the neighbor
                    map.put( n, createNewNode( n.val ) );
                    // add it to the next level
                    q.offer( n );
                }
                // copy the neighbor
                map.get( cur ).neighbors.add( map.get( n ) );
            }
        }
        return map.get( root );
    }
    
    private Node createNewNode( int val )
    {
        Node n = new Node( val, new ArrayList<Node>());
        return n;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
    
        public Node() {}
    
        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}