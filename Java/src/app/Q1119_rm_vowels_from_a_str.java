package app;

class Q1119_rm_vowels_from_a_str
{
    public String removeVowels(String S)
    {
        return S.replaceAll( "[aeiouAEIOU]", "" );
    }
}