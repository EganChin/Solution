//begin at 2020-03-05 17:56:15
class Solution {

    int []src = new int[26];
    int []tag = new int[26];

    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length != tc.length)
            return false;
        for(int i=0; i<sc.length; i++){
            src[sc[i]-'a']++;
            tag[tc[i]-'a']++;
        }
        for(int i=0; i<26; i++){
            if(src[i]!=tag[i]) return false;
        }
        return true;
    }
}

//finish at 2020-03-05 18:00:59