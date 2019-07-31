// ref. https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms

package app;

class Q415_add_strs
{
    public String addStrings(String num1, String num2)
    {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for(
            int i = num1.length()-1, j = num2.length()-1;
            i >= 0 || j >= 0 || carry == 1;
            i--, j--
        )
        {
            int a = (i < 0) ? 0 : num1.charAt( i ) - '0';
            int b = (j < 0) ? 0 : num2.charAt( j ) - '0';
            int c = (carry + a + b);
            ans.append( c % 10 );
            carry = c / 10;
        }
        return ans.reverse().toString();
    }
}