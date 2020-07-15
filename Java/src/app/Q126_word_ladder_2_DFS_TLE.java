package app;

import java.util.*;

class Q126_word_ladder_2_DFS_TLE
{
    List<List<String>> ans;
    int minPathLen = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)
    {
        ans = new ArrayList<List<String>>();
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        int idx = 0;
        for(String word: wordList)
            map.put(word, ++idx);
        
        Set<String> visited = new HashSet<String>();
        
        if(!map.containsKey(beginWord))
        {
            // to handle line 56: (map.get(current) < map.get(newWord))
            map.put(beginWord, -1);
        }
        
        List<String> tmp = new ArrayList<String>();
        tmp.add(beginWord);
        
        backtrack(wordList, map, visited, endWord, tmp, beginWord, 0);
        
        return ans;
    }
    
    public void backtrack(
        List<String> wordList, Map<String, Integer> map, Set<String> visited, String endWord,
        List<String> tmp, String current, int idx
    )
    {
        if(current.equals(endWord))
        {
            // finding the shortest path
            if(tmp.size() <= minPathLen)
            {
                minPathLen = tmp.size();
                
                // clear unwanted path
                List<List<String>> shorterPath = new ArrayList<List<String>>();
                for(List<String> l: ans)
                {
                    if(l.size() == minPathLen)
                        shorterPath.add(new ArrayList<String>(l));
                }
                
                shorterPath.add(new ArrayList<String>(tmp));
                ans = shorterPath;
            }

            return;
        }

        char[] candi = current.toCharArray();
        for(int j = 0; j < candi.length; j++)
        {
            char originalChar = candi[j];
            for(char c = 'a'; c <= 'z'; c++)
            {
                candi[j] = c;

                String newWord = new String(candi);

                if(wordList.contains(newWord) && !visited.contains(newWord))
                {
                    tmp.add(newWord);
                    visited.add(newWord);

                    backtrack(wordList, map, visited, endWord, tmp, newWord, map.get(newWord) + 1);

                    tmp.remove(tmp.size() - 1);
                    visited.remove(newWord);
                }
            }
            candi[j] = originalChar;
        }
    }
}