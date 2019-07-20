package app;

import java.util.*;

class Q929_unique_email_addr
{
    public int numUniqueEmails(String[] emails)
    {
        Set<String> set = new HashSet<>();
        for (String email : emails)
        {
            // split into local and domain parts
            String[] parts = email.split( "@" );
            // split local by '+'
            // parts[ 0 ] = local name, parts[ 1 ] = domain name
            String[] local = parts[ 0 ].split( "\\+" );
            // remove all '.' before first '+', and concatenate '@' and domain
            set.add( local[ 0 ].replace( ".", "" ) + "@" + parts[ 1 ] );
        }
        return set.size();
    }
}