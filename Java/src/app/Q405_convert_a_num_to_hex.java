// ref. https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/89253/Simple-Java-solution-with-comment
// ref. https://stackoverflow.com/questions/19058859/what-does-mean-in-java/19058871

package app;

class Q405_convert_a_num_to_hex
{
    public String toHex(int num)
    {
        if( num == 0 ) return "0";

        char[] map = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
        
        StringBuilder sb = new StringBuilder();
        while( num != 0 )
        {
            // int q = num % 16;
            // sb.append( map[ q ] );
            
            // works as x % 16
            sb.insert( 0, map[ num & 15 ] );
            
            // ">>>" unsigned bitwise shift
            num = (num >>> 4);
        }
        
        return sb.toString();
    }
}