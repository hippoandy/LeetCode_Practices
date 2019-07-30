// ref. https://leetcode.com/problems/reverse-words-in-a-string/discuss/47706/My-accepted-Java-solution

package app;

class Q151_reverse_words_in_a_str
{
    public String reverseWords(String s)
    {
        String[] words = s.trim().split( "\\s+" );
        String ans = "";
        for( int i = words.length-1; i >= 0; i-- )
        {
            ans = (i > 0) ? ans + words[ i ] + " " : ans + words[ i ];
        }
        return ans;
    }
}