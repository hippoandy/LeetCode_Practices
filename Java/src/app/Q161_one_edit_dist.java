package app;

class Q161_one_edit_dist
{
    public boolean isOneEditDistance(String s, String t)
    {
        int len_s = s.length();
        int len_t = t.length();
        
        // ensure s is shorter than t
        if( len_s > len_t ) return isOneEditDistance( t, s );
        // if t is too long, they could not be 1 edit distance
        if( len_t - len_s > 1 ) return false;
        
        for( int i = 0; i < len_s; i++ )
        {
            if( s.charAt( i ) != t.charAt( i ) )
            {
                // tail should be the same
                if( len_s == len_t )
                    /* ex. s = abxcd
                     *     t = abycd
                     *           i
                     */
                    return s.substring( i+1 ).equals( t.substring( i+1 ) );
                else
                    /* ex. s = abcd
                     *     t = abycd
                     *           i
                     */
                    return s.substring( i ).equals( t.substring( i+1 ) );
            }
        }
        /* ex. s = abcd
         *     t = abcdy
         */
        return (len_s + 1 == len_t);
    }
}