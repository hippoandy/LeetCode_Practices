// ref. https://leetcode.com/problems/detect-capital/discuss/99298/Java-1-Liner
// ref. [REGEX CHEAT SHEET] https://www.rexegg.com/regex-quickstart.html

package app;

class Q520_detect_capital_REGEX
{
    public boolean detectCapitalUse(String word)
    {
        // "?": once or none
        return word.matches( "[A-Z]*|[A-Z]?[a-z]*" );
    }
}