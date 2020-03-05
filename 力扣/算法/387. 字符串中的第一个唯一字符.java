// begin at 2020-03-05 18:04:41
class Solution {
    int []stat = new int[26];
    public int firstUniqChar(String s) {
        for(char ch : s.toCharArray()){
            stat[ch-'a']++;
        }
        char []ch  = s.toCharArray();
        for(int i =0; i<ch.length; i++){
            if(stat[ch[i]-'a'] == 1) return i;
        }
        return -1;
    }
}

//finish at 2020-03-05 18:09:56