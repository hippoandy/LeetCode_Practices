// ref. https://leetcode.com/problems/defanging-an-ip-address/discuss/332184/Java-Solution

package app;

import java.util.*;

class Q1108_defanging_an_ip_addr
{
    // public String defangIPaddr(String address)
    // {
    //     Queue<Character> queue = new LinkedList<Character>();
    //     String sol = "";
    //     for( int i = 0; i < address.length(); i++ )
    //     {
    //         char c = address.charAt( i );
    //         if( c != '.' ) queue.add( c );
    //         else
    //         {
    //             while( !queue.isEmpty() )   sol = sol + Character.toString( queue.remove() );
    //             sol += "[.]";
    //         }
    //     }
    //     while( !queue.isEmpty() )   sol = sol + Character.toString( queue.remove() );
    //     return sol;
    // }

    // simplified
    public String defangIPaddr(String address)
    {
        String sol = "";
        for( int i = 0; i < address.length(); i++ )
        {
            char c = address.charAt( i );
            if( c == '.' )  sol += "[.]";
            else            sol += c;
        }
        return sol;
    }
}