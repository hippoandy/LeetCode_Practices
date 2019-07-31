// ref. https://leetcode.com/problems/validate-ip-address/discuss/95504/Java-Simple-Solution-with-RegExp

package app;

// Runtime: 6 ms, faster than 8.21% of Java online submissions for Validate IP Address.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Validate IP Address.
class Q468_validate_ip_addr
{
    public String validIPAddress(String IP)
    {
        if( IP.matches( "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])" ) )
            return "IPv4";
        if( IP.matches( "(([0-9a-fA-F]{1,4})\\:){7}([0-9a-fA-F]{1,4})" ) )
            return "IPv6";

        return "Neither";
    }
}