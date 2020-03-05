//2020-03-05 18:13:01
class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i=0; i<len/2; i++){
            char temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
        }
    }
}
//2020-03-05 18:14:47