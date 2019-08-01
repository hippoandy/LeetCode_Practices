package app;

import java.util.*;

// Runtime: 10 ms, faster than 20.07% of Java online submissions for Encode and Decode TinyURL.
// Memory Usage: 36.3 MB, less than 99.78% of Java online submissions for Encode and Decode TinyURL.
class Q535_encode_and_decode_tinyurl
{
    public class Codec
    {
        Map<String, String> map = new HashMap<String, String>();
        String candi = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String domain = "http://tinyurl.com/";
        int keyLen = 8;
        
        Random rand = new Random();

        private String genKey()
        {
            int count = 0;
            String key = "";
            while( count < keyLen )
            {
                int c = rand.nextInt( candi.length() );
                key += candi.substring( c, c+1 );
                count++;
            }
            return key;
        }
        
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl)
        {
            String key = genKey();
            // if the key has been generated before, re-generate the key
            while( map.containsKey( key ) ) key = genKey();
            map.put( key, longUrl );
            return domain + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl)
        {
            return map.get( shortUrl.replace( domain, "" ) );
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
}